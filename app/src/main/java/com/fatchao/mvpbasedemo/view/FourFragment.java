package com.fatchao.mvpbasedemo.view;


import android.view.View;

import com.fatchao.mvpbasedemo.R;
import com.fatchao.mvpbasedemo.model.MainBean;
import com.fatchao.mvpbasedemo.presenter.MainPresenter;

public class FourFragment extends BaseFragment<MainPresenter, MainBean> {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fourth;
    }

    @Override
    protected void initCustomView(View view) {
        setTitle("余华的标题栏");

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
        showRightPage(0);
        getActivity().getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                showRightPage(3);
            }
        }, 3000);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void refreshView(int code, MainBean data) {

    }
}
