package com.hashedin.data;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
	 
	public class WriteJsonFile  {
	    
		
		@SuppressWarnings("unchecked")
		public static void main(String[] args) {
	 
		JSONObject obj = new JSONObject();
		obj.put("name", "Yogesh");
		obj.put("id", new Integer(50));
	    obj.put("Location", "Bangalore");
	    
	    
		JSONArray list = new JSONArray();
		list.add("msg 1");
		list.add("msg 2");
		list.add("msg 3");
	 
		obj.put("messages", list);
	 
		try {
	 
			FileWriter file = new FileWriter("./data/data.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
		System.out.print(obj);
	 
	     }
	 
	}


