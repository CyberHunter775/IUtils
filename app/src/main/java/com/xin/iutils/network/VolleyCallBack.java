package com.xin.iutils.network;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * 网络访问的回调接口
 * @author xin
 * @date 2016-1-5
 *
 */
public interface VolleyCallBack  {

    /** 成功 */
    public void requestSuccess(String requestCode, JSONObject json);

    /** 错误 */
    public void requestError(String requestCode, VolleyError e);
    
}
