package com.fatchao.mvpbasedemo.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.fatchao.mvpbasedemo.R;
import com.fatchao.mvpbasedemo.model.MainBean;
import com.fatchao.mvpbasedemo.presenter.MainPresenter;

/**
 * author pangchao
 * created on 2017/5/20
 * email fat_chao@163.com.
 */
public class MainActivity extends BaseActivity<MainPresenter, MainBean> {
    private TabLayout tbDemo;
    private ViewPager vpDemo;
    private int mType;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        setTitle("主页面");
        tbDemo = (TabLayout) findViewById(R.id.tb_demo);
        vpDemo = (ViewPager) findViewById(R.id.vp_demo);
    }

    @Override
    protected void initListener() {
        vpDemo.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            private String[] mTitles = getResources().getStringArray(R.array.name);

            @Override
            public Fragment getItem(int position) {
                if (position == 1) {
                    return new TwoFragment();
                } else if (position == 2) {
                    return new ThreeFragment();
                } else if (position == 3) {
                    return new FourFragment();
                }
                return new OneFragment();
            }

            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }

        });

        tbDemo.setupWithViewPager(vpDemo);
    }

    @Override
    protected MainPresenter initPresenter() {
        mType = getIntent().getIntExtra("type", 0);
        switch (mType) {
            case 0:
                setTitle("正在加载");
                break;
            case 1:
                setTitle("加载成功");
                break;
            case 2:
                setTitle("数据为空");
                break;
            case 3:
                setTitle("加载失败");
                break;
        }
        return new MainPresenter();
    }

    @Override
    protected void getData() {
        showRightPage(0);
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                showRightPage(mType);
            }
        }, 3000);
    }


    @Override
    public void refreshView(int code, MainBean data) {

    }


    @Override
    public void onClick(View v) {

    }

}
