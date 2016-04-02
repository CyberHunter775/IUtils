package com.xin.iutils.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/4/2.
 */
public class ToolRegex {

    /**
     * 身份证号码Pattern 只验证位数
     */
    private static final Pattern PATTERN_IDENTITY_CARD = Pattern.compile("(\\d{17}[0-9|x|X])");
    /**
     * 手机号码Pattern
     */
    private static final Pattern PATTERN_MOBILE_NUMBER = Pattern.compile("\\d{11}");

    /**
     * 身份证号码是否正确
     */
    public static boolean isIdentityCard(String s) {
        Matcher m = PATTERN_IDENTITY_CARD.matcher(s);
        return m.matches();
    }
    /**
     * 手机号码否正确
     */
    public static boolean isMobileNumber(String s) {
        Matcher m = PATTERN_MOBILE_NUMBER.matcher(s);
        return m.matches();
    }

    public static boolean isEmail(String strEmail) {
        String strPattern = "^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(strEmail);
        return m.matches();
    }
}
