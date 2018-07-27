#! /usr/bin/shell

fileName=$1 

java -classpath tika-app-1.18.jar:dataoneMetadataParser_v1.0.jar:custom-mimetypes.jar org.dataone.parser.DataOneMetaDataParser $fileName

