# Enabling identification of specific metadata formats with command line tools

* [Purpose](#purpose):
  * [DataONE File Formats](#dataone-file-formats)
  * [Apace Tika](#apache-tika)

* [Using DataONE MetaDataParser](#using-dataone-metadataparser)
  * [Steps for using the application](#steps-for-using-the-application)
  * [Adding New File Format](#adding-new-file-format)
    * [Add entry in custom mimetypes file](#add-entry-in-custom-mimetypes-file)
    * [Add entry in property file](#add-entry-in-property-file)
    * [Add entry in  configuration file](#add-entry-in-configuration-file)

* [References](#References)


------------------


## Purpose
  The goal of this project is to extend the capabilities of the Apache Tika toolkit for identification of science resources. The toolkit can be used to identify new file format and extract standard metadata properties from the specified input files. A configuration file should be used for configuring new file formats for identification and specifying metadata fields of interest. The below DataONE file formats needs to be detected by the application and extract the MetaData field specified in the [config](https://github.com/DataONEorg/dataone-tika-parser/blob/master/dataone-parser/configFile.xml) file

### DataONE file formats:  
  * https://cn.dataone.org/cn/v2/formats
  * http://ns.dataone.org/metadata/schema/onedcx/v1.0
  * http://datadryad.org/profile/v3.1
  * FGDC-STD-001-1998
  * FGDC-STD-001.1999
  * http://purl.org/ornl/schema/mercury/terms/v1.0
  * http://www.isotc211.org/2005/gmd
  * http://www.isotc211.org/2005/gmd-pangaea
  * http://www.isotc211.org/2005/gmd-noaa
  * eml://ecoinformatics.org/eml-2.1.1
  * eml://ecoinformatics.org/eml-2.1.0
  * eml://ecoinformatics.org/eml-2.0.1
  * eml://ecoinformatics.org/eml-2.0.0
  * http://www.openarchives.org/ore/terms

### [Apache Tika](https://github.com/DataONEorg/file_identification/tree/master/Apache_tika):
Apache Tika toolkit provides the functionality for detecting the mimetypes of a file. This readme describes how to enable Tika for detecting new mimetypes by creating an xml file. Its ability to detect and parse file formats from over a 1000 different formats makes it a useful tool for search engine indexing, content analysis, translation etc.


## Using DataONE MetaDataParser:
The DataONEm Metadata Parser is a command line application, for extracting the standard metadata fields specified in the configuration file based on the file type detected. The application uses Apache Tika toolkit for file type detection and parsing. The application has an XML parser class for reading the config.xml file and extracts the metadata fields of interest for the file type detected. It uses these fields for parsing the input file and displays the result on the command line.

### Steps for using the application
The latest jar files for the application are stored in the [jar]() folder. Use the below command for executing the application by specifying the input file name.
```
$ java -classpath tika-app-1.18.jar:dataoneMetadataParser_v1.0.jar:custom-mimetypes.jar org.dataone.parser.DataOneMetaDataParser ../../file_identification/examples/eml-211/00_eml-211.xml
```
Below is the output for the above command:

```
-----------------------------------------------------------------------------
FILE FORMAT :text/xml; formatid="eml://ecoinformatics.org/eml-2.1.1"
-----------------------------------------------------------------------------
Title: USA National Phenology Network (USA-NPN) Plant and Animal Phenology Data for the United States, 2008
Creator: USA National Phenology Network (USA-NPN)
Description: In response to the growing need to understand the response of plant and animal species to environmental variation and climate change and to develop a widespread baseline against which future phenological change may be measured, a consortium of scientists and agencies organized the USA-NPN, with a mandate to collect and share phenology data. More information on the USA-NPN can be found at http://www.usanpn.org/about.As of January 1, 2013, the dataset contains phenology data on 591 species of plants and animals, with 7,512 locations registered across the United States. Protocols used are documented in Denny et. al., Submitted (contact nco@usanpn.org for more information). Data were collected using the phenophase status approach (Thomas et. al., 2010; Denny et. al. Submitted). Latitude and longitude given in WGS84 Datum. This is a suite of yearly data sets (Plants beginning in 2009, Animals beginning in 2010) each provided with and without full phenophase definitions.Supplemental Information:Denny, E.G., K.L. Gerst, A.J. Miller-Rushing, G.L. Tierney, T.M. Crimmins, C.A.F. Enquist, P. Guertin, A.H. Rosemartin, M.D. Schwartz, K.A. Thomas and J.F. Weltzin. Submitted. Standardized phenology monitoring methods to track plant and animal activity for science and resource management applications.Thomas, K.A., E.G. Denny, A.J. Miller-Rushing, T.M. Crimmins, and J.F. Weltzin. 2010. The National Phenology Monitoring System v0.1. USA-NPN Technical Series 2010-001. www.usanpn.org.
Contributor: USA National Phenology Network
Contributor: Alyssa; Rosemartin
Coverage: United States; -124.36; -52.78; 49.25; 29.53
Coverage: 2008
Rights: The USA-NPN National Coordinating Office (nco@usanpn.org), referred to as the “USA-NPN,” as operator of the USA-NPN Website, requires all users, referred to as “Users,” who have access to USA-NPN data via the Website to abide by the following terms of this USA-NPN Data Use Policy. 1. Data accessible via the USA-NPN National Phenology Database and Site are openly and universally available to all users. 2. The USA-NPN is not responsible for data content or the use of the data. 3. Neither the USA-NPN nor its employees or contractors is liable or responsible for the content of data, or for any loss, damage, claim, cost, or expense, however it may arise, from an inability to use the USA-NPN National Phenology Database and Site. 4. The USA-NPN disclaims all liability for and makes no warranties, expressed or implied, with respect to these products and their manufacturers, including without limitation, any implied warranties or merchantability or fitness for a particular purpose. 5. While substantial efforts are made to ensure the accuracy of USA-NPN data and documentation contained in a data set, complete accuracy of data and metadata cannot be guaranteed. All USA-NPN data and metadata are made available “as is.” Users of USA-NPN data hold all parties involved in the production and distribution of a data set harmless for damages resulting from its use or interpretation.  Disclaimer: While substantial efforts are made to ensure the accuracy of USA-NPN data and documentation contained in a data set, complete accuracy of data and metadata cannot be guaranteed. All USA-NPN data and metadata are made available "as is." Users of USA-NPN data hold all parties involved in the production and distribution of a data set harmless for damages resulting from its use or interpretation.

```
### Adding New File Format
The application performs two steps, first identifying the file format and second extraction of the metadata. It uses Tika tool kit ability for detecting the file types using a custom-mimetypes.xml file which can be used for adding new file formats for identification. For the second step, it uses the conFig.xml file for extracting the standard metadata fields for the new file formats defined in it. And to extract, the metadata properties, it needs the correct XPath values, which are defined in the `config.Properties` file. Hence, the below two steps are needed for successfully adding the new file type and extracting the metadata fields of interest.


#### Add entry in custom mimetypes file
For updating the custom-mimetypes.xml file refer to the [readme](https://github.com/DataONEorg/file_identification/tree/master/Apache_tika#creation-of-custom-mimetypes).

#### Add entry in property file
In the `config.Properties` file add the new formatId as the key and the XPath as the value for retrieving the metadata fields from the `configFile.xml `
```
## XPath for the FGDC
FGDC-STD-001-1998=//FileFormats/FileFormat[@name='fgdc-001-1998']/*

## XPath for isotc211
http\://www.isotc211.org/2005/gmd=//FileFormats/FileFormat[@name='isotc211']/*
```

#### Add entry in configuration file
Once, the new file is detected we need to create an entry for it in the conFig.xml file as below:
If the new file format uses the prefix with the namespace, than we need to add the   `<namespace> ` tags with "prefix" and "uri" attributes or else it can be ignored.

The field tags uses the `label` attribute for replacing the Xpath expression with common label across the different file formats.

```
<FileFormat name="isotc211">
    <namespaces>
      <namespace prefix="gco" uri="http://www.isotc211.org/2005/gco" />
      <namespace prefix="gmd" uri="http://www.isotc211.org/2005/gmd" />
      <namespace prefix="gmi" uri="http://www.isotc211.org/2005/gmi"/>
    </namespaces>
    <metadataFields>
      <field label="Title">
        //gmd:MD_DataIdentification/gmd:citation/gmd:CI_Citation/gmd:title
      </field>
      <field label="Creator">
        //gmd:CI_ResponsibleParty[contains(gmd:role/gmd:CI_RoleCode, 'principalInvestigator') or contains(gmd:role/gmd:CI_RoleCode,'author')]/gmd:individualName
      </field>          
    </metadataFields>
</FileFormat>
```


## References:
  * http://tika.apache.org
  * https://github.com/apache/tika
  * https://jeszysblog.wordpress.com/2012/03/05/file-type-detection-with-apache-tika/
  * https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
  * http://www.vogella.com/tutorials/JavaXML/article.html
