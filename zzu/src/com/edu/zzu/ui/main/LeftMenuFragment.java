/**
 *@Copyright:Copyright (c) 2012 - 2100
 */
package com.edu.zzu.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import com.edu.zzu.R;
import com.edu.zzu.ui.interfaces.AbstractAppFragment;
import com.edu.zzu.ui.preference.SettingActivity;
import com.slidingmenu.lib.SlidingMenu;
import com.umeng.analytics.MobclickAgent;
import com.umeng.fb.FeedbackAgent;


/**
 * @Title:
 * @Description:
 * @Author:weichangbao
 * @Since:2014-5-5
 * @Version:
 */
public class LeftMenuFragment extends AbstractAppFragment
{

    private Layout layout;

    public static final int PROFILE_INDEX = 6;
    public static final int SETTING_INDEX = 5;

    public static LeftMenuFragment newInstance() {
	LeftMenuFragment fragment = new LeftMenuFragment();
	fragment.setArguments(new Bundle());
	return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
	super.onActivityCreated(savedInstanceState);
    }

    public void switchCategory(int position) {

	switch (position) {
	// case HOME_INDEX:
	// showHomePage(true);
	// break;
	// case MENTIONS_INDEX:
	// showMentionPage(true);
	// break;
	// case COMMENTS_INDEX:
	// showCommentPage(true);
	// break;
	// case SEARCH_INDEX:
	// showSearchPage(true);
	// break;
	// case DM_INDEX:
	// showDMPage(true);
	// break;
	// case FAV_INDEX:
	// showFavPage(true);
	// break;
	case PROFILE_INDEX:
	    break;
	}

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	    Bundle savedInstanceState) {
	final ScrollView view;
        view = (ScrollView) inflater.inflate(
            R.layout.slidingdrawer_contents, container, false);
        layout = new Layout();
	layout.setting = (Button) view.findViewById(R.id.btn_setting);
	layout.feedback = (Button) view.findViewById(R.id.btn_feedback);
	return view;
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.support.v4.app.Fragment#onViewCreated(android.view.View,
     * android.os.Bundle)
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
	super.onViewCreated(view, savedInstanceState);
	layout.setting.setOnClickListener(onClickListener);
	layout.feedback.setOnClickListener(onClickListener);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {

	@Override
	public void onClick(View v) {
	    switch (v.getId()) {

	    case R.id.btn_setting:
		showSettingPage();
		break;
	    case R.id.btn_feedback:
		showFeedbackPage();
	    default:
		break;
	    }
	}
    };

    /**
     * @Description:
     * @Author weichangbao
     * @Date 2014-5-6
     */
    protected void showSettingPage() {
	startActivity(new Intent(getActivity(), SettingActivity.class));
    }

    /**
     * @Description:
     * @Author weichangbao
     * @Date 2014-5-14
     */
    protected void showFeedbackPage() {
	// TODO Auto-generated method stub
	FeedbackAgent agent = new FeedbackAgent(getActivity());
	agent.startFeedbackActivity();
    }

    private SlidingMenu getSlidingMenu() {
	return ((HomePatentActivity) getActivity()).getSlidingMenu();
    }

    private void setTitle(int res) {
	((HomePatentActivity) getActivity()).setTitle(res);
    }

    private void setTitle(String title) {
	((HomePatentActivity) getActivity()).setTitle(title);
    }

    public void onResume() {
	super.onResume();
	MobclickAgent.onPageStart("MainScreen"); // 统计页面
    }

    public void onPause() {
	super.onPause();
	MobclickAgent.onPageEnd("MainScreen");
    }

    private class Layout {
	Button setting;
	Button feedback;
    }

}
