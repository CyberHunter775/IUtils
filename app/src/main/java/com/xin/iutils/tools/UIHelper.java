package com.xin.iutils.tools;

import java.util.List;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.app.ActivityManager.RunningServiceInfo;

/**
 * Created by Administrator on 2016/4/2.
 */
public class UIHelper {

    /**
     * 得到当前的版本号
     */
    public static int getVersion(Context context) {
        PackageManager pm = context.getPackageManager();
        PackageInfo info = null;
        try {
            info = pm.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return info.versionCode;
    }


    /**
     * 得到版本名称
     */
    public static String getVerName(Context context) {
        PackageManager pm = context.getPackageManager();
        PackageInfo info = null;
        try {
            info = pm.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return info.versionName;
    }

    /**
     * 判断某个服务是否开启
     */
    public static boolean isServiceRunning(Context context, String className) {

        boolean isRunning = false;

        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);

        List<RunningServiceInfo> runningServices = activityManager
                .getRunningServices(Integer.MAX_VALUE);

        if (!(runningServices.size() > 0)) {
            return false;
        }

        for (RunningServiceInfo runningServiceInfo : runningServices) {

            if (runningServiceInfo.service.getClassName().equals(className) == true) {
                isRunning = true;
                break;
            }
        }
        return isRunning;
    }

}
