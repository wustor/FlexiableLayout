package com.fatchao.mvpbasedemo.view;


import android.view.View;

import com.fatchao.mvpbasedemo.R;
import com.fatchao.mvpbasedemo.model.MainBean;
import com.fatchao.mvpbasedemo.presenter.MainPresenter;


public class ThreeFragment extends BaseFragment<MainPresenter, MainBean> {



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_third;
    }

    @Override
    protected void initCustomView(View view) {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void refreshView(int code, MainBean data) {

    }

    @Override
    protected void getData() {
        showRightPage(2);
    }
}
