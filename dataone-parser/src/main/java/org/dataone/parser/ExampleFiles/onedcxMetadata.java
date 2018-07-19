package org.dataone.parser.ExampleFiles;

import java.util.ArrayList;
import java.util.List;

public class onedcxMetadata {
	public List<String> metadataFields = new ArrayList<String>();
	
	public onedcxMetadata() {
		

		metadataFields.add("simpleDc");
		metadataFields.add("title");
		metadataFields.add("dc:subject");
		metadataFields.add("dcTerms");
		//metadataFields.add("spatial");
	}
}
