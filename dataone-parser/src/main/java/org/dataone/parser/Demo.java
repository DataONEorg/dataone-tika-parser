package org.dataone.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Collection;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.tika.Tika;
import org.dataone.metadata.*;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.apache.tika.metadata.Metadata;

import java.io.File;
import java.io.IOException;


public class Demo {
    public static void main(String args[]) throws SAXException, IOException, ParserConfigurationException {
    	Demo main = new Demo();
    	
        //EmlParserStaX read = new EmlParserStaX();
  	  	File file = new File(args[0]);
  	  	Tika tika = new Tika();
  	  	DataOneMapper mapper = new DataOneMapper(); 
  	  	Integer fileTypeNum =0 ; 
  	  	String fileType = "";
  	  	//detecting the file type using detect method
  	  	try {
  	  		fileType = tika.detect(file);
  	  		fileTypeNum = mapper.getFileTypeNum(fileType);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    EmlParserDOM parserDom = new EmlParserDOM();
		    
		    // Get the field list from the mapper 		  
		   for (String field: mapper.getFieldList(fileTypeNum)) {
			   parserDom.getMetadata(file, field) ;
		   }
		   System.out.println("-----------------------------------------------------------------------------");
		   System.out.printf("%10s", "FILE FORMAT :" + fileType);
		   System.out.println();
		   System.out.println("-----------------------------------------------------------------------------");
		   
		   System.out.println();
		   
		    System.out.println("-----------------------------------------------------------------------------");
		    System.out.printf("%10s %50s %20s ", "METADATA FIELD", "FIELD VALUE", "XPATH");
		    System.out.println();
		   for (int index = 0; index < parserDom.dataField.size(); index++)
			   
		   {
			   //System.out.println(parserDom.dataField.get(index)+ ": "+ parserDom.dataValue.get(index)+ ": " + parserDom.dataxPath.get(index));
			   System.out.format("%10s %30s %50s ",parserDom.dataField.get(index), parserDom.dataValue.get(index), parserDom.dataxPath.get(index));
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