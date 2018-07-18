package org.dataone.parser;

import org.springframework.util.xml.SimpleNamespaceContext;
import org.w3c.dom.*;
import java.io.File;
import javax.xml.xpath.*;
import javax.xml.parsers.*;
import java.io.IOException;
import org.xml.sax.SAXException;
import java.util.HashMap;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class NameSpaceExample {
	
	
	public  static void main (String[] args) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
	

	XPathFactory factory = XPathFactory.newInstance();
	XPath xpath = factory.newXPath();
	//Map<String, String> prefMap = new HashMap<String, String>();
	 Map<String, String> prefMap = new HashMap<String, String>(){{
	      put("dc", "http://purl.org/dc/terms/");
	      put("dcterms", "http://purl.org/dc/terms/");
	      put("ns", "http://ns.dataone.org/metadata/schema/onedcx/v1.0");
	       //put("eml", "eml://ecoinformatics.org/eml-2.1.1");
	}};
	
	SimpleContext namespaces = new SimpleContext(prefMap);
	//SimpleContext namespaces = new SimpleContext(prefMap);
	xpath.setNamespaceContext(namespaces);
	  System.out.println(prefMap);

	XPathExpression expr = xpath.compile("//ns:metadata/ns:simpleDc/dc:format"); //ns:metadata/ns:simpleDc/dc:format
	DocumentBuilderFactory docbuildFactory = DocumentBuilderFactory.newInstance();
	docbuildFactory.setNamespaceAware(true);
	
	DocumentBuilder docBuilder = docbuildFactory.newDocumentBuilder();
	
	File file = new File(args[0]);
	//File file = new File("../../file_identification/examples/eml-211/00_eml-211.xml");
	
	Document document = docBuilder.parse(file);
	

	Object elements = expr.evaluate(document, XPathConstants.NODESET);
	  
	NodeList nodeList = (NodeList) elements;
	  //System.out.println(path);
      System.out.println(nodeList.getLength());
	  
		 for (int i = 0; i < nodeList.getLength(); i++) {
		       Node node = nodeList.item(i);
		       System.out.println(node.getNodeName());
		       System.out.println(node.getFirstChild().getNodeValue());
		 }
		       
	}
}
