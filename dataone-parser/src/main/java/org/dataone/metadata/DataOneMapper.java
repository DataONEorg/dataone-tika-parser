package org.dataone.metadata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataOneMapper
{	
	private Map<String, List<String>> metadataMap = new HashMap<String, List<String>>();
	public List<String> titles = new ArrayList<String>();
	public List<String> abstracts = new ArrayList<String>();
	public List<String> authors = new ArrayList<String>();
	public List<String> keywords = new ArrayList<String>();

	
	public Map<String, List<String>> DataOneMapper() {
		metadataMap.put("title",addTitles());
		metadataMap.put("abstract",addAbstracts());
		metadataMap.put("keyword",addKeywords());
		
		//System.out.println(metadataMap.values().toString());
		return metadataMap;
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
		
		keywords.add("spatial");
		keywords.add("boundingCoordinates");
		keywords.add("westBoundingCoordinate");
		keywords.add("eastBoundingCoordinate");
		keywords.add("northBoundingCoordinate");
		keywords.add("southBoundingCoordinate");
		
		//keywords.add(Eml211.KEYWORDS.toString());
		return keywords;
	}

}