package com.xin.iutils.network;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.xin.volleyframe.AppContext;

import org.json.JSONObject;

/**
 *  Request 管理..
 *  这里我们只使用的 是   JsonOjectRequeset..这个子类..
 */
public class VolleyManger {

	// 静态，这里设计成单例模式 应该会好一点.
	// 设计成单例模式..
	public static RequestQueue mRequestQueue = null;
	public static RequestQueue  getInstance(){
		
		if (mRequestQueue==null) {
			mRequestQueue = Volley.newRequestQueue(AppContext.getContext());
			
		}
		return mRequestQueue;
	}

	
	/**
	 *  返回 JsonObject
	 *  
	 * @param tag			上下文
	 * @param requestCode	请求号
	 * @param url			url
	 * @param listener		监听回调..
	 */
	public static void get(Object tag,String requestCode,String url, VolleyCallBack listener) {
		get(tag, requestCode, url, false, null, null, listener);
	}
	/**
	 * 返回JsonObject 带进度条 自定义 进度条显示的文字..
	 * @param tag			上下文
	 * @param url			url
	 * @param requestCode		请求号
	 * @param progressTitle		进度条文字 ，可以为空，显示默认
	 * @param listener			上下文
	 */
	public static void get(Object tag,String url,String requestCode,String progressTitle,VolleyCallBack listener) {
		
		LoadingFragment dialog = new LoadingFragment();
		
		if (tag instanceof Activity) {
			dialog.show(((Activity) tag).getFragmentManager(),"Loading");
		}else if(tag instanceof Fragment){
			// 在Fragment中 这个对话框该如何加载，这个还值得 进一步的验证..
			dialog.show(((Fragment) tag).getFragmentManager(),"Loading");
		}
		
		dialog.setMsg(progressTitle);
		get(tag, requestCode, url, true, dialog, progressTitle, listener);
		
	}


	/**
	 * 
	 * @param tag			上下文
	 * @param requestCode	请求号
	 * @param url			请求地址
	 * @param flag			是否有进度条..
	 * @param p				进度条
	 * @param progressTitle	进度条显示内容
	 * @param listener		回调监听..
	 */
	public static void get(Object tag,String requestCode,String url,boolean flag,LoadingFragment p,String progressTitle,VolleyCallBack listener){
		
		// 还有各种，是否有进度条之类的..
		// 如果没有该怎么处理..
		cancelAll(tag);
		
		JsonObjectRequest request = new JsonObjectRequest(
				Method.GET,
				url,
				null,
				responseListener(listener, requestCode, flag, p), 
				responseError(listener, requestCode, flag, p));
		
		addRequest(request, tag);
	
	}
	
	
	/**
	 * 不带进度条的  post 解析
	 * @param tag				上下文
	 * @param requestCode		请求码
	 * @param url				url
	 * @param jsonRequest		发送的 Json 数据
	 * @param listener			监听回调..
	 */
	public static void post(Object tag,String requestCode,String url,JSONObject jsonRequest,VolleyCallBack listener){
		post(tag, requestCode, url, false, null, null, jsonRequest, listener);
	}
	
	
	/**
	 * 带进度条的 post 解析
	 * @param tag				上下文
	 * @param requestCode		请求码
	 * @param url				地址
	 * @param progressTitle		进度条显示
	 * @param jsonRequest		发送的 Json 数据
	 * @param listener			回调
	 */
	public static void post(Object tag,String requestCode,String url,String progressTitle,JSONObject jsonRequest,VolleyCallBack listener){
		
		LoadingFragment dialog = new LoadingFragment();
		
		if (tag instanceof Activity) {
			dialog.show(((Activity) tag).getFragmentManager(),"Loading");
		}else if(tag instanceof Fragment){
			// 在Fragment中 这个对话框该如何加载，这个还值得 进一步的验证..
			dialog.show(((Fragment) tag).getFragmentManager(),"Loading");
		}
		
		dialog.setMsg(progressTitle);
		post(tag, requestCode, url, true, dialog, progressTitle, jsonRequest, listener);
		
	}
	
	
	/**
	 * 
	 * post 请求..使用 发送  Json 数据到服务器..
	 * @param tag			上下文
	 * @param requestCode	请求号
	 * @param url			请求地址
	 * @param flag			是否有进度条..
	 * @param p				进度条
	 * @param progressTitle	进度条显示内容
	 * @param listener		回调监听..
	 */
	public static void post(Object tag,String requestCode,String url,boolean flag,LoadingFragment p,String progressTitle,JSONObject jsonRequest,VolleyCallBack listener){
		
		cancelAll(tag);
		
		JsonObjectRequest request = new JsonObjectRequest(
				Method.POST,
				url,
				jsonRequest,
				responseListener(listener, requestCode, flag, p), 
				responseError(listener, requestCode, flag, p));
		
		addRequest(request, tag);
	}

	/**
	 * 成功消息监听 返回 JSONObject
	 * 
	 * @param l String 接口
	 * @param flag true 带进度条 flase不带进度条
	 * @param p 进度条的对象
	 * @return
	 */
	protected static Response.Listener<JSONObject> responseListener(
			final VolleyCallBack l, final String requestCode, final boolean flag,final LoadingFragment p) {
		
		return new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject json) {

				Log.d("Log","请求号："+requestCode+"---> "+json.toString());
				l.requestSuccess(requestCode,json);
				showDialog(flag, p);
			}
			
		};
	}

	/**
	 *  返回错误监听
	 * 
	 * @param l String 接口
	 * @param flag true 带进度条 flase不带进度条
	 * @param p 进度条的对象
	 * @return
	 */
	protected static Response.ErrorListener responseError(
			final VolleyCallBack l, final String requestCode,final boolean flag, final LoadingFragment p) {
		return new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError e) {

				Log.d("Log", "请求号："+requestCode+"---> "+e.toString());

				l.requestError(requestCode,e);
				showDialog(flag, p);
			}
		};
	}
	
	
	private void showLoadingFragment(Context context){
		LoadingFragment dialog = new LoadingFragment();
	}
	

	
	/**
	 * 判断进度条..
	 * 
	 * @param flag	是否显示进度条..
	 * @param p
	 */
	private static void showDialog(final boolean flag, LoadingFragment p) {
		
		if (flag) {
			if (p.getShowsDialog()) {
				p.dismiss();
			}
		}
	}


	public static void addRequest(Request<?> request, Object tag) {
		if (tag != null) {
			request.setTag(tag);
		}
		getInstance().add(request);
	}
	/**
	 * 当主页面调用协议 在结束该页面调用此方法
	 * @param tag
	 */
	public static void cancelAll(Object tag) {
		getInstance().cancelAll(tag);
	}
}
