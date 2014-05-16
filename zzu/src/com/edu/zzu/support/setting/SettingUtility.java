/**
 *@Copyright:Copyright (c) 2012 - 2100
 */
package com.edu.zzu.support.setting;

import android.content.Context;
import com.edu.zzu.GlobalContext;
import com.edu.zzu.R;
import com.edu.zzu.ui.preference.SettingActivity;

/**
 * @Title:
 * @Description:
 * @Author:weichangbao
 * @Since:2014-5-5
 * @Version:
 */
public class SettingUtility {
    public static int getAppTheme() {
	String value = SettingHelper.getSharedPreferences(getContext(),
		SettingActivity.THEME, "1");

	switch (Integer.valueOf(value)) {
	case 1:
	    return R.style.AppTheme_Light;

	case 2:
	    return R.style.AppTheme_Dark;

	default:
	    return R.style.AppTheme_Light;

	}
    }
    private static Context getContext() {
	return GlobalContext.getInstance();
}

}
