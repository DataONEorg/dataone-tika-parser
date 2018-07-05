package org.dataone.metadata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class XpathForMetadata {

	public Map<String, List<String>> Xpaths = new HashMap<String, List<String>>();
	public List<String> emlXpath = new ArrayList<String>();
	public List<String> onedcxXpath = new ArrayList<String>();

	public XpathForMetadata() {
		
		/*
		 * Xpaths for EML  
		 */
		
		// Get all the root elements at same level. 
		  //methods/sampling/studyExtent/
		  //methods/sampling/samplingDescription/
		  //methods/methodStep/description/section/title
		  //methods/methodStep/description/section/para

		emlXpath.add("//dataset/*");
		
		emlXpath.add("//dataset/creator/*");
		emlXpath.add("//dataset/creator/address/*");
		
		emlXpath.add("//dataset/associatedParty/*");
		emlXpath.add("//dataset/associatedParty/individualName/*");
		emlXpath.add("//dataset/associatedParty/individualName/address/*");
		
		emlXpath.add("//dataset/intellectualRights/*");
		emlXpath.add("//dataset/keywordSet/*");
		
		emlXpath.add("//dataset/coverage/*");
		emlXpath.add("//dataset/coverage/geographicCoverage/*");
		emlXpath.add("//dataset/coverage/geographicCoverage/boundingCoordinates/*");
		emlXpath.add("//dataset/coverage/temporalCoverage/*");
		
		
		emlXpath.add("//dataset/contact/*");
		emlXpath.add("//dataset/contact/individualName/*");
		emlXpath.add("//dataset/contact/individualName/address/*");

		emlXpath.add("//dataset/methods/*");
		emlXpath.add("//dataset/methods/methodStep/*");
		emlXpath.add("//dataset/methods/sampling/*");
		emlXpath.add("//dataset/methods/sampling/samplingDescription/*");
		
		emlXpath.add("//dataset/dataTable/*");
		emlXpath.add("//dataset/dataTable/physical/*");
		
		emlXpath.add("//dataset//dataTable/physical/distribution/*");
		emlXpath.add("//dataset/dataTable/physical/distribution/online/*");
		
		emlXpath.add("//dataset/dataTable/physical/dataFormat/*");
		emlXpath.add("//dataset/dataTable/physical/dataFormat/externallyDefinedFormat/*");
		
		emlXpath.add("//dataset/dataTable/attributeList/*");
		emlXpath.add("//dataset/dataTable/attributeList/attribute/*");
		emlXpath.add("//dataset/dataTable/attributeList/attribute/measurementScale/*");
		emlXpath.add("//dataset/dataTable/attributeList/attribute/measurementScale/nominal/*");
		emlXpath.add("//dataset/dataTable/attributeList/attribute/measurementScale/nominal/nonNumericDomain/*");
		emlXpath.add("//dataset/dataTable/attributeList/attribute/measurementScale/nominal/nonNumericDomain/textDomain/*");
		emlXpath.add("//dataset/dataTable/attributeList/attribute/measurementScale/nominal/nonNumericDomain/enumeratedDomain/*");
		emlXpath.add("//dataset/dataTable/attributeList/attribute/measurementScale/nominal/nonNumericDomain/enumeratedDomain/codeDefinition/*");

		
		
		
	}
}
