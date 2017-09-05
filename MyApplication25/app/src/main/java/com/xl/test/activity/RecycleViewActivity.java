package com.xl.test.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.xl.test.Base.BaseActivity;
import com.xl.test.R;

import butterknife.BindView;
import hugo.weaving.DebugLog;

public class RecycleViewActivity extends BaseActivity {
    @BindView(R.id.tabs)
    SmartTabLayout tabs;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;
    @BindView(R.id.toolbar1)
    Toolbar toolbar;
    @BindView(R.id.collaps)
    CollapsingToolbarLayout collaps;
    @BindView(R.id.playButton)
    LinearLayout fab2;

    private CollapsingToolbarLayoutState state;


    private enum CollapsingToolbarLayoutState {EXPANDED, COLLAPSED, INTERNEDIATE}


    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.coordinatorlayout);

    }

    @Override
    protected void initVariables() {
        initData();
    }

    @Override
    protected void loadData() {
        toolbar.inflateMenu(R.menu.menu_search);
        FragmentPagerItems pages = FragmentPagerItems.with(this)
                .add(R.string.recent, TopicFragment.class)
                .add(R.string.vote, TopicFragment.class)
                .add(R.string.jobs, TopicFragment.class)
                .create();
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager()
                , pages);
        viewpager.setOffscreenPageLimit(pages.size());
        viewpager.setAdapter(adapter);
        tabs.setViewPager(viewpager);
//        collaps.setCollapsedTitleGravity(Gravity.CENTER_HORIZONTAL);
        setListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @DebugLog
    private void initData() {


    }

    private void setListener() {
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    if (state != CollapsingToolbarLayoutState.EXPANDED) {
                        state = CollapsingToolbarLayoutState.EXPANDED;
                        collaps.setTitle(getString(R.string.app_name));
                    }
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {

                    if (state != CollapsingToolbarLayoutState.COLLAPSED) {
                        collaps.setTitle("");//设置title不显示
                        fab2.setVisibility(View.VISIBLE);//隐藏播放按钮
                        state = CollapsingToolbarLayoutState.COLLAPSED;//修改状态标记为折叠

                    }
                } else {

                    if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {

                        if (state == CollapsingToolbarLayoutState.COLLAPSED) {
                            fab2.setVisibility(View.GONE);//由折叠变为中间状态时隐藏播放按钮
                        }

                        collaps.setTitle(getString(R.string.app_name));//设置title为INTERNEDIATE
                        state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
                    }
                }


            }
        });
    }
}