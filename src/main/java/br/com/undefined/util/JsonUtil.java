package br.com.undefined.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {
	private static GsonBuilder gsonBuilder;
	private static Gson gson;
	
	static {
		gsonBuilder = new GsonBuilder();
		gson = gsonBuilder.setDateFormat("dd/MM/yyyy").create();
	}
	
	public static <T> T toObject(String json, Class<T> type) {
		return gson.fromJson(json, type);
	}
	
	public static String toJson(Object object) {
		return gson.toJson(object);
	}
}
