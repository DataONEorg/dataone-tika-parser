package org.dataone.parser;

import org.w3c.dom.*;
import java.io.File;
import javax.xml.xpath.*;
import javax.xml.parsers.*;
import java.io.IOException;
import org.xml.sax.SAXException;

import java.util.Arrays;
import java.util.List;

public class EmlParserDOM {
	public 	static  DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	
	public static DocumentBuilder builder ;
	
	public static XPath xpath = XPathFactory.newInstance().newXPath();
	public static Document doc; 
	public static  NodeList tag ;
	public static  NodeList val ;
	
	public EmlParserDOM()
	
	{
		
		domFactory.setNamespaceAware(true);
  	} 
  
  public List<NodeList> getNodesValues(File fileName, String path) throws SAXException, IOException, ParserConfigurationException
  {
	   builder = domFactory.newDocumentBuilder();
	   doc = builder.parse(fileName);
	  // XPath Query for showing all node name
	  //XPathExpression expr_node = xpath.compile("//dataset/keywordSet/*");
	  
	   	XPathExpression expr_node;
	try {
		
			expr_node = xpath.compile(path);
		//XPath Query for showing all nodes value
		  
		  //XPathExpression expr_val = xpath.compile("//dataset/keywordSet/*/text()");
		  XPathExpression expr_val = xpath.compile(path+"/text()");
		  
		  Object elements = expr_node.evaluate(doc, XPathConstants.NODESET);
		  Object values = expr_val.evaluate(doc, XPathConstants.NODESET);
		  tag = (NodeList) elements; 
		  val = (NodeList) values; 
		  
	} catch (XPathExpressionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	  return Arrays.asList(tag, val);
  }
  



}