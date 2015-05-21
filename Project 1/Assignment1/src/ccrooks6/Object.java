package ccrooks6;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import ravensproject.RavensObject;

public class Object extends Figure {

	public int count; 
	public String figureBackup; 
	HashMap<String, String> list;

	HashMap<String, RavensObject> objects;

	public Object()
	{
	
		count = 0; 
		list = new HashMap<String, String>(); 
	}
	
	public Object(HashMap<String, RavensObject> objects) {
		this.objects = objects; 
	}

	public void setNumObjects(int count)
	{
		this.count = count;
	}
	
	
	public void printFigureObjects(String figureName) throws IOException
	{
		int globalcount = 0; 
		
		
		FileOutputStream outputStream;
		  OutputStreamWriter outputStreamWriter;
		  BufferedWriter bufferedWriter = null;
		  outputStream = new FileOutputStream("Figure"+figureName +".txt");
		  outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
          bufferedWriter = new BufferedWriter(outputStreamWriter);

  		for (RavensObject ro : objects.values()) {
  			
  			System.out.println("Printing Objects for figure " + figureName); 
  			System.out.println(ro.getName());
  		
		
	      //  System.out.println(figureName + " " + pair.getKey());
	     
	        
	        try {
	             
	           
	             
	           bufferedWriter.write(figureName + " " + ro.getName());
	            bufferedWriter.newLine();
	         
	             
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	       
		}
		 bufferedWriter.close();
	}
	
	

	public void printObjectValues(String figure) throws IOException
	{
		int counter = 0; // this contains how many 
		String fileName = "Figure"+figure+ ".txt";
		InputStream is = new BufferedInputStream(new FileInputStream(fileName));
		// this will read the new file created use figure to open the file. 
		try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	       counter = (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
		
		
		
		System.out.println("The total objects in " + figure + " = " + counter);
		
	}
	
	
	
	
}
