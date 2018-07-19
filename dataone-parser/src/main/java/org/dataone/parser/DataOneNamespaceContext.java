package org.dataone.parser;


/**
* <h1>DataONE NameSpaceContext !</h1>
* The DataOneNamespaceContext program implements an NamespaceContext class. 
* The constructor takes the a hash map list of the values for setting the
* prefix with the namespace values. 
* @author  Pratik Shrivastava
* @version 1.0
* @since   2018-07-19
*/


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.namespace.NamespaceContext;

public class DataOneNamespaceContext implements NamespaceContext {

    private final Map<String, String> PREFIX = new HashMap<String, String>();

    
    /**
    * The DataOneNamespaceContext constructor takes the hashmap list as input, 
    * and adds it to the global hashmap list of the class. 
    * @param prefMap, contains the key value pair of prefix and uri. 
    *
    */
    public DataOneNamespaceContext(final Map<String, String> prefMap) {
    	PREFIX.putAll(prefMap);       
    }

    /**
    * The addNamseSpaceContext method adds the prefix and uri values 
    * to list 
    * @param prefMap, contains the key value pair of prefix and uri. 
    *
    */
    public void addNamseSpaceContext(Map<String, String> prefMap) {
    	PREFIX.putAll(prefMap);
    }

    public String getNamespaceURI(String prefix) {
        return PREFIX.get(prefix);
    }

    public String getPrefix(String uri) {
        throw new UnsupportedOperationException();
    }

    public Iterator getPrefixes(String uri) {
        throw new UnsupportedOperationException();
    }
    
}
