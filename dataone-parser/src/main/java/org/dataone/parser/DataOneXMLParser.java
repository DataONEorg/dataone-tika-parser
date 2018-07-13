package org.dataone.parser;

import org.w3c.dom.*;
import java.io.File;
import javax.xml.xpath.*;
import javax.xml.parsers.*;
import java.io.IOException;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataOneXMLParser {
	public static  DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();	
	public static  Document doc; 
	protected static String rootNode; 
	
	public DataOneXMLParser() 
	
	{

		domFactory.setNamespaceAware(true);
  	} 
  
 
  
public Object[] getMetadata(File file, String tag) throws ParserConfigurationException, SAXException, IOException{

		List<String>  dataField = new ArrayList<String>();
		List<String>  dataValue = new ArrayList<String>();
		List<String>  dataxPath = new ArrayList<String>();
	
	try {	
			
			DocumentBuilderFactory docbuildFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docbuildFactory.newDocumentBuilder();
			Document document = docBuilder.parse(file);
			rootNode = document.getDocumentElement().getNodeName();
		
			// Check whether if tag is null or not
			// If null then, set the tag as rootNode
			// for parsing the config file. 
			tag = tag != null ? tag : rootNode;
			
			//System.out.println(tag);
			NodeList nodeList = document.getElementsByTagName(tag);
			
			 
			 for (int i = 0; i < nodeList.getLength(); i++) {
			       Node node = nodeList.item(i);
			       dataField.add(node.getNodeName().trim());
			       dataValue.add(getValue(node).trim());
			       dataxPath.add(genXPathString(rootNode,node));
			       if (node.hasChildNodes()) 
			       {
			    	  Object[] data =  getData(node.getChildNodes());
			    	  dataField.addAll((Collection<? extends String>) data[0]);
					  dataValue.addAll((Collection<? extends String>) data[1]);
					  dataxPath.addAll((Collection<? extends String>) data[2]);
			    	  
			       }
				 }
	
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	
	return new Object[] {dataField, dataValue,dataxPath};
}



protected Object[] getData(NodeList nodeList) {
	
	List<String>  dataField = new ArrayList<String>();
	List<String>  dataValue = new ArrayList<String>();
	List<String>  dataxPath = new ArrayList<String>();
	
	for (int i = 0; i < nodeList.getLength() ; i++) {

	Node childNode = nodeList.item(i);

	if (childNode.getNodeType() == Node.ELEMENT_NODE) {

		
		   dataField.add(childNode.getNodeName());
	       dataValue.add(getValue(childNode));
	       dataxPath.add(genXPathString(rootNode,childNode));
		
		if (childNode.hasChildNodes()) {
			// Check if child nodes present.
	    	  Object[] data =  getData(childNode.getChildNodes());
	    	  
	    	  dataField.addAll((Collection<? extends String>) data[0]);
			  dataValue.addAll((Collection<? extends String>) data[1]);
			  dataxPath.addAll((Collection<? extends String>) data[2]);
			} 
    	//System.out.println(getNodeValue(tempNode));
    	}
	}
	
	return new Object[] {dataField, dataValue, dataxPath};
	
}

protected static String getValue( Node node ) {
	//System.out.println(node.getNodeValue());
    NodeList childNodes = node.getChildNodes();
    for (int x = 0; x < childNodes.getLength(); x++ ) {
        Node data = childNodes.item(x);
        if ( data.getNodeType() == Node.TEXT_NODE )
            return data.getNodeValue();
    }
    return " ";
}
protected static String genXPathString(String root, Node nodeName) {
	//Node root = document.getDocumentElement().getNodeName();
	
	if (nodeName.getNodeName().equals(root)) {
		return ("//" + root);
	}
	else {		
		return (genXPathString(root,nodeName.getParentNode())+"/"+nodeName.getNodeName()); 
	}
	
	}


public Object[] getXpathData(File file, String path) throws SAXException, IOException, ParserConfigurationException
{
		DocumentBuilderFactory docbuildFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docbuildFactory.newDocumentBuilder();
		Document document = docBuilder.parse(file);
		rootNode = document.getDocumentElement().getNodeName();
		XPath xpath = XPathFactory.newInstance().newXPath();
		List<String>  dataField = new ArrayList<String>();
		List<String>  dataValue = new ArrayList<String>();
		List<String>  dataxPath = new ArrayList<String>();
		
	   	XPathExpression expr_node;
	try {
		
			expr_node = xpath.compile(path);

		   //XPathExpression expr_val = xpath.compile(path+"/text()");
		  
		  Object elements = expr_node.evaluate(document, XPathConstants.NODESET);
		  
		  NodeList nodeList = (NodeList) elements;
		   //System.out.println(path);
	       //System.out.println(nodeList.getLength());
		  
			 for (int i = 0; i < nodeList.getLength(); i++) {
			       Node node = nodeList.item(i);
			       
			       dataField.add(node.getNodeName().trim());
			       dataValue.add(getValue(node).trim());
			       dataxPath.add(genXPathString(rootNode,node));
			       
			       if (node.hasChildNodes()) 
			       {
			    	  Object[] data =  getData(node.getChildNodes());
			    	  dataField.addAll((Collection<? extends String>) data[0]);
					  dataValue.addAll((Collection<? extends String>) data[1]);
					  dataxPath.addAll((Collection<? extends String>) data[2]);
			       }
				 }
		  
		  
	} catch (XPathExpressionException e) {
		e.printStackTrace();
	}
	return new Object[] {dataField, dataValue, dataxPath};
}
}