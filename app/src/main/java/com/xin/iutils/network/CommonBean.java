package com.xin.iutils.network;

/**
 * Created by Administrator on 2016/3/22.
 */
public class CommonBean {

    private String returnCode;
    private Object data;
    private String message;

    public String getReturnCode() {
        return returnCode;
    }
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
