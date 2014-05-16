/**
 *@Copyright:Copyright (c) 2012 - 2100
 */
package com.edu.zzu.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.actionbarsherlock.view.MenuItem;
import com.edu.zzu.R;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;
import com.umeng.analytics.MobclickAgent;
import com.umeng.update.UmengUpdateAgent;


/**
 * @Title:
 * @Description:
 * @Author:weichangbao
 * @Since:2014-5-5
 * @Version:
 */
public class HomePatentActivity extends SlidingFragmentActivity {
    private HomePatentActivity mContext;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        UmengUpdateAgent.update(this);
        MobclickAgent.openActivityDurationTrack(false);// 使用umeng统计分析
        MobclickAgent.updateOnlineConfig(mContext);
        buildContentView(savedInstanceState);
    }

    /**
     * @Description:
     * @Author weichangbao
     * @Date 2014-5-6
     */
    private void buildContentView(Bundle savedInstanceState) {
        setBehindContentView(R.layout.menu_frame);

        buidActionBar();
        setContentView(R.layout.menu_right);
        getWindow().setBackgroundDrawable(null);
        initFragments();
        if (savedInstanceState == null) {

            FragmentTransaction secondFragmentTransaction = getSupportFragmentManager()
                    .beginTransaction();
            secondFragmentTransaction.replace(R.id.menu_frame_fl,
                    getMenuFragment(), LeftMenuFragment.class.getName());
            getSlidingMenu().showContent();
            secondFragmentTransaction.commit();
        }
        configSlidingMenu();
    }

    /**
     * @Description:
     * @Author weichangbao
     * @Date 2014-5-8
     */
    private void buidActionBar() {
        View title = getLayoutInflater().inflate(
                R.layout.homeactivity_title_layout, null);
        getSupportActionBar().setCustomView(title);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    /**
     * @Description:
     * @Author weichangbao
     * @Date 2014-5-6
     */
    private void initFragments() {
        Fragment mainUI = getHomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.replace(R.id.menu_frame_fl, mainUI,
                HomeFragment.class.getName());
    }

    /**
     * @Description:
     * @Author weichangbao
     * @Date 2014-5-6
     */
    private void configSlidingMenu() {
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        slidingMenu.setShadowDrawable(R.drawable.shadow_slidingmenu);
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        slidingMenu.setFadeDegree(0.35f);
    }

    public LeftMenuFragment getMenuFragment() {
        LeftMenuFragment fragment = ((LeftMenuFragment) getSupportFragmentManager()
                .findFragmentByTag(LeftMenuFragment.class.getName()));
        if (fragment == null) {
            fragment = LeftMenuFragment.newInstance();
        }
        return fragment;
    }

    public HomeFragment getHomeFragment() {
        HomeFragment fragment = ((HomeFragment) getSupportFragmentManager()
                .findFragmentByTag(HomeFragment.class.getName()));
        if (fragment == null) {
            fragment = HomeFragment.newInstance();
        }
        return fragment;
    }

    /**
     * @Description:
     * @Author weichangbao
     * @Date 2014-5-9
     */
    public static Intent newIntent() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getSlidingMenu().showMenu();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("MainScreen"); // 统计时长
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("MainScreen");
    }
}
