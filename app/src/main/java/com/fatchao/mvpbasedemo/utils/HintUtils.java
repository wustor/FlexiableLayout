package com.fatchao.mvpbasedemo.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.view.Gravity;
import android.widget.Toast;
/**
 * author pangchao
 * created on 2017/5/20
 * email fat_chao@163.com.
 */
public class HintUtils {
    private static ProgressDialog progressDialog;

    //弹出正在加载的对话框
    public static void showDialog(Context context, String msg) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(context, "", msg, true,
                    false);
        }
    }

    //关闭dialog
    public static void closeDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    //弹出消息
    public static void showToast(final Context context, final String msg) {
        if (EmptyUtils.isEmpty(msg) || EmptyUtils.isNull(context)) {
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                Looper.loop();
            }
        }).start();
    }

}
