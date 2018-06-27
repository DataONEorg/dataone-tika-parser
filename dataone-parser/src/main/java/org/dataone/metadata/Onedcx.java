package org.dataone.metadata;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property; 

public interface Onedcx {

    public static final String NAMESPACE_URI_DC = "http://purl.org/dc/terms/";
    public static final String NAMESPACE_URI_DC_TERMS = "http://purl.org/dc/terms/";
    public static final String PREFIX_DC = "dc";
    public static final String PREFIX_DC_TERMS = "dcterms";

	/*
	 * 	Adding properties from the 
	 * http://indexer-documentation.readthedocs.io/en/latest/generated/proc_dublinCoreExtendedSubprocessor.html
	 * 
	*/
	
	Property ABSTRACT = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "abstract");
	
	Property CREATOR = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "creator");
	
	Property AUTHOR = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "author");
	
	Property AUTHORSURNAME = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "authorSurName");
	
	Property PUBDATE = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "pubDate");
	
	Property TITLE = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "title");

	Property KEYWORDS = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "keywords");
	
	Property BEGINDATE = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "beginDate");

	Property ENDDATE = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "endDate");
	
	Property PERIOD = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "datePeriod");
	
	Property SITE = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "site");

	Property BOXSPATIALBOUNDCOORDINATES = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "boxSpatialBoundCoordinates");
	
	Property SPATIALGEOHASH = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "boxSpatialGeohash");
	
	Property FILEID = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "fileID");
	
	Property TEXT = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "fullText");
	
	Property SPATIAL = Property.internalText(
			PREFIX_DC_TERMS + Metadata.NAMESPACE_PREFIX_DELIMITER + "spatial");

	Property TEMPORAL = Property.internalText(
			PREFIX_DC_TERMS + Metadata.NAMESPACE_PREFIX_DELIMITER + "temporal");
}
