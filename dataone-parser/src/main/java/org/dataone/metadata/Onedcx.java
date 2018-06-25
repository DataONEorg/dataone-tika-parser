package org.dataone.metadata;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property; 

public interface Onedcx {

    public static final String NAMESPACE_URI_DC = "http://purl.org/dc/terms/";
    public static final String NAMESPACE_URI_DC_TERMS = "http://purl.org/dc/terms/";
    public static final String PREFIX_DC = "dc";
    public static final String PREFIX_DC_TERMS = "dcterms";

/*    
	Property FORMAT = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "format");

	Property IDENTIFIER = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "identifier");

	Property MODIFIED = Property.internalDate(
		PREFIX_DC_TERMS + Metadata.NAMESPACE_PREFIX_DELIMITER + "modified");

	Property CONTRIBUTOR = Property.internalTextBag(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "contributor");
	Property COVERAGE = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "coverage");
	Property CREATOR = Property.internalTextBag(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "creator");

    Property CREATED = Property.internalDate(
                PREFIX_DC_TERMS + Metadata.NAMESPACE_PREFIX_DELIMITER + "created");

	Property DATE = Property.internalDate(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "date");

	Property DESCRIPTION = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "description");

	Property LANGUAGE = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "language");

	Property PUBLISHER = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "publisher");

	Property RELATION = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "relation");

	Property RIGHTS = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "rights");

	Property SOURCE = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "source");

	Property SUBJECT = Property.internalTextBag(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "subject");

	Property TITLE = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "title");
	Property TYPE = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "type");

	Property ABSTRACT = Property.internalText(
    		PREFIX_DC + Metadata.NAMESPACE_PREFIX_DELIMITER + "abstract");
*/
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

}
