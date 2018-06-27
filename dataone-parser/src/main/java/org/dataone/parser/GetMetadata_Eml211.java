package org.dataone.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.txt.TXTParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.metadata.TikaCoreProperties;

import org.xml.sax.SAXException;

public class GetMetadata_Eml211 {
	
   public static void main(final String[] args) throws IOException, TikaException, SAXException {
	
      //Assume that boy.jpg is in your current directory
      //File file = new File("pom.xml");
	  File file = new File(args[0]);

      Tika tika = new Tika();
      
      //detecting the file type using detect method
      String filetype = tika.detect(file);
      //System.out.println(filetype);
      
      //Parser method parameters
      //Parser parser = new AutoDetectParser();
      //Parser parser = new DcXMLParser();
      Parser parser = new Eml211Parser();
      
      BodyContentHandler handler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      FileInputStream inputstream = new FileInputStream(file);
      ParseContext context = new ParseContext();
 
      parser.parse(inputstream, handler, metadata, context);
      
      //System.out.println(handler.toString());
      
      System.out.println("Extracting Metadata of the document: ");
      //getting the list of all meta data elements 
      String[] metadataNames = metadata.names();
      
      for(String name : metadataNames) {		        
         System.out.println(name + ": "+ metadata.get(name));
      }
      
   }

}