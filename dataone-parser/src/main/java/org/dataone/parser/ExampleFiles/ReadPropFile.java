package org.dataone.parser.ExampleFiles;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.dataone.parser.DataOneXMLParser;
import org.xml.sax.SAXException;


public class ReadPropFile {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		File propFile = new File("configFiles.xml");
		DataOneXMLParser xmlParser = new DataOneXMLParser();
		xmlParser.getMetadata(propFile,"field");
		
		DataOneXMLParser newParser = new DataOneXMLParser();
		
		
		//for(String fieldVal: xmlParser.dataValue) {
//		for (int index =0; index < xmlParser.dataValue.size(); index ++) {
//			String fieldVal=xmlParser.dataValue.get(index); 
//			System.out.println(args[0]);
//			if (fieldVal.contains("//")){
//				//System.out.println(args[0]);
//				newParser.getXpathData(new File(args[0]),fieldVal);
//			}
//			else 
//			{
//				newParser.getMetadata(new File(args[0]),fieldVal);
//			}
//			
//		}
		//xmlParser.getMetadata(new File("../../file_identification/examples/eml-211/00_eml-211.xml"),"abstract");
		//printData(newParser);
	}
	 static void printData(DataOneXMLParser parser) {
		   		   
		    System.out.println("-----------------------------------------------------------------------------");
		    System.out.printf("%10s %50s %20s ", "METADATA FIELD", "FIELD VALUE", "XPATH");
		    System.out.println();
//		   for (int index = 0; index < parser.; index++)
//			   
//		   {
//			   //System.out.println(parserDom.dataField.get(index)+ ": "+ parserDom.dataValue.get(index)+ ": " + parserDom.dataxPath.get(index));
//			   System.out.format("%10s %30s %50s ",parser.dataField.get(index), parser.dataValue.get(index), parser.dataxPath.get(index));
//		       System.out.println();
//			   
//		   }
//	 }
}
}
