package org.dataone.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Collection;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.tika.Tika;
import org.dataone.metadata.*;
import org.dataone.parser.ExampleFiles.EmlParserStaX;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.apache.tika.metadata.Metadata;

import java.io.File;
import java.io.IOException;


public class Demo {
    public static void main(String args[]) throws SAXException, IOException, ParserConfigurationException {
    	Demo main = new Demo();
    	
        EmlParserStaX read = new EmlParserStaX();
  	  	File file = new File(args[0]);

  	  	Tika tika = new Tika();
  	 
      //detecting the file type using detect method
  	  	try {
			String filetype = tika.detect(file);
			if(filetype.contains("ecoinformatics.org")) {
				System.out.println( file +": eml://ecoinformatics.org/eml-2.1.1");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  		
		    //EmlTags readConfig = read.readConfig(args[0]);
		    
		    //System.out.println(readConfig);
		    
		    EmlParserDOM parserDom = new EmlParserDOM();
		    
		    XpathForMetadata xPathQuery = new XpathForMetadata();
		    
		    
		   // System.out.println(xPathQuery.emlXpath.get(11));
		    
		  
		 
		  for (String path : xPathQuery.emlXpath) {
				System.out.println(path);
				List<NodeList> xmlMetadata = parserDom.getNodesValues(file,path);
				//List<NodeList> xmlMetadata = parserDom.getNodesValues(file,"//dataset/*");
				main.printNodeValue(xmlMetadata);
			}		  
    }
    
    public void printNodeValue(List<NodeList> xmlMetadata) {
    	
		  for (int i = 0; i < xmlMetadata.get(0).getLength(); i++) 
		  	{
			  String nodeValue = xmlMetadata.get(1).item(i).getNodeValue();
			  String nodeName  = xmlMetadata.get(0).item(i).getNodeName();

			  if(!nodeValue.contains("\n")) {
				  System.out.println(nodeName + ": " + nodeValue);
				  } 
		  	}
    }
}