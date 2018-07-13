package org.dataone.metadata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.dataone.parser.DataOneXMLParser;
import org.xml.sax.SAXException;





public class DataOneMapper
{	
	
	
	/*
	 *
	 *  public Map<String, List<String>> metadataMap = new HashMap<String, List<String>>();
		public List<String> titles = new ArrayList<String>();
		public List<String> spatial = new ArrayList<String>();
		public List<String> abstracts = new ArrayList<String>();
		public List<String> authors = new ArrayList<String>();
		public List<String> keywords = new ArrayList<String>();
	
	public DataOneMapper() {
		metadataMap.put("title",addTitles());
		metadataMap.put("abstract",addAbstracts());
		metadataMap.put("keyword",addKeywords());
		metadataMap.put("spatial",addSpatial());

	}
	private List<String> addTitles() {	
		titles.add("title");
		return titles;
	}
	
	private List<String> addAbstracts() {
		abstracts.add("abstract");
		//abstracts.add(Eml211.ABSTRACT.toString());
		return abstracts;
	}
	
	
	private List<String> addKeywords() {
		
		keywords.add("keywords");
		//keywords.add(Eml211.KEYWORDS.toString());
		return keywords;
	}
	
	private List<String> addSpatial() {
		
		spatial.add("spatial");
		spatial.add("boundingcoordinates");
		spatial.add("westBoundingCoordinate");
		spatial.add("eastBoundingCoordinate");
		spatial.add("northBoundingCoordinate");
		spatial.add("southBoundingCoordinate");
		
		//keywords.add(Eml211.KEYWORDS.toString());
		return spatial;
	}
	
	*/

	public File configFile;
	public DataOneXMLParser configParser; 
	
	public DataOneMapper() {
		configFile = new File("configFiles.xml");
		configParser = new DataOneXMLParser();
		
	}

	public String getXpath(String fileType) throws SAXException, IOException, ParserConfigurationException {
		String xPath="" ; 
		if ( fileType.contains("eml-2.1.1")) {
			 xPath = "//FileFormats/FileFormat[@name='eml']/*";
		}
		else if ( fileType.contains("onedcx")){
			 xPath = "//FileFormats/FileFormat[@name='onedcx']/*";
		}
		else {
			 xPath ="Default"; 
		}
		return xPath;
	}
	
	public Object[] getMetadataList(String xPath) throws SAXException, IOException, ParserConfigurationException {
		
		List<String>  dataField = new ArrayList<String>();
		List<String>  dataValue = new ArrayList<String>();
		
		if (xPath.contains("//")){
			//System.out.println(field);
			Object[] metaDataObj = configParser.getXpathData(configFile, xPath);
		
			dataField.addAll((Collection<? extends String>) metaDataObj[0]);
			dataValue.addAll((Collection<? extends String>) metaDataObj[1]);
		}
		else 
		{
			//System.out.println(field);
			Object[] metaDataObj =configParser.getMetadata(configFile,xPath);
		}
		return new Object[] {dataField, dataValue};
	}
	
	public List<String> getTikaParser(File file) throws SAXException, IOException, ParserConfigurationException, TikaException {
		
      //Parser method parameters
      Parser parser = new AutoDetectParser();
      //Parser parser = new dataone_onedcx();
      BodyContentHandler handler = new BodyContentHandler();
      
      Metadata metadata = new Metadata();
      FileInputStream inputstream = new FileInputStream(file);
      ParseContext context = new ParseContext();
      
      parser.parse(inputstream, handler, metadata, context);

      List<String> metaData = new ArrayList(); 
      for(String name : metadata.names()) {		        
         metaData.add(name + ": " + metadata.get(name));
         
      }
      return metaData;
	}
	
	public  Object[]  getMetaDataVal(File file, List<String> metaDataFields) throws SAXException, IOException, ParserConfigurationException {
		DataOneXMLParser contentParser = new DataOneXMLParser();

		List<String>  dataField = new ArrayList<String>();
		List<String>  dataValue = new ArrayList<String>();
		
		
		for (int index =1 ; index < metaDataFields.size(); index++) {
			String field = metaDataFields.get(index).trim();
			
			if (field.contains("//")){
				//System.out.println(field);
				Object[] metaDataObj = contentParser.getXpathData(file,field);
				dataField.addAll((Collection<? extends String>) metaDataObj[0]);
				dataValue.addAll((Collection<? extends String>) metaDataObj[1]);
			}
			else 
			{
				//System.out.println(field);
				Object[] metaDataObj =contentParser.getMetadata(file,field);
			}
			
		}
		
		return new Object[] {dataField, dataValue};
	}
}