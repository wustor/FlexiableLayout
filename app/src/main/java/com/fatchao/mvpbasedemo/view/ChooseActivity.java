package com.fatchao.mvpbasedemo.view;

import android.content.Intent;
import android.view.View;

import com.fatchao.mvpbasedemo.R;
import com.fatchao.mvpbasedemo.model.MainBean;
import com.fatchao.mvpbasedemo.presenter.MainPresenter;

public class ChooseActivity extends BaseActivity<MainPresenter, MainBean> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_choose;
    }

    @Override
    protected void initViews() {
        setTitle("状态选择");
    }

    @Override
    protected void initListener() {
        findViewById(R.id.btn_loading).setOnClickListener(this);
        findViewById(R.id.btn_normal).setOnClickListener(this);
        findViewById(R.id.btn_empty).setOnClickListener(this);
        findViewById(R.id.btn_error).setOnClickListener(this);

    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void getData() {
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                showRightPage(1);
            }
        }, 3000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_loading:
                startActivity(new Intent(mContext, MainActivity.class).putExtra("type", 0));
                break;
            case R.id.btn_normal:
                startActivity(new Intent(mContext, MainActivity.class).putExtra("type", 1));
                break;
            case R.id.btn_empty:
                startActivity(new Intent(mContext, MainActivity.class).putExtra("type", 2));
                break;
            case R.id.btn_error:
                startActivity(new Intent(mContext, MainActivity.class).putExtra("type", 3));
                break;
        }
    }

    @Override
    public void refreshView(int code, MainBean data) {

    }
}
