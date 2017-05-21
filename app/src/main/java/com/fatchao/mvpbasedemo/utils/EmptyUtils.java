package com.fatchao.mvpbasedemo.utils;

import android.text.TextUtils;

/**
 * author pangchao
 * created on 2017/5/20
 * email fat_chao@163.com.
 */
public class EmptyUtils {
    public static boolean isEmpty(String target) {
        if (target != null && !TextUtils.isEmpty(target)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isNotEmpty(String target) {
        if (target != null && !TextUtils.isEmpty(target)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static String NullToEmpty(String obj) {
        if (isNull(obj))
            return "";
        else
            return obj;
    }


}
