package org.dataone.parser;


import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.AbstractParser;
import org.apache.tika.sax.XHTMLContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class dataone_onedcx extends AbstractParser {

        private static final Set<MediaType> SUPPORTED_TYPES = Collections.singleton(MediaType.application("onedcx"));
        public static final String ONEDCX_MIME_TYPE = "text/xml; formatid=\"http\\:\\/\\/ns.dataone.org\\/metadata\\/schema\\/onedcx\\/v1.0\"";
        
        public Set<MediaType> getSupportedTypes(ParseContext context) {
                return SUPPORTED_TYPES;
        }

        public void parse(
                        InputStream stream, ContentHandler handler,
                        Metadata metadata, ParseContext context)
                        throws IOException, SAXException, TikaException {

                metadata.set(Metadata.CONTENT_TYPE, ONEDCX_MIME_TYPE);
                metadata.set("text/xml", "text/xml; formatid=\"http\\:\\/\\/ns.dataone.org\\/metadata\\/schema\\/onedcx\\/v1.0\"");

                XHTMLContentHandler xhtml = new XHTMLContentHandler(handler, metadata);
               
   
        }
}