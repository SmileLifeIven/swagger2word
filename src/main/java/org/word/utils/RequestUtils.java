package org.word.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * @author : ivenhan
 * @date : 2020/10/16
 */
public class RequestUtils {

    public static void validateRequestKey(Map<String, Map> content) throws JsonProcessingException {
//		Map<String, Map> applicationJSON = content.get("application/json");
		Map<String, Map> applicationJSON = null;
    	String[] typeArr = {"application/json", "application/x-www-form-urlencoded", "application/xml", "multipart/form-data"};
        
        for(String type : typeArr){
        	if (content.get(type) != null) {
        		applicationJSON = content.get(type);
        		validateSchema(applicationJSON, type);
        	}
        }
				
        if (applicationJSON == null) {
        	throw new JsonProcessingException("content字段 缺少" + typeArr.toString() + "字段") {};
        }
    }
    
    private static void validateSchema(Map<String, Map> applicationJSON, String type) throws JsonProcessingException {
    	Map<String, Map> schema = applicationJSON.get("schema");
        if (schema == null) {
        	throw new JsonProcessingException("content字段" + type + "缺少 schema 字段") {};
        }

        if (schema.get("type") == null) {
        	throw new JsonProcessingException("content字段" + type + "字段 schema 字段 缺少 type字段") {};
        }
        
        Map items = schema.get("items");
        Map properties = schema.get("properties");
        if (items == null && properties == null) {
        	throw new JsonProcessingException("content 字段" + type + "字段  schema 字段 缺少  properties 或者 items 字段") {};
        }
    }
}
