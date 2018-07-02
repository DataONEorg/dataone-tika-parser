package org.dataone.parser;

import java.util.Map;
import org.dataone.metadata.DataOneMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class testMapper {
	
	 public static void main(String[] args) {
		 
		 DataOneMapper dataOneMapper = new DataOneMapper();
		 //dataOneMapper.DataOneMapper();
		// System.out.println(dataOneMapper.DataOneMapper().keySet());
		 System.out.println(dataOneMapper.metadataMap.get("spatial"));
		 
	 }

}
