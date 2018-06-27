package org.dataone.parser;
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.dataone.metadata.Eml211;
import org.dataone.metadata.Onedcx;

import java.io.IOException;
import java.io.InputStream;
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


public class Eml211Parser extends XMLParser  {

    /** Serial version UID */
    private static final long serialVersionUID = 4905318835463880819L;
    private static final Set<MediaType> SUPPORTED_TYPES = Collections.singleton(MediaType.application("eml-211"));
    public static final String Eml211_MIME_TYPE = "text/xml; formatid=\"" + Eml211.NAMESPACE_URI+"\"";

    private static ContentHandler getEMLCoreHandler(
            Metadata metadata, Property property, String element) {
    	
    		//System.out.println(element+metadata+property);
        return new ElementMetadataHandler(
                Eml211.NAMESPACE_URI,
        		element,
                metadata, 
                property,
                true,
                false);
    }

    protected ContentHandler getContentHandler(
            ContentHandler handler, Metadata metadata, ParseContext context) {
    		metadata.set(Metadata.CONTENT_TYPE, Eml211_MIME_TYPE);
    		
    		//System.out.println(metadata);
    		
    		return new TeeContentHandler(
						super.getContentHandler(handler, metadata, context),
						getEMLCoreHandler(metadata, Eml211.PRINCIPAL, "principal"),
						getEMLCoreHandler(metadata, Eml211.DELIVERYPOINT, "deliveryPoint"),
						getEMLCoreHandler(metadata, Eml211.KEYWORD, "keyword"),
						getEMLCoreHandler(metadata, Eml211.BOXSPATIALBOUNDCOORDINATES, "boundingCoordinates")
    				);
    }

}