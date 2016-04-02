package com.xin.iutils.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * 日期帮助工具类
 * Created by Administrator on 2016/4/2.
 */
public class ToolDate {

    // 日期格式
    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
    public static final String YYYYMMDD = "yyyy-MM-dd";
    public static final String MMDDHHMM = "MM-dd HH:mm";



    /**
     * 显示指定格式的时间
     * @param pattern	时间格式
     * @return			返回的时间
     */
    public static String format(String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.CHINA);
        return format.format(new Date());
    }



    /**
     * 传入 的时间格式 转化为 Date 格式
     * @param arg0
     * @return
     */
    public static Date strToDateTime(String arg0) {

        Date resultDate = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        try {
            resultDate = simpleDateFormat.parse(arg0);
            return resultDate;
        } catch (Exception e) {
            return resultDate;
        }
    }

    /**
     * 将  Date 格式 转化 为 指定的  时间 类型
     * @param arg0			Date 类型
     * @param pattern		指定的时间类型
     * @return
     */
    public static String dateTimeToStr(Date arg0,String pattern) {

        String resultStr;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        resultStr = simpleDateFormat.format(arg0);
        return resultStr;
    }



    /**
     * 得到 当前时间的毫秒数
     * @return
     */
    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }


    public static String convertLong(String msgTime, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String format = simpleDateFormat.format(new Date(Long.parseLong(msgTime)));
        return format;
    }

}
