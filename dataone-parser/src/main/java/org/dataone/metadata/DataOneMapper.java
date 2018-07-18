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
import javax.xml.xpath.XPathExpressionException;

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
	public File configFile;
	public DataOneXMLParser configParser; 
	
	public DataOneMapper() {
		configFile = new File("configFiles.xml");
		configParser = new DataOneXMLParser();
		
	}

	public String getXpath(String fileType) throws SAXException, IOException, ParserConfigurationException {
		String xPath="" ; 
		if ( fileType.contains("eml-2.1.1")) {
			 xPath = "//FileFormats/FileFormat[@name='eml-211']/*";
		}
		else if ( fileType.contains("eml-2.1.0")){
			 xPath = "//FileFormats/FileFormat[@name='eml-210']/*";
		}
		else if ( fileType.contains("eml-2.0.1")){
			 xPath = "//FileFormats/FileFormat[@name='eml-201']/*";
		}
		else if ( fileType.contains("eml-2.0.0")){
			 xPath = "//FileFormats/FileFormat[@name='eml-200']/*";
		}
		else if ( fileType.contains("schema/onedcx/v")){
			 xPath = "//FileFormats/FileFormat[@name='onedcx']/*";
		}
		else if ( fileType.contains("FGDC-STD-001-1998")){
			 xPath = "//FileFormats/FileFormat[@name='fgdc-001-1998']/*";
		}
		else if ( fileType.contains("openarchives.org")){
			 xPath = "//FileFormats/FileFormat[@name='openarchives']/*";
		}
		else if (fileType.contains("isotc211.org") && fileType.endsWith("gmd\"")){
			 xPath = "//FileFormats/FileFormat[@name='isotc211']/*";
 		}
		else if (fileType.contains("isotc211.org") && fileType.endsWith("gmd-noaa\"")){
			 xPath = "//FileFormats/FileFormat[@name='isotc211-gmd-noaa']/*";
		}
		else if (fileType.contains("isotc211.org") && fileType.endsWith("gmd-noaa\"")){
			 xPath = "//FileFormats/FileFormat[@name='isotc211-gmd-noaa']/*";
		}
		else if (fileType.contains("isotc211.org") && fileType.endsWith("gmd-pangaea\"")){
			 xPath = "//FileFormats/FileFormat[@name='isotc211-gmd-pangaea']/*";
		}
		else if (fileType.contains("mercury/terms")){
			 xPath = "//FileFormats/FileFormat[@name='mercury']/*";
		}
		else if (fileType.contains("datadryad.org") ){
			 xPath = "//FileFormats/FileFormat[@name='datadryad']/*";
		}
		else {
			 xPath ="Default"; 
		}
		return xPath;
	}
	
	public Object[] getMetadataList(String xPath) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		
		//Map<String, String> PREF_MAP = new HashMap<String, String>();
		List<String>  dataField = new ArrayList<String>();
		List<String>  dataValue = new ArrayList<String>();
		
		if (xPath.contains("//")){
			Object[] metaDataObj = configParser.getXpathData(configFile, xPath);
			dataField.addAll((Collection<? extends String>) metaDataObj[0]);
			dataValue.addAll((Collection<? extends String>) metaDataObj[1]);
		}
		else 
		{
			//System.out.println("Using Xpath:" + xPath);
			Object[] metaDataObj =configParser.getMetadata(configFile,xPath);
			dataField.addAll((Collection<? extends String>) metaDataObj[0]);
			dataValue.addAll((Collection<? extends String>) metaDataObj[1]);
		}
		return new Object[] {dataField, dataValue};
	}
	
	
public  Object[]  getMetaDataVal(File file, List<String> metaDataFields) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		//DataOneXMLParser contentParser = new DataOneXMLParser();
		//Map<String, String> PREF_MAP = new HashMap<String, String>();
		List<String>  dataField = new ArrayList<String>();
		List<String>  dataValue = new ArrayList<String>();
		
		
		for (int index =1 ; index < metaDataFields.size(); index++) {
			String field = metaDataFields.get(index).trim();
			
			if (field.contains("//")){
				Object[] metaDataObj = configParser.getXpathData(file,field);
				dataField.addAll((Collection<? extends String>) metaDataObj[0]);
				dataValue.addAll((Collection<? extends String>) metaDataObj[1]);
			}
			else 
			{
				Object[] metaDataObj =configParser.getMetadata(file,field);
				dataField.addAll((Collection<? extends String>) metaDataObj[0]);
				dataValue.addAll((Collection<? extends String>) metaDataObj[1]);
			}
			
		}
		
		return new Object[] {dataField, dataValue};
	}


	
	// Get the hash map of the prefix and namespace uri. 
	// The values are contained in the namespace tag of the config xml file. 
	
	public void getNamespace(List<String> namespace, List<String> prefix){ 
			Map<String, String> PREF_MAP = new HashMap<String, String>();
		    for (int index=1; index <=  namespace.lastIndexOf("namespace"); index++) {
		    	//System.out.print(prefix.get(index).split("=")[0].trim());
		    	//System.out.println(prefix.get(index).split("=")[1].trim());
 		    }
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
}