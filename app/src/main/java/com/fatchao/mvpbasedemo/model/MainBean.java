package com.fatchao.mvpbasedemo.model;

import java.io.Serializable;

/**
 * author pangchao
 * created on 2017/5/20
 * email fat_chao@163.com.
 */

public class MainBean implements Serializable {


    public String getString() {
        return mString;
    }

    public void setString(String string) {
        mString = string;
    }

    private String mString;
}
