package org.dataone.parser.ExampleFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dataone.metadata.EmlTags;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class EmlParserStaX {    
    public EmlTags readConfig(String configFile) {
    	//List<EmlTags> tags = new ArrayList<EmlTags>();
	    XMLInputFactory inputFactory = XMLInputFactory.newInstance();
	  
	    EmlTags eml = new EmlTags();
	    InputStream in = null;
		try {
			in = new FileInputStream(configFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		try 
		{
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
						 StartElement startElement = event.asStartElement();
						 System.out.print(startElement.getName().getLocalPart()+ ": ");
						 eml.setMetadata(startElement.getName().getLocalPart()+ ": ");
						 event = eventReader.nextEvent();
						 //Immediate element should be Endelement  due to empty tag in XML.
						 if(event.isEndElement()){
							// System.out.println(event.asCharacters().getData());
						 }
						 else { 
							 System.out.print(event.asCharacters().getData());
							 eml.setValue(event.asCharacters().getData());
							 //System.out.println((event.asCharacters().getData()));
		                   }
						//Iterator<Attribute> attributes = startElement.getAttributes();
						/*
						while (attributes.hasNext()) {
							Attribute attribute = attributes.next();
							//System.out.println(attribute.getName().toString());
							System.out.println(attribute.getValue());
						
						}
						*/
				}
				
			}
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    return eml;
    }
}