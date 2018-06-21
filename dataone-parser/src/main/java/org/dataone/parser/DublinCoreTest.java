package org.dataone.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.xml.DcXMLParser;
import org.apache.tika.parser.ParseContext;
//import org.apache.tika.parser.xml.XMLParser;

import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.parser.Parser;
import org.xml.sax.SAXException;
public class DublinCoreTest {
	
	public static void main(final String[] args) throws IOException, TikaException, SAXException {
		
		BodyContentHandler handler = new BodyContentHandler(-1);
		Metadata metadata = new Metadata();
		File inFile = new File("dublincore_sample.xml");
		FileInputStream inputstream = new FileInputStream(inFile);
		ParseContext pcontext = new ParseContext();

		//Xml parser
		//Parser parser = new AutoDetectParser();
		//parser.parse(inputstream, handler, metadata, pcontext);
		
		// DcXMLParser 
		//Parser parser = new DcXMLParser();
		
		// OneDcxParser
		Parser parser = new OnedcxParser();
		parser.parse(inputstream, handler, metadata, pcontext);
		//System.out.println("Handler Content of the document: ");
		//System.out.println(handler);
		System.out.println("Metadata of the document:");
		String[] metadataNames = metadata.names();//Now we have all the metadata tags here

		for(String name : metadataNames) {
			System.out.println(name + ": " + metadata.get(name));
		    if (name == "Your Particular Tag"){ //here you can check if the tag names are the particular ones you need and do what you want with them
		        System.out.println(name + ": " + metadata.get(name));
		    }
		}

	}
	
}