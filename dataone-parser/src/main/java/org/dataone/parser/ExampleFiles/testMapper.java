package org.dataone.parser.ExampleFiles;

import java.util.Map;
import java.util.Map.Entry;

import org.dataone.metadata.DataOneMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class testMapper {
	
	 public static void main(String[] args) {
		 
		 DataOneMapper dataOneMapper = new DataOneMapper();
		 
		 System.out.println(dataOneMapper.metadataMap.get("eastBoundingCoordinate"));
		 System.out.println(dataOneMapper.metadataMap.values());
		 
		 System.out.println(dataOneMapper.metadataMap.keySet());

		 /*
		 for (Entry<String, String> entry : dataOneMapper.metadataMap.entrySet()) {
			 System.out.println(entry.get));
		 }
		 */
	 }

}
