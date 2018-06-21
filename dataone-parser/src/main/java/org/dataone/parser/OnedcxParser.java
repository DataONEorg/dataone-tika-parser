package org.dataone.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.DublinCore;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.TeeContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.apache.tika.parser.xml.DcXMLParser;
import org.apache.tika.parser.xml.XMLParser;
import org.apache.tika.parser.xml.ElementMetadataHandler;
import org.apache.tika.sax.XHTMLContentHandler;

/**
 * Dublin Core metadata parser
 */
public class OnedcxParser extends XMLParser {

    /** Serial version UID */
    private static final long serialVersionUID = 4905318835463880819L;
    
    private static final Set<MediaType> SUPPORTED_TYPES = Collections.singleton(MediaType.application("onedcx"));
    public static final String ONEDCX_MIME_TYPE = "text/xml; formatid=\"http\\:\\/\\/ns.dataone.org\\/metadata\\/schema\\/onedcx\\/v1.0\"";
    
    public Set<MediaType> getSupportedTypes(ParseContext context) {
            return SUPPORTED_TYPES;
    }
    
//    public void parse(
//            InputStream stream, ContentHandler handler,
//            Metadata metadata, ParseContext context)
//            throws IOException, SAXException, TikaException {
//    		metadata.set(Metadata.CONTENT_TYPE, ONEDCX_MIME_TYPE);
//    		metadata.set("Title", "2006 Ice Watch Joint Ocean Ice Study (JOIS) Sea Ice Observation Program");
//    }

    private static ContentHandler getDublinCoreHandler(
            Metadata metadata, Property property, String element) {
        return new ElementMetadataHandler(
                DublinCore.NAMESPACE_URI_DC, element,
                metadata, property);
    }

    protected ContentHandler getContentHandler(
            ContentHandler handler, Metadata metadata, ParseContext context) {
        metadata.set(Metadata.CONTENT_TYPE, ONEDCX_MIME_TYPE);
        metadata.set("text/xml", "text/xml; formatid=\"http\\:\\/\\/ns.dataone.org\\/metadata\\/schema\\/onedcx\\/v1.0-PRatik\"");

        return new TeeContentHandler(
                super.getContentHandler(handler, metadata, context),
                getDublinCoreHandler(metadata, TikaCoreProperties.TITLE, "title")
   //             getDublinCoreHandler(metadata, TikaCoreProperties.SUBJECT, "subject"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.CREATOR, "creator"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.DESCRIPTION, "description"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.PUBLISHER, "publisher"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.CONTRIBUTOR, "contributor"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.CREATED, "date"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.TYPE, "type"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.FORMAT, "format"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.IDENTIFIER, "identifier"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.LANGUAGE, "language"),
//                getDublinCoreHandler(metadata, TikaCoreProperties.RIGHTS, "rights")
                );
    }

}