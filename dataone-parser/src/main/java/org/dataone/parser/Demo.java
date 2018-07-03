package org.dataone.parser;

import java.util.Arrays;
import java.util.List;

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
        EmlParserStaX read = new EmlParserStaX();
  	  	File file = new File(args[0]);

  	  	Tika tika = new Tika();
  	 
      //detecting the file type using detect method
  	  	try {
			String filetype = tika.detect(file);
			System.out.println( file +": "+ filetype);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  		
		    EmlTags readConfig = read.readConfig(args[0]);
		    
		    //System.out.println(readConfig);
		    
		    EmlParserDOM parserDom = new EmlParserDOM();
		    
		    List<NodeList> xmlMetadata = parserDom.getNodesValues(file,"//dataset/keywordSet/*");
		    
			
		  
		  for (int i = 0; i < xmlMetadata.get(0).getLength(); i++) 
		  	{
			  System.out.println(xmlMetadata.get(0).item(i).getNodeName() + ": " + xmlMetadata.get(1).item(i).getNodeValue());
		  	}
		  
		  

    }
}