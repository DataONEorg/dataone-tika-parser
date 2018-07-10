//eml-211/00_eml-211.xml
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
  doc.getDocumentElement().normalize();
  XPath xpath = XPathFactory.newInstance().newXPath();

  // XPath Query for showing all node name
  XPathExpression expr_node = xpath.compile("//*");
  
  //XPath Query for showing all nodes value
  XPathExpression expr_val = xpath.compile("//*/text()");
  
  Object elements = expr_node.evaluate(doc, XPathConstants.NODESET);
  Object values = expr_val.evaluate(doc, XPathConstants.NODESET);
  
  Element root = doc.getDocumentElement();
//  
//  Node pnode = root.getParentNode();
//  
//  System.out.println(root.getNodeName());
//
//  System.out.println(pnode.getNodeValue());
//  
//  Node fNode = root.getFirstChild().getNextSibling(); 
//  
//  System.out.println(fNode);
 // System.out.println(fNode.getFirstChild().getNextSibling().getFirstChild().getNextSibling().getFirstChild().getNextSibling().getFirstChild().getNextSibling());
  
  
 // System.out.println(getFirstElementChild(root));
  
  NodeList tags = (NodeList) elements;
  //NodeList val = (NodeList) values;
  
  System.out.println(getValue("keywordSet",root));
 
  for (int i = 0; i < tags.getLength(); i++) 
  	{
	 //System.out.println(tags.item(i).getNodeName() + ": " + val.item(i).getNodeValue());
	  //System.out.print(tags.item(i).getNodeName());
	  if (tags.item(i).getNodeType() == Node.ELEMENT_NODE) {
		  //System.out.println("Pratik");	

		  Element element = (Element) tags.item(i);
		  //System.out.println(tags.item(i).getNodeName() + ": " +element.getFirstChild().getNodeValue());	  
	  }
	  
  	}
}
  
  public static Element getFirstElementChild(Element element) {
	  Node node = element.getFirstChild();
	    if (node == null) {
	        return null;
	    }

	    do {
	    	
	    	System.out.println("Pratik:" + node.getNodeName());
	        node = node.getNextSibling();
	    }
	    while (node != null);
	    return null;
	}
  
  private static String getValue(String tag, Element element) {
	  NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
	  Node node = (Node) nodes.item(0);
	  return node.getNodeValue();
  		}
}