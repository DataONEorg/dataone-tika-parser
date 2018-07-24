# Enabling identification of specific metadata formats with command line tools

* [Purpose](#purpose):
  * [DataONE File Formats](#dataone-file-formats)
  * [Apace Tika](#apache-tika)
  * [Using DataONE MetaDataParser](#using-dataone-metadataparser)
    *  [Steps for using the application](#steps-for-using-the-application)
  * [Adding New File Format](#adding-new-file-format)

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


### Using DataONE MetaDataParser:
The DataONEm Metadata Parser is a command line application, for extracting the standard metadata fields specified in the configuration file based on the file type detected. The application uses Apache Tika toolkit for file type detection and parsing. The application has an XML parser class for reading the config.xml file and extracts the metadata fields of interest for the file type detected. It uses these fields for parsing the input file and displays the result on the command line.

#### Steps for using the application
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
## Installing and Using dataone magic file:

### On Linux:
The file 3.4 version and above will contain the latest changes but for using the dataone magic file with earlier versions on Linux system, kindly follow the below steps:

1. Clone the [file](https://github.com/file/file) github repository.
2. Remove the earlier magic files from the system using below command
  `sudo apt-get purge libmagic1 file`
3. Follow the below steps for compiling and installing the new magic files.
  * autoconf
  * ./configure make
  * make check -no errors
  * make install
  * make installcheck - no errors

### On Mac:

On Mac, the replacing and compiling of the libmagic file may be tedious. Hence, you may use the below hack for using the dataone magic file on Mac with earlier version of file.
1. Copy the compiled [magic.mgc](https://github.com/DataONEorg/file_identification/blob/master/magic_files/magic.mgc) file to local system.
2. Create an alias as below or use "-m" option.
  ```
   alias blah="file -m magic_files/magic.mgc"
   blah examples/eml-200/*
   examples/eml-200/00_eml-200.xml: eml://ecoinformatics.org/eml-2.0.0
  examples/eml-200/01_eml-200.xml: eml://ecoinformatics.org/eml-2.0.0
  examples/eml-200/03_eml-200.xml: eml://ecoinformatics.org/eml-2.0.0
  ```

  ```
  $ file -m magic_files/magic.mgc examples/eml-200/*
    examples/eml-200/00_eml-200.xml: eml://ecoinformatics.org/eml-2.0.0
    examples/eml-200/01_eml-200.xml: eml://ecoinformatics.org/eml-2.0.0
    examples/eml-200/02_eml-200.xml: eml://ecoinformatics.org/eml-2.0.0
  ```

## Python Unittest:
A unittest is also developed for testing the custom magic file for identifying the correct file types from the examples provided.
This test can be executed after cloning the repository and installing the `filemagic` using the below command.

The output of the unittest is as below. The test will fail for FGDC-STD-001-1999 as we are still working on that file format.
```
$ pip install filemagic

$ python -m unittest discover -v

test_dryad (test.test_fileExt.TestFileExt) ... ok
test_eml_200 (test.test_fileExt.TestFileExt) ... ok
test_eml_201 (test.test_fileExt.TestFileExt) ... ok
test_eml_210 (test.test_fileExt.TestFileExt) ... ok
test_eml_211 (test.test_fileExt.TestFileExt) ... ok
test_fgdc1998 (test.test_fileExt.TestFileExt) ... ok
test_fgdc1999 (test.test_fileExt.TestFileExt) ... FAIL
test_isotc211 (test.test_fileExt.TestFileExt) ... ok
test_isotc211_noaa (test.test_fileExt.TestFileExt) ... ok
test_isotc211_pangaea (test.test_fileExt.TestFileExt) ... ok
test_mercury (test.test_fileExt.TestFileExt) ... ok
test_onedcx (test.test_fileExt.TestFileExt) ... ok
test_resourcemap (test.test_fileExt.TestFileExt) ... ok

======================================================================
FAIL: test_fgdc1999 (test.test_fileExt.TestFileExt)
----------------------------------------------------------------------
Traceback (most recent call last):
  File "/Users/pratikshrivastava/Desktop/OneDrive - University of Illinois - Urbana/Box/GitHub/DataONE/internship2018/file_identification/test/test_fileExt.py", line 37, in test_fgdc1999
    self.assertEqual(getFileExt("examples/fgdc-1999/"+fileName), 'FGDC-STD-001-1999', "Incorrect File extension for file: {0}" .format(fileName))
AssertionError: 'ASCII text, with very long lines' != 'FGDC-STD-001-1999'
- ASCII text, with very long lines
+ FGDC-STD-001-1999
 : Incorrect File extension for file: 09_fgdc-1999.xml

----------------------------------------------------------------------
Ran 13 tests in 0.221s

FAILED (failures=1)
```


## References:
  * https://github.com/file/file
  * http://openpreservation.org/blog/2012/08/09/magic-editing-and-creation-primer
  * https://linux.die.net/man/1/file
  * https://filemagic.readthedocs.io/en/latest/guide.html
  * http://pythontesting.net/framework/unittest/unittest-introduction/
  * http://www.patricksoftwareblog.com/python-unit-testing-structuring-your-project/
