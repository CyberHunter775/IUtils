package com.xin.iutils.tools;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/4/2.
 */
public class ToolToast {

    /**
     * @param context
     * @param mes
     */
    public static void shortToastShow(final Activity context, final String mes) {

        if ("main".equals(Thread.currentThread())) {
            Toast.makeText(context, mes, Toast.LENGTH_SHORT).show();
        } else {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Toast.makeText(context, mes, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * @param context
     * @param mes
     */
    public static void longToastShow(final Activity context, final String mes) {

        if ("main".equals(Thread.currentThread())) {
            Toast.makeText(context, mes, Toast.LENGTH_LONG).show();
        } else {
            context.runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    Toast.makeText(context, mes, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    /**
     * @param context
     * @param mes
     * @param imgResource
     */
    public static void shortToastShowImage(final Activity context,
                                           final String mes, final int imgResource) {

        if ("main".equals(Thread.currentThread())) {

            Toast toast = Toast.makeText(context, mes, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            LinearLayout toastView = (LinearLayout) toast.getView();
            ImageView imageCodeProject = new ImageView(context);
            imageCodeProject.setImageResource(imgResource);
            toastView.addView(imageCodeProject, 0);
            toast.show();

        } else {
            context.runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    Toast toast = Toast.makeText(context, mes,
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    LinearLayout toastView = (LinearLayout) toast.getView();
                    ImageView imageCodeProject = new ImageView(context);
                    imageCodeProject.setImageResource(imgResource);
                    toastView.addView(imageCodeProject, 0);
                    toast.show();
                }
            });
        }
    }


    /**
     * @param context
     * @param mes
     */
    public static void shortToastShow(final Context context, final String mes) {

        if ("main".equals(Thread.currentThread())) {
            Toast.makeText(context, mes, Toast.LENGTH_SHORT).show();
        } else {
            ((Activity) context).runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Toast.makeText(context, mes, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
