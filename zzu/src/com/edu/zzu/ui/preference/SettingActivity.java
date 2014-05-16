/**
 *@Copyright:Copyright (c) 2012 - 2100
 */
package com.edu.zzu.ui.preference;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import com.edu.zzu.R;
import com.edu.zzu.ui.interfaces.AbstractAppActivity;
import com.edu.zzu.ui.main.HomePatentActivity;


/**
 * @Title:
 * @Description:
 * @Author:weichangbao
 * @Since:2014-5-5
 * @Version:
 */
public class SettingActivity extends AbstractAppActivity
{
    // appearance
    public static final String THEME = "theme";
    public static final String FONT_SIZE = "font_size";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        

	super.onCreate(savedInstanceState);
	getActionBar().setDisplayShowHomeEnabled(false);
	getActionBar().setDisplayShowTitleEnabled(true);
	getActionBar().setDisplayHomeAsUpEnabled(true);
	getActionBar().setTitle(getString(R.string.setting));

	if (savedInstanceState == null) {
		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new SettingsFragment())
				.commit();
	}
	
    }
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		switch (item.getItemId()) {
		case android.R.id.home:
			intent = HomePatentActivity.newIntent();
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			return true;
		}
		return false;
	}

	public static class SettingsFragment extends PreferenceFragment {
	    private Preference theme = null;
		private Preference listFontSize = null;
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.pref);
			listFontSize = findPreference(SettingActivity.FONT_SIZE);
			theme = findPreference(SettingActivity.THEME);
			buidSummary();
		}

		
		public void buidSummary() {

		  String value = PreferenceManager.getDefaultSharedPreferences(getActivity())
				.getString(SettingActivity.FONT_SIZE, "1");
		String[] values = getActivity().getResources().getStringArray(
				R.array.font_value);
		int index = -1;
		for (int i = 0; i < values.length; i++) {
			if (value.equals(values[i])) {
				index = i;
			}
		}

		if (index >= 0) {
			listFontSize.setSummary(getActivity().getResources()
					.getStringArray(R.array.font)[index]);
		}

		value = PreferenceManager.getDefaultSharedPreferences(getActivity())
				.getString(SettingActivity.THEME, "2");
		index = Integer.valueOf(value);
		if (index > 2) {
			index = 1;
		}
		theme.setSummary(getActivity().getResources().getStringArray(
				R.array.theme)[index - 1]);
		    
		}
	}

   
}
