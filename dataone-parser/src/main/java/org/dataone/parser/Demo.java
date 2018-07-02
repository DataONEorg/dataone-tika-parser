package org.dataone.parser;

import java.util.List;

import org.apache.tika.Tika;
import org.dataone.metadata.*;
import org.apache.tika.metadata.Metadata;

import java.io.File;
import java.io.IOException;


public class Demo {
    public static void main(String args[]) {
        EmlParser read = new EmlParser();
  	  	File file = new File(args[0]);

  	  	Tika tika = new Tika();
  	 
      //detecting the file type using detect method
  	  	try {
			String filetype = tika.detect(file);
			System.out.println( file +": "+ filetype);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  		
		    List<EmlTags> readConfig = read.readConfig(args[0]);
    }
}