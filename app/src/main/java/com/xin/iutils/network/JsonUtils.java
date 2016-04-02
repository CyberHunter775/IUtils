package com.xin.iutils.network;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * json管理
 */
public class JsonUtils {
	
	public static final String RETURN_OK = "1";				// 服务器请求成功
	public static final String RETURN_ERROR = "0";			// 服务器请求失败
	
	public static <T> T fromJson(String json,Class<T> classOfT){
		return JSON.parseObject(json,classOfT);
	}
	
	public static<T> List<T> fromJsonArray(String json,Class<T> classs){
		return JSON.parseArray(json, classs);
	}
}
