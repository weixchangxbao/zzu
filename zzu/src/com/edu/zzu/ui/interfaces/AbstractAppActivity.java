package com.edu.zzu.ui.interfaces;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewConfiguration;
import android.widget.Toast;
import com.edu.zzu.GlobalContext;
import com.edu.zzu.support.error.ZzuException;
import com.edu.zzu.support.setting.SettingUtility;

import java.lang.reflect.Field;

/**
 * User: Jiang Qi Date: 12-7-31
 */
public class AbstractAppActivity extends FragmentActivity {

	protected int theme = 0;

	@Override
	protected void onResume() {
		super.onResume();
		GlobalContext.getInstance().setCurrentRunningActivity(this);

		if (theme != SettingUtility.getAppTheme()) {
//			reload();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (GlobalContext.getInstance().getCurrentRunningActivity() == this) {
			GlobalContext.getInstance().setCurrentRunningActivity(null);
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("theme", theme);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		if (savedInstanceState == null) {
			theme = SettingUtility.getAppTheme();
		} else {
			theme = savedInstanceState.getInt("theme");
		}
		setTheme(theme);
		super.onCreate(savedInstanceState);
		forceShowActionBarOverflowMenu();
		GlobalContext.getInstance().setActivity(this);
	}

	private void forceShowActionBarOverflowMenu() {
		try {
			ViewConfiguration config = ViewConfiguration.get(this);
			Field menuKeyField = ViewConfiguration.class
					.getDeclaredField("sHasPermanentMenuKey");
			if (menuKeyField != null) {
				menuKeyField.setAccessible(true);
				menuKeyField.setBoolean(config, false);
			}
		} catch (Exception ignored) {

		}
	}


	protected void dealWithException(ZzuException e) {
		Toast.makeText(this, e.getError(), Toast.LENGTH_SHORT).show();
	}
}
