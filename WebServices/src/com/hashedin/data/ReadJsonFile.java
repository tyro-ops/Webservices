
package com.hashedin.data;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class ReadJsonFile {
 
	
	
public static void main(String[] args) throws Exception {
 
JSONParser parser = new JSONParser();
 
try {
 
Object obj = parser.parse(new FileReader("./data/data.json"));
 
JSONObject jsonObject = (JSONObject) obj;
 
String name = (String) jsonObject.get("name");
 System.out.println(name);
 
Long id = (Long) jsonObject.get("id");
 System.out.println(id);
 
// loop array
 JSONArray msg = (JSONArray) jsonObject.get("Message");
 //@SuppressWarnings("unchecked")
Iterator<JSONObject> iterator = msg.iterator();
 while (iterator.hasNext());
 System.out.println();
 
 {
 
 }
 
} catch (FileNotFoundException e) {
 e.printStackTrace();
 } catch (IOException e) {
 e.printStackTrace();
 } catch (ParseException e) {
 e.printStackTrace();
 }
 
}
 
}