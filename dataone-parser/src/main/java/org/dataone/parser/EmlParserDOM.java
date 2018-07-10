package org.dataone.parser;

import org.w3c.dom.*;
import java.io.File;
import javax.xml.xpath.*;
import javax.xml.parsers.*;
import java.io.IOException;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmlParserDOM {
	public 	static  DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	
	public static DocumentBuilder builder ;
	
	public static XPath xpath = XPathFactory.newInstance().newXPath();
	public static Document doc; 
	public static  List<String> dataField = new ArrayList() ;
	public static  List<String> dataValue = new ArrayList() ;
	public static  List<String> dataxPath = new ArrayList();
	public static String rootNode; 
	
	public EmlParserDOM() 
	
	{

		domFactory.setNamespaceAware(true);
  	} 
  
 
  
public void getMetadata(File file, String tag) throws ParserConfigurationException, SAXException, IOException{
	
	try {
			DocumentBuilderFactory docbuildFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docbuildFactory.newDocumentBuilder();
			Document document = docBuilder.parse(file);
			rootNode = document.getDocumentElement().getNodeName();
		
			NodeList nodeList = document.getElementsByTagName(tag);
			

			 for (int i = 0; i < nodeList.getLength(); i++) {
			       Node node = nodeList.item(i);
			       dataField.add(node.getNodeName());
			       dataValue.add(getValue(node));
			       dataxPath.add(genXPathString(rootNode,node));
			       if (node.hasChildNodes()) 
			       {
			    	   getData(node.getChildNodes());
			       }
				 }
	
	}catch (Exception e) {
		e.printStackTrace();
	}
}

public static void getData(NodeList nodeList) {
	
	for (int i = 0; i < nodeList.getLength() ; i++) {

	Node childNode = nodeList.item(i);

	if (childNode.getNodeType() == Node.ELEMENT_NODE) {

		
	       dataField.add(childNode.getNodeName());
	       dataValue.add(getValue(childNode));
	       dataxPath.add(genXPathString(rootNode,childNode));
		
		if (childNode.hasChildNodes()) {
			// Check if child nodes present.
				getData(childNode.getChildNodes());
			} 
    	//System.out.println(getNodeValue(tempNode));
    	}
	}
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
public static String genXPathString(String root, Node nodeName) {
	//Node root = document.getDocumentElement().getNodeName();
	
	if (nodeName.getNodeName().equals(root)) {
		return ("//" + root);
	}
	else {		
		return (genXPathString(root,nodeName.getParentNode())+"/"+nodeName.getNodeName()); 
	}
	
	}
}

/*
 *  public List<NodeList> getNodesValues(File fileName, String path) throws SAXException, IOException, ParserConfigurationException
  {
	   builder = domFactory.newDocumentBuilder();
	   doc = builder.parse(fileName);
	  // XPath Query for showing all node name
	  //XPathExpression expr_node = xpath.compile("//dataset/keywordSet/*");
	  
	   	XPathExpression expr_node;
	try {
		
			expr_node = xpath.compile(path);
		//XPath Query for showing all nodes value
		  
		  //XPathExpression expr_val = xpath.compile("//dataset/keywordSet//text()");
		  XPathExpression expr_val = xpath.compile(path+"/text()");
		  
		  Object elements = expr_node.evaluate(doc, XPathConstants.NODESET);
		  Object values = expr_val.evaluate(doc, XPathConstants.NODESET);
		  tag = (NodeList) elements; 
		  val = (NodeList) values; 
		  
	} catch (XPathExpressionException e) {
		e.printStackTrace();
	}

	  return Arrays.asList(tag, val);
  }
 */