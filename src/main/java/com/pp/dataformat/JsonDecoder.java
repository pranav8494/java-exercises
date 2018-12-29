/**
 * 
 */
package com.pp.dataformat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ppandey
 *
 */
public class JsonDecoder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String jsonString = "{\"compress\":{\"threshold\": 21000,\"history\": 1000,\"gain\": 10}}";
		parseJson(jsonString);

	}

	private static void parseJson(String jsonString) {
		Map<String, Map<String, Integer>> myMap = new HashMap<String, Map<String, Integer>>();

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			myMap = objectMapper.readValue(jsonString, HashMap.class);
			System.out.println("keys: " + myMap.keySet());
			System.out.println("compress: " + myMap.get("compress"));
			System.out.println("Map Parsed from json: " + myMap);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
