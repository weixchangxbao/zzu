/**
 *@Copyright:Copyright (c) 2012 - 2100
 */
package com.edu.zzu.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.edu.zzu.R;
import com.edu.zzu.ui.interfaces.AbstractAppFragment;
import com.umeng.analytics.MobclickAgent;


/**
 * @Title:
 * @Description:
 * @Author:weichangbao
 * @Since:2014-5-8
 * @Version:
 */
public class HomeFragment extends AbstractAppFragment
{

    /**
     * @Description:
     * @Author weichangbao
     * @Date 2014-5-8
     */
    public static HomeFragment newInstance() {
	HomeFragment fragment = new HomeFragment();
	fragment.setArguments(new Bundle());
	return fragment;
    }

    public HomeFragment() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onActivityCreated(savedInstanceState);
	setRetainInstance(true);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
     * android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	    Bundle savedInstanceState) {
	View view = inflater.inflate(R.layout.layout_homefragment, container,
		false);
	return view;

    }

    public void onResume() {
	super.onResume();
	MobclickAgent.onPageStart("MainScreen"); // 统计页面
    }

    public void onPause() {
	super.onPause();
	MobclickAgent.onPageEnd("MainScreen");
    }
}
