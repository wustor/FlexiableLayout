package com.fatchao.mvpbasedemo.presenter;

/**
 * author pangchao
 * created on 2017/5/20
 * email fat_chao@163.com.
 */
public abstract class BasePresenter {

    protected ViewCallBack mViewCallBack;

    public void add(ViewCallBack viewCallBack) {
        this.mViewCallBack = viewCallBack;
    }

   public void remove() {
        this.mViewCallBack = null;
    }

    protected abstract void getData();
}
