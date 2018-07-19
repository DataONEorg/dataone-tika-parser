package org.dataone.parser.ExampleFiles;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property; 

public interface Eml211 {

     public static final String NAMESPACE_URI= "eml://ecoinformatics.org/eml-2.1.1";
     public static final String NAMESPACE_URI_DC_TERMS = "http://purl.org/dc/terms/";
    //public static final String PREFIX_DC = "eml";
    //public static final String PREFIX_DC_TERMS = "dcterms";

	/*
	 * 	Adding properties from the 
	 * http://indexer-documentation.readthedocs.io/en/latest/generated/proc_dublinCoreExtendedSubprocessor.html
	 * 
	*/
	
	Property TITLE = Property.internalText(
			//PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "principal");
			"title");
	
	Property ABSTRACT = Property.internalText(
			//PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "principal");
			"abstract");
	
	Property AUTHOR = Property.internalText(
			//PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "principal");
			"author");
	
	Property KEYWORDS = Property.internalText(
			//PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "principal");
			"title");
	Property PRINCIPAL = Property.internalText(
			//PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "principal");
			"principal");
	Property DELIVERYPOINT = Property.internalText("deliveryPoint");
	Property KEYWORD = Property.internalText("keyword");
	Property BOXSPATIALBOUNDCOORDINATES = Property.internalText("boundingCoordinates");
}
