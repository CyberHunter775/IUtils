package com.xin.iutils.network;

import org.json.JSONObject;

/**
 * 网络请求的封装..
 * @author xin
 * @date 2015-12-17
 */
public class VolleyRequest {
	/**
	 * 不带进度条  get 请求..
	 * @param tag
	 * @param requestCode
	 * @param url
	 * @param listener
	 */
	public static  void get(Object tag,String requestCode,String url,VolleyCallBack listener){
		VolleyManger.get(tag, requestCode, url, listener);
	}
	
	/**
	 * 带 进度条 的 get 请求..
	 * @param tag
	 * @param url
	 * @param requestCode
	 * @param progressTitle
	 * @param listener
	 */
	
	public static void get(Object tag,String requestCode,String url,String progressTitle,VolleyCallBack listener){
		VolleyManger.get(tag, url, requestCode, progressTitle, listener);
	}
	
	
	/**
	 *  不带 进度条的 Post 请求..
	 * @param tag
	 * @param request
	 * @param url
	 * @param jsonRequest
	 * @param listener
	 */
	public static void post(Object tag,String requestCode,String url,JSONObject jsonRequest,VolleyCallBack listener){
		VolleyManger.post(tag, requestCode, url, jsonRequest, listener);
	}
	
	/**
	 * 带进度条的 post 请求..
	 * @param tag
	 * @param requestCode
	 * @param url
	 * @param progressTitle
	 * @param jsonRequest
	 * @param listener
	 */
	public static void post(Object tag,String requestCode,String url,String progressTitle,JSONObject jsonRequest,VolleyCallBack listener){
		VolleyManger.post(tag, requestCode, url, progressTitle, jsonRequest, listener);
	}
	
}
