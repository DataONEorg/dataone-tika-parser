# @begin dataoneMetadataParser @desc File identification and content extraction.
# @in inputFile
# @param config_properties
# @param config_file
# @out file_format
# @out metadataContent

# @begin file_identification @desc detect the file Type.
# @in file @as inputFile

# @out file_format
# @end file_identification

# @begin getXPath @desc get the XPath of the file type for extracting fields
# @in file_format
# @param config_properties
# @out xPath
# @end getXpath

# @begin getmetadata @desc Extract metadata fields from the configFile.xml
# @param config_file
# @in xPath

# @out metadatafields
# @end getmetadata

# @begin extractcontents @desc Extract contents using metadata fields from the infput file
# @in metadatafields
# @in inputFile

# @out metadataContent

# @end extractcontents

# @end dataoneMetadataParser
