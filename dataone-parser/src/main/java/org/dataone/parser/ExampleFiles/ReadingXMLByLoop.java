package org.dataone.parser.ExampleFiles;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.*;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 
public class ReadingXMLByLoop{
	 public DocumentBuilderFactory docbuildFactory; 
	 public DocumentBuilder docBuilder ; 
	 public Document document; 
	 
	 public static void main(String[] args) {
 
		 try {
				File xmlFile = new File(args[0]);
				DocumentBuilderFactory docbuildFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docbuildFactory.newDocumentBuilder();
				Document document = docBuilder.parse(xmlFile);
 
				System.out.println("Root element name :- " + document.getDocumentElement().getNodeName());
				System.out.println(getXpath(document.getDocumentElement().getNodeName(),document.getElementsByTagName("keywordSet").item(0) ));
				 
				NodeList nodeList = document.getElementsByTagName("keywordSet");
				//System.out.println( nodeList.item(0));
				//System.out.println( nodeList.getLength());
				
				 for (int i = 0; i < nodeList.getLength(); i++) {
		            Node node = nodeList.item(i);
		            //System.out.println( node.getNodeName());
		            if (node.hasChildNodes()) 
		            {
		            	printNode(node.getChildNodes());
		            }
		        }

		    } catch (Exception e) {
				e.printStackTrace();
		    }
 
}
 
	 public static void printNode(NodeList nodeList) {
 
		    for (int i = 0; i < nodeList.getLength(); i++) {
 
			Node tempNode = nodeList.item(i);
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
					if (tempNode.hasChildNodes()) {
						// Check if child nodes present.
						printNode(tempNode.getChildNodes());
						}
					else {
						System.out.print(tempNode.getParentNode().getNodeName()+": ");
			        	System.out.println(tempNode.getNodeValue());
					}
				}
				
			else {
					
					 System.out.print(tempNode.getParentNode().getNodeName()+": ");
		        	 System.out.println(tempNode.getNodeValue());

		        	} 
		    }
	 }
	 public static String getXpath(String root, Node nodeName) {
		//Node root = document.getDocumentElement().getNodeName();
		
		if (nodeName.getNodeName().equals(root)) {
			System.out.println(root);
			
			return ("//" + root);
		}
		else {
			//System.out.println("//" + root +'/'+nodeName.getParentNode().getNodeName());
			
			return (getXpath(root,nodeName.getParentNode())+"/"+nodeName.getNodeName()); 
		}
		
		
	 }
}
 