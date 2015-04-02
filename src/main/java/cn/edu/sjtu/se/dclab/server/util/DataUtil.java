package cn.edu.sjtu.se.dclab.server.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *2015年4月2日 下午3:13:42
 *@author changyi yuan
 */
public class DataUtil {
	public static Map getFromJson(String jsonStr){
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String,String> map = null;
		try{
			map = (HashMap<String,String>) mapper.readValue(jsonStr,HashMap.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
}
