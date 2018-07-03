package org.dataone.metadata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataOneMapper
{	
	
	
	/*
	 *
	 *  public Map<String, List<String>> metadataMap = new HashMap<String, List<String>>();
		public List<String> titles = new ArrayList<String>();
		public List<String> spatial = new ArrayList<String>();
		public List<String> abstracts = new ArrayList<String>();
		public List<String> authors = new ArrayList<String>();
		public List<String> keywords = new ArrayList<String>();
	
	public DataOneMapper() {
		metadataMap.put("title",addTitles());
		metadataMap.put("abstract",addAbstracts());
		metadataMap.put("keyword",addKeywords());
		metadataMap.put("spatial",addSpatial());

	}
	private List<String> addTitles() {	
		titles.add("title");
		return titles;
	}
	
	private List<String> addAbstracts() {
		abstracts.add("abstract");
		//abstracts.add(Eml211.ABSTRACT.toString());
		return abstracts;
	}
	
	
	private List<String> addKeywords() {
		
		keywords.add("keywords");
		//keywords.add(Eml211.KEYWORDS.toString());
		return keywords;
	}
	
	private List<String> addSpatial() {
		
		spatial.add("spatial");
		spatial.add("boundingcoordinates");
		spatial.add("westBoundingCoordinate");
		spatial.add("eastBoundingCoordinate");
		spatial.add("northBoundingCoordinate");
		spatial.add("southBoundingCoordinate");
		
		//keywords.add(Eml211.KEYWORDS.toString());
		return spatial;
	}
	
	*/

	public Map<String, String> metadataMap = new HashMap<String, String>();
	public DataOneMapper() {
		
		
		metadataMap.put("title","title");
		metadataMap.put("abstract","abstract");
		metadataMap.put("keyword","keywords");
		metadataMap.put("keyword","keywords");

		/*
		 * Spatial MEtadata Field *
		 */
		metadataMap.put("spatial","spatial");
		metadataMap.put("southBoundingCoordinate","spatial");
		metadataMap.put("northBoundingCoordinate","spatial");
		metadataMap.put("eastBoundingCoordinate","spatial");

		/*
		 * Temporal Metadata Field *
		 */
		metadataMap.put("temporal","temporal");
		metadataMap.put("calendarDate","temporal");
		metadataMap.put("endDate","temporal");
		metadataMap.put("beginDate","temporal");
	}
}