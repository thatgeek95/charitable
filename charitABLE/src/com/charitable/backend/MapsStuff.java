package com.charitable.backend;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MapsStuff {
	
	public static double TwoPointsDistance(String inZIP, String destZIP) throws Exception {
		double out = 0.0;
		
		String jsonConstruct = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + inZIP + "&destinations=" + destZIP + "&key=AIzaSyAQmzy0YYgnjKx89L8MQk6HsAHG3oStgQw";
		String json = JSONStuff.readUrl(jsonConstruct);
		
		 JSONParser parser = new JSONParser();
         Object obj = parser.parse(json);
         JSONObject jb = (JSONObject) obj;

         //now read
         JSONArray rows = (JSONArray) jb.get("rows");
         JSONObject objJ = (JSONObject) rows.get(0);
         JSONArray elements = (JSONArray) objJ.get("elements");
         JSONObject objE = (JSONObject) elements.get(0);
         JSONObject distance = (JSONObject) objE.get("distance");
         Long value = (Long) distance.get("value");
         out = (double) value * 0.00062137;
         
		return out;
	}

}