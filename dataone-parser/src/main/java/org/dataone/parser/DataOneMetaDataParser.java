package org.dataone.parser;


import javax.xml.parsers.ParserConfigurationException;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.dataone.metadata.*;
import org.xml.sax.SAXException;
import java.util.List;
import java.io.File;
import java.io.IOException;


public class DataOneMetaDataParser {
	public static List<String> metaDataFields; 
	public static List<String> metaDataValues; 

	
    public static void main(String args[]) throws SAXException, IOException, ParserConfigurationException, TikaException {
    	
    	// Variable for storing the file type. 
  	  	String fileType = "";

    	//Get the input file from the command line; 
    	
    	File inpFile = new File(args[0]);
    	//File inpFile = new File("custom-mimetypes.jar");
    	
    	// Create Tika objects for file detection. 
    	Tika tika = new Tika();

    	// Create DataOneMapper objects for file mapping the file and metadata fields. .
    	DataOneMapper mapper = new DataOneMapper(); 
 
  	  	//detecting the file type using detect method
  	  	try {
  	  		fileType = tika.detect(inpFile);
  	  		
  	  		// get the xPath for the meta data fields for the file type. 
  	  		String xPath =  mapper.getXpath(fileType);
  	  		
  	  		/// Check if the file type is default or Data One. 
  	  		
  	  		if (xPath.equals("Default")){
  	  		    List<String> metaData = mapper.getTikaParser(inpFile); 
  	  			for (String name: metaData ) {
  	  				 System.out.println(name );
  	  			}
  	  			
  	  		}
  	  		else {
  	  		
  	  		/* 
  	  		 *  Get hte metadata fields from the config file 
  	  		 *  for the input file. 
  	  		 * */
  	  			
  	  		Object[] configData = mapper.getMetadataList(xPath); 
 		    //Object[] obj =  mapper.getMetaDataVal(inpFile, metaDataFields); 
 		    //metaDataFields = (List<String>) configData[0];
 		    metaDataValues = (List<String>) configData[1];

// 		    for (int index =0 ; index < metaDataFields.size(); index ++) {
// 			  // parserDom.getMetadata(file,field) ;
// 		    	String field = metaDataFields.get(index); 
// 		    	 
// 		    	String value = metaDataValues.get(index);
// 		    	//System.out.println(field + ": " + value.trim());
// 		   }
 		    
  	  		/* 
  	  		 *  Get the values for the metadata fields from the input file 
  	  		 *  
  	  		 * */
 		    
  	  		Object[] data = mapper.getMetaDataVal(inpFile, metaDataValues); 
 		    //Object[] obj =  mapper.getMetaDataVal(inpFile, metaDataFields); 
  	  		List<String>  dataFields = (List<String>) data[0];
  	  		List<String>  dataValues = (List<String>) data[1];

 		    for (int index =0 ; index < dataFields.size(); index ++) {
 			  // parserDom.getMetadata(file,field) ;
 		    	String field = dataFields.get(index); 
 		    	 
 		    	String value = dataValues.get(index);
 		    	System.out.println(field + ": " + value.trim());
 		   }
 		   
  	  		}
  
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
    }
    
  static void printData(List<String> dataValues, String fileType) {
	   
	   System.out.println("-----------------------------------------------------------------------------");
	   System.out.printf("%10s", "FILE FORMAT :" + fileType);
	   System.out.println();
	   System.out.println("-----------------------------------------------------------------------------");
	   
	   System.out.println();
	   
	    System.out.println("-----------------------------------------------------------------------------");
	    System.out.printf("%10s %50s %20s ", "METADATA FIELD", "FIELD VALUE", "XPATH");
	    System.out.println();
	   for (int index = 0; index < dataValues.size(); index++)
		   
	   {
		   //System.out.println(parserDom.dataField.get(index)+ ": "+ parserDom.dataValue.get(index)+ ": " + parserDom.dataxPath.get(index));
		   System.out.format("%10s %30s %50s ",dataValues.get(index), dataValues.get(index), dataValues.get(index));
	       System.out.println();
		   
	   }
 }
}


/*
		    //parserDom.xmlMetadata(file, mapper.metadataMap());
		    XpathForMetadata xPathQuery = new XpathForMetadata();
		   
//		  for (String path : xPathQuery.getXpath(mapper.getFileTypeNum(filetype))) {
//				//System.out.println(path);
//				List<NodeList> xmlMetadata = parserDom.getNodesValues(file,path);
//				//main.printNodeValue(xmlMetadata);
//			}	
 * 
 * 
 *     public void printNodeValue(List<NodeList> xmlMetadata) {
    	
		  for (int i = 0; i < xmlMetadata.get(0).getLength(); i++) 
		  	{
			  String nodeValue = xmlMetadata.get(1).item(i).getNodeValue();
			  String nodeName  = xmlMetadata.get(0).item(i).getNodeName();
			  	System.out.println(nodeName + ": " + nodeValue);
			  if(!nodeValue.contains("\n")) {
				  //System.out.println(nodeName + ": " + nodeValue);
				  } 
		  	}
    }
 */