package org.dataone.metadata;

import java.util.ArrayList;
import java.util.List;

public class emlMetadata {
	public List<String> metadataFields = new ArrayList<String>();
	
	public emlMetadata() {
		

		metadataFields.add("abstract");
		metadataFields.add("title");
		metadataFields.add("creator");
		metadataFields.add("associatedParty");
		metadataFields.add("boundingCoordinates");
	}
}
