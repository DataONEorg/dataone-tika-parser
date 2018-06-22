package org.dataone.parser;

import org.apache.tika.metadata.DublinCore;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.xml.ElementMetadataHandler;
import org.apache.tika.parser.xml.XMLParser;
import org.apache.tika.sax.TeeContentHandler;
import org.xml.sax.ContentHandler;

/**
 * Dublin Core metadata parser
 */
public class DublinCoreXML extends XMLParser {

    /** Serial version UID */
    private static final long serialVersionUID = 4905318835463880819L;

    private static ContentHandler getDublinCoreHandler(
            Metadata metadata, Property property, String element) {
 
        return new ElementMetadataHandler(
                DublinCore.NAMESPACE_URI_DC, element,
                metadata, property);
    }

    protected ContentHandler getContentHandler(
            ContentHandler handler, Metadata metadata, ParseContext context) {
        return new TeeContentHandler(
                super.getContentHandler(handler, metadata, context),
                getDublinCoreHandler(metadata, TikaCoreProperties.TITLE, "title"),
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
                getDublinCoreHandler(metadata, TikaCoreProperties.RIGHTS, "rights")
                );
    }

}