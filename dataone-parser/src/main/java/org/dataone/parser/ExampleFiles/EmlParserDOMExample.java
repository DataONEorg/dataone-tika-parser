package org.dataone.parser.ExampleFiles;

import org.w3c.dom.*;
import javax.xml.xpath.*;
import javax.xml.parsers.*;
import java.io.IOException;
import org.xml.sax.SAXException;

public class EmlParserDOMExample {

  public static void main(String[] args) 
 throws ParserConfigurationException, SAXException, 
  IOException, XPathExpressionException {

  DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
  domFactory.setNamespaceAware(true); 
  DocumentBuilder builder = domFactory.newDocumentBuilder();
  
  Document doc = builder.parse(args[0]);
  
  XPath xpath = XPathFactory.newInstance().newXPath();

  // XPath Query for showing all node name
  XPathExpression expr_node = xpath.compile("//dataset/*");
  
  //XPath Query for showing all nodes value
  XPathExpression expr_val = xpath.compile("//dataset/*/text()");
  
  Object elements = expr_node.evaluate(doc, XPathConstants.NODESET);
  Object values = expr_val.evaluate(doc, XPathConstants.NODESET);
  
  NodeList tags = (NodeList) elements;
  NodeList val = (NodeList) values;
  
  for (int i = 0; i < tags.getLength(); i++) 
  	{
	  System.out.println(tags.item(i).getNodeName() + ": " + val.item(i).getNodeValue());
  	}
  
  

  }
}