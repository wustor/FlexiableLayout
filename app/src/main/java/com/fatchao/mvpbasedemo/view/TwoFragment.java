package com.fatchao.mvpbasedemo.view;


import android.view.View;

import com.fatchao.mvpbasedemo.R;
import com.fatchao.mvpbasedemo.model.MainBean;
import com.fatchao.mvpbasedemo.presenter.MainPresenter;

public class TwoFragment extends BaseFragment<MainPresenter, MainBean> {



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_two;
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
    protected void getData() {

    }
    @Override
    public void onClick(View v) {

    }

    @Override
    public void refreshView(int code, MainBean data) {

    }
}
