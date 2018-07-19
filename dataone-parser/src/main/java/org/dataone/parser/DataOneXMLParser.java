/**
* <h1>DataONE XML Parser for parsing XML files!</h1>
* The DataOneXMLParser program implements an application that
*  reads a XML file. It parses the file using the DOM parser for 
*  creating the node objects and returns the list of nodes with its attributes and values. 
*  
* <p>
*
* @author  Pratik Shrivastava
* @version 1.0
* @since   2018-07-19
*/

package org.dataone.parser;

import org.w3c.dom.*;
import java.io.File;
import javax.xml.xpath.*;
import javax.xml.parsers.*;
import java.io.IOException;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* <h1>The DataOneXMLParser class </h1>
* 
*/
public class DataOneXMLParser {
	public static  DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();	
	public static  Document doc; 
	protected static String rootNode; 
	public static Map<String, String> prefMap = new HashMap<String, String>();
	public static Map<String, String> fieldMap = new HashMap<String, String>();
	
	/**
	   * This is the constructor for the class
	   */
	public DataOneXMLParser() 
	
	{
		domFactory.setNamespaceAware(true);
  	} 
  
	/**
	   * The getMetadata method is used extract the nodeName, nodeValue and Xpath for the nodes.
	   * It uses the DOM objects for creating the nodes and 
	   * uses the recursive functions getNodeAttr and getData for extracting the information.
	   * @param file This is the XML file that needs to be parsed.
	   * @param tag  This is the XML tag, that needs to be found and parsed in the given file. 
	   * @return Object[] This returns an array of Object containing the List<String> for fields, values and the Xpath. 
	   */
  
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
			       
			       
			       if(node.hasAttributes()) {
			    	  String prefix= getNodeAttr(node.getNodeName(), node);
			    	  fieldMap.put(node.getChildNodes().item(0).getNodeValue().trim(), prefix);			       }
			       
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
	
	
	//System.out.println(fieldMap);
	return new Object[] {dataField, dataValue,dataxPath};
}


/**
 * The getData method is used to extract the data for the given nodes. 
 * It is a recursive funtion, which checks for the childNodes for the given node. 
 * It takes the NodeList as the input and extract the information for every node. 
 * Checks if there are any attributes or not and then checks for the childNOdes recursively. 
 * Returns the array of List<String> for fields, values and the Xpath.  
 * uses the recursive functions getNodeAttr and getData for extracting the information.
 * @param nodeList This is the XML file that needs to be parsed.
 * @return Object[] This returns an array of Object containing the List<String> for fields, values and the Xpath. 
 */

public Object[] getData(NodeList nodeList) {
	
	List<String>  dataField = new ArrayList<String>();
	List<String>  dataValue = new ArrayList<String>();
	List<String>  dataxPath = new ArrayList<String>();
	
	for (int i = 0; i < nodeList.getLength() ; i++) {

	Node childNode = nodeList.item(i);

	if (childNode.getNodeType() == Node.ELEMENT_NODE) {

		
		   dataField.add(childNode.getNodeName());
	       dataValue.add(getValue(childNode));
	       dataxPath.add(genXPathString(rootNode,childNode));
	       
		  if(childNode.hasAttributes()) {
	    	  String prefix= getNodeAttr(childNode.getNodeName(), childNode);
	    	  if (prefix !="") {
	    		 // System.out.println(prefix +" : " + childNode.getChildNodes().item(0).getNodeValue().trim());
	    		  fieldMap.put(childNode.getChildNodes().item(0).getNodeValue().trim(), prefix);
	    	  }
	    	  
	       }
		
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


/**
 * The getValue method is used to extract the value for the given node. 
 * The value for the node is stored at one level down. For extracting the value of the node, 
 * first get the childNOde (ever Node has a child node, which is of type "TEXT_NODE"), and from their check, 
 * if it's a TEXT_NODE or not. A leaf node will only have a "TEXT_NODE" as childNode which will contain the value. 
 * 
 * @param node This is the node in XML file for which the value needs to be obtained.
 * @return String This returns the value of the node as STring or else it returns a null string.  
 */
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

/**
 * The genXPathString method is used to generated the Xpath for the given Node from the root. 
 * This is not used extensively in the application. A recursive function for generating the XPath.  
 * 
 * 
 * @param root  This is the name of the root Node.
 * @param nodeName This is the name of the Node for which we need to generate Xpath. 
 * @return String This returns the value of the Xpath for the given nodeName from the root. 
 */

protected static String genXPathString(String root, Node nodeName) {
	//Node root = document.getDocumentElement().getNodeName();
	
	if (nodeName.getNodeName().equals(root)) {
		return ("//" + root);
	}
	else {		
		return (genXPathString(root,nodeName.getParentNode())+"/"+nodeName.getNodeName()); 
	}
	
	}

/**
 * The getXpathData method is used extract the nodeName, nodeValue and Xpath for the nodes.
 * It uses the DOM objects for creating the nodes and 
 * uses the recursive functions getNodeAttr and getData for extracting the information.
 * @param file This is the XML file that needs to be parsed.
 * @param path  This is the XML path, that needs to be found and parsed in the given file. 
 * @return Object[] This returns an array of Object containing the List<String> for fields, values and the Xpath. 
 */
public Object[] getXpathData(File file, String path) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException
{
	
	
		//XPath xpath = XPathFactory.newInstance().newXPath();
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();

		
		DataOneNamespaceContext namespaces = new DataOneNamespaceContext(prefMap);
		xpath.setNamespaceContext(namespaces);
		XPathExpression expr = xpath.compile(path); 
		XPathExpression  expr_node = xpath.compile(path);
		
		DocumentBuilderFactory docbuildFactory = DocumentBuilderFactory.newInstance();
		docbuildFactory.setNamespaceAware(true);
		
		DocumentBuilder docBuilder = docbuildFactory.newDocumentBuilder();
		Document document = docBuilder.parse(file);
		

		Object elements = expr.evaluate(document, XPathConstants.NODESET);
		
		rootNode = document.getDocumentElement().getNodeName();
		
		List<String>  dataField = new ArrayList<String>();
		List<String>  dataValue = new ArrayList<String>();
		List<String>  dataxPath = new ArrayList<String>();
		
		NodeList nodeList = (NodeList) elements;
	  for (int i = 0; i < nodeList.getLength(); i++) {
		       Node node = nodeList.item(i);
		      
		       
		       dataField.add(node.getNodeName().trim());
		       dataValue.add(getValue(node).trim());
		       dataxPath.add(genXPathString(rootNode,node));
		       
		       if(node.hasAttributes()) {
		    	  String prefix= getNodeAttr(node.getNodeName(), node);
		    	  fieldMap.put(node.getChildNodes().item(0).getNodeValue().trim(), prefix);		       }
		       
		       // Check for the prefix attributes 
		       if (node.hasChildNodes()) 
		       {
		    	  Object[] data =  getData(node.getChildNodes());
		    	  dataField.addAll((Collection<? extends String>) data[0]);
				  dataValue.addAll((Collection<? extends String>) data[1]);
				  dataxPath.addAll((Collection<? extends String>) data[2]);
				  
		       }
			}
	  
	 //System.out.println(fieldMap);
	return new Object[] {dataField, dataValue, dataxPath};
}

/**
 * The getNodeAttr method is used extract the attribute values for a given node.
 * It checks whether the node has attribute name as "prefix" or "Label". 
 * If "prefix" is found then it checks for it value. 
 * This helps in creation of the hashmap list prefMap for setting the namespace context. 
 * If "Label" is found then it returns the value for the label, which is set as the key for the hashmap fieldMap.
 * @param nodeName This is the nodeName of the attribute. 
 * @param node  This is the attribute node passed for extracting the attributes. 
 * @return String This returns an array of Object containing the List<String> for fields, values and the Xpath. 
 */
protected String getNodeAttr(String nodeName, Node node ) {
    NamedNodeMap attrs = node.getAttributes();
    String key = null;
    String value, label =""; 
    for (int y = 0; y < attrs.getLength(); y++ ) {
    Node attr = attrs.item(y);
		if (attr.getNodeName().equalsIgnoreCase("prefix")|| (key !=null ))  
			{
				key = key != null ? key : attr.getNodeValue();
				
				if (! attr.getNodeName().equals("prefix") && nodeName.equals("namespace")) {
					value =  attr.getNodeValue();
			    	//System.out.println(key+":"+ attr.getNodeValue());
			    	prefMap.put(key, value);

				}
			}
	    else if(attr.getNodeName().equalsIgnoreCase("label")) {
	    		label =  attr.getNodeValue();
	    		
	    	}
		}
    //System.out.println(label);
    return label;
	}

}