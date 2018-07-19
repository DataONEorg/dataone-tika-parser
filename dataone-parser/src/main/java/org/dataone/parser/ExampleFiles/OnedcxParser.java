package org.dataone.parser.ExampleFiles;

import java.util.Collections;
import java.util.Set;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.xml.XMLParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.xml.ElementMetadataHandler;

import org.apache.tika.mime.MediaType;
import org.apache.tika.sax.TeeContentHandler;
import org.xml.sax.ContentHandler;


public class OnedcxParser extends XMLParser  {

    /** Serial version UID */
    private static final long serialVersionUID = 4905318835463880819L;
    private static final Set<MediaType> SUPPORTED_TYPES = Collections.singleton(MediaType.application("onedcx"));
    public static final String ONEDCX_MIME_TYPE = "text/xml; formatid=\"http\\:\\/\\/ns.dataone.org\\/metadata\\/schema\\/onedcx\\/v1.0\"";
    
    
    private static ContentHandler getDublinCoreHandler(
            Metadata metadata, Property property, String element) {
        return new ElementMetadataHandler(
                Onedcx.NAMESPACE_URI_DC, 
                //"http://purl.org/dc/terms/",
        		element,
                metadata, property);
    }

    protected ContentHandler getContentHandler(
            ContentHandler handler, Metadata metadata, ParseContext context) {
    		metadata.set(Metadata.CONTENT_TYPE, ONEDCX_MIME_TYPE);
    	
    	
//        return new TeeContentHandler(
//                super.getContentHandler(handler, metadata, context),
//                getDublinCoreHandler(metadata, Onedcx.TITLE, "title"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.KEYWORDS, "subject"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.CREATOR, "creator"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.DESCRIPTION, "description"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.PUBLISHER, "publisher"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.CONTRIBUTOR, "contributor"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.CREATED, "date"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.TYPE, "type"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.FORMAT, "format"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.IDENTIFIER, "identifier"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.LANGUAGE, "language"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.RIGHTS, "rights"),
//                getDublinCoreHandler(metadata, Onedcx.ABSTRACT, "abstract"),
//                getDublinCoreHandler(metadata, Onedcx.ABSTRACT, "abstract"),
//                getDublinCoreHandler(metadata, Onedcx.ABSTRACT, "abstract"),
//                getDublinCoreHandler(metadata, Onedcx.ABSTRACT, "abstract")
//                );
    		return new TeeContentHandler(
						super.getContentHandler(handler, metadata, context),
						getDublinCoreHandler(metadata, Onedcx.ABSTRACT, "abstract"),
						getDublinCoreHandler(metadata, Onedcx.AUTHOR, "author"),
						getDublinCoreHandler(metadata, Onedcx.AUTHORSURNAME, "authorSurName"),
						getDublinCoreHandler(metadata, Onedcx.AUTHOR, "authorSurNameSort"),
						getDublinCoreHandler(metadata, Onedcx.AUTHOR, "contactOrganization"),
						getDublinCoreHandler(metadata, Onedcx.AUTHOR, "investigator"),
						getDublinCoreHandler(metadata, Onedcx.AUTHOR, "origin"),
						getDublinCoreHandler(metadata, Onedcx.PUBDATE, "pubDate"),
						getDublinCoreHandler(metadata, Onedcx.TITLE, "title"),
						getDublinCoreHandler(metadata, Onedcx.KEYWORDS, "keywords"),
						getDublinCoreHandler(metadata, Onedcx.BEGINDATE, "beginDate"),
						getDublinCoreHandler(metadata, Onedcx.ENDDATE, "endDate"),
						getDublinCoreHandler(metadata, Onedcx.PERIOD, "datePeriod"),
						getDublinCoreHandler(metadata, Onedcx.SITE, "site"),
						getDublinCoreHandler(metadata, Onedcx.BOXSPATIALBOUNDCOORDINATES, "boxSpatialBoundCoordinates"),
						getDublinCoreHandler(metadata, Onedcx.SPATIALGEOHASH, "boxSpatialGeohash"),
						getDublinCoreHandler(metadata, Onedcx.FILEID, "fileID"),
						getDublinCoreHandler(metadata, Onedcx.TEXT, "fullText"),		        
						getDublinCoreHandler(metadata, TikaCoreProperties.DESCRIPTION, "description"),
						getDublinCoreHandler(metadata, TikaCoreProperties.PUBLISHER, "publisher"),
						getDublinCoreHandler(metadata, TikaCoreProperties.CONTRIBUTOR, "contributor"),
						getDublinCoreHandler(metadata, TikaCoreProperties.CREATED, "date"),
						getDublinCoreHandler(metadata, TikaCoreProperties.TYPE, "type"),
						getDublinCoreHandler(metadata, TikaCoreProperties.FORMAT, "format"),
						getDublinCoreHandler(metadata, TikaCoreProperties.IDENTIFIER, "identifier"),
						getDublinCoreHandler(metadata, TikaCoreProperties.LANGUAGE, "language"),
						getDublinCoreHandler(metadata, TikaCoreProperties.RIGHTS, "rights"),
						getDublinCoreHandler(metadata, Onedcx.TEMPORAL, "temporal"),
						getDublinCoreHandler(metadata, Onedcx.SPATIAL, "spatial")
    				);
    }

}