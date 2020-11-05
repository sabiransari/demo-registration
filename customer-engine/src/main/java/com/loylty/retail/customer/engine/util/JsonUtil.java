package com.loylty.retail.customer.engine.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static <T> String toJson(T object) throws JsonProcessingException {
		return objectMapper.writeValueAsString(object);
	}
	
	public static <T> T fromJson(String json, Class<T> clazz) throws JsonMappingException, JsonProcessingException {
		return objectMapper.readValue(json, clazz);
	}
}
