package org.dataone.parser.ExampleFiles;

import java.io.File;

import org.apache.tika.Tika;

public class Typedetection {

   public static void main(String[] args) throws Exception {

      //assume example.mp3 is in your current directory
      File file = new File(args[0]);
      
      //Instantiating tika facade class 
      Tika tika = new Tika();
      
      //detecting the file type using detect method
      String filetype = tika.detect(file);
      System.out.println(file +": "+ filetype);
   }
}