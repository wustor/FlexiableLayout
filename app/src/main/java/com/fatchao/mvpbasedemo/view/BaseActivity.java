package com.fatchao.mvpbasedemo.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.fatchao.mvpbasedemo.R;
import com.fatchao.mvpbasedemo.presenter.BasePresenter;
import com.fatchao.mvpbasedemo.presenter.ViewCallBack;

/**
 * author pangchao
 * created on 2017/5/20
 * email fat_chao@163.com.
 */
public abstract class BaseActivity<T extends BasePresenter, V> extends AppCompatActivity implements Toolbar.OnMenuItemClickListener, ViewCallBack<V>, View.OnClickListener {
    public T presenter;
    private Toolbar mToolbar;
    private TextView mTitle;
    protected Context mContext;
    protected FlexibleLayout mFlexibleLayout;

    @Override
    protected void onCreate(Bundle bundle) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(bundle);
        mContext = this;
        setContentView(initView());
        initToolbar();
        initViews();
        initListener();
        mFlexibleLayout.loadData();
    }

    private View initView() {
        mFlexibleLayout = new FlexibleLayout(mContext) {
            @Override
            public ViewGroup initNormalView() {
                return initViewGroup();
            }

            @Override
            public void onLoad() {
                if (presenter == null)
                    presenter = initPresenter();
                getData();
            }
        };
        return mFlexibleLayout;
    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.add((ViewCallBack) this);
    }

    public void showRightPage(int code) {
        switch (code) {
            case 0:
                mFlexibleLayout.showPageWithState(FlexibleLayout.State.Loading);
                break;
            case 1:
                mFlexibleLayout.showPageWithState(FlexibleLayout.State.Normal);
                break;
            case 2:
                mFlexibleLayout.showPageWithState(FlexibleLayout.State.Empty);
                break;
            case 3:
                mFlexibleLayout.showPageWithState(FlexibleLayout.State.NetWorkError);
                break;

        }
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) findViewById(R.id.tv_title);
        if (mToolbar != null) {
            mToolbar.setNavigationIcon(R.mipmap.arrow_back);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onLeftClick();
                }
            });
        }
    }

    protected void onLeftClick() {
        finish();
    }

    protected abstract int getLayoutId();//获取填充界面ID


    private ViewGroup initViewGroup() {
        ViewGroup view = (ViewGroup) View.inflate(mContext, getLayoutId(), null);
        return view;
    }

    protected abstract void initViews();

    protected abstract void initListener();//初始化监听事件

    protected abstract T initPresenter();//初始化Presenter
    protected abstract void getData();


    public void onRightText(MenuItem item) {

    }

    //设置标题
    protected void setTitle(String title) {
        mTitle.setText(title);
    }

    //设置右边菜单
    protected void setRight(int itemId) {
        mToolbar.getMenu().clear();
        if (itemId > 0) {
            mToolbar.inflateMenu(itemId);
            mToolbar.setOnMenuItemClickListener(this);
        }
    }

    //菜单的点击事件
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        onRightText(item);
        return true;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.remove();
    }


}
