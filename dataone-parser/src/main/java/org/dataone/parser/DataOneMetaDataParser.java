package org.dataone.parser;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.dataone.metadata.*;
import org.xml.sax.SAXException;
import java.util.List;
import java.io.File;
import java.io.IOException;


/**
* <h1>DataONE Metadata Parser for DataONE file formats!</h1>
* The DataOneMetaDataParser program implements an application that
* simply detects the file type for a given input file and prints
* the respective metadata fields on the screen. 
* <p>
*
* @author  Pratik Shrivastava
* @version 1.0
* @since   2018-07-19
*/



public class DataOneMetaDataParser {
	
	/** 
	 *  List of Strings for holding metadata Fields and it's values
	 */
	public static List<String> metaDataFields; 
	public static List<String> metaDataValues; 

	/**
	   * This method is used to detect the filetype and print metadata contents. 
	   * @param args[0] This is takes the filename as the input. 
	   * @exception IOException On input error.
	   * @see IOException
	   */
	
    public static void main(String args[]) throws SAXException, IOException, ParserConfigurationException, TikaException, XPathExpressionException {
    	
    	// Variable for storing the file type. 
  	  	String fileType = "";

    	//Get the input file from the command line; 
    	
    	File inpFile = new File(args[0]);
    	//File inpFile = new File("custom-mimetypes.jar");
    	
    	
    	// Create Tika objects for file detection. 
    	/**
    	 * This step creates a Tika Object for File Detection. 
  	   	 */
    	Tika tika = new Tika();

    	// Create DataOneMapper objects for file mapping the file and metadata fields. .
    	/**
    	 * This step creates a DataOneMapper Object for mapping metadatafields and values. 
  	   	 */

    	DataOneMapper mapper = new DataOneMapper(); 
 

  	  	try {
  	  		
  	  	  	//detecting the file type using detect method
  	  		// replace the escape characters. 
  	  		fileType = tika.detect(inpFile);  	  		
  	  		fileType = fileType.replaceAll("\\\\", "");
  	  		
  	  		// get the xPath for the meta data fields for the file type. 
  	  		String xPath =  mapper.getXpath(fileType);
  	  		
  	  		
  	  		/** This step checks if the filetype is Default type or DataONE
  	  		 *  If Default type,  then Tika's AutoDetectParser is used for getting the contents,
  	  		 *  else DataOneXMLParser is used.  
  	  		 */  
  	  		if (xPath.equals("Default")){
  	  		    List<String> metaData = mapper.getTikaParser(inpFile); 
  	  			for (String name: metaData ) {
  	  				 System.out.println(name );
  	  			}
  	  			
  	  		}
  	  		else {
  	  		
  	  		/** 
  	  		 *   mapper.getMetadataList(xPath) is used for extracting the metadata List from the config file.
  	  		 *  @param xPath The return value based on the file type. 
  	  		 *  @return Object[] Array of List<String> objects containing the fields. 
  	  		 *  
  	  		 * */
  	  			
  	  		Object[] configData = mapper.getMetadataList(xPath); 
 		    metaDataFields = (List<String>) configData[0];
 		    metaDataValues = (List<String>) configData[1];
 		    
 		   System.out.println("-----------------------------------------------------------------------------");
 		   System.out.printf("%10s", "FILE FORMAT :" + fileType);
 		   System.out.println();
 		   System.out.println("-----------------------------------------------------------------------------");
 		   
 	  		/** 
 	  		 *   mapper.getMetaDataVal(inpFile, metaDataValues) is used for extracting the metadata values,
 	  		 *   for the list of the fields past.
 	  		 *  @param inpFile The input file passed as argument. 
 	  		 *  @param metaDataValues The List of the metadata fields passed for obtaining the values from the input file. 
 	  		 *  @return Object[] Array of List<String> objects containing the fields. 
 	  		 *  
 	  		 * */ 		    
  	  		Object[] data = mapper.getMetaDataVal(inpFile, metaDataValues); 
// 		    //Object[] obj =  mapper.getMetaDataVal(inpFile, metaDataFields); 
  	  		List<String>  dataFields = (List<String>) data[0];
  	  		List<String>  dataValues = (List<String>) data[1];

 		    for (int index =0 ; index < dataFields.size(); index ++) {
 			  // parserDom.getMetadata(file,field) ;
 		    	String field = dataFields.get(index); 
 		    	String value = dataValues.get(index);
 		    	System.out.println(field + ": " + value.trim());
 		    	if(value.length()>0) {
 		    		//System.out.println(field + ": " + value.trim());
 		    	}
 		    	
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
