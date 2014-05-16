/**
 *@Copyright:Copyright (c) 2012 - 2100
 */
package com.edu.zzu;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.util.LruCache;

/**
 * @Title:
 * @Description:
 * @Author:weichangbao
 * @Since:2014-5-5
 * @Version:
 */
public class GlobalContext extends Application {
    // singleton
    private static GlobalContext globalContext = null;
    // image size
    private Activity activity = null;

    private Activity currentRunningActivity = null;

    private DisplayMetrics displayMetrics = null;

    
    // image memory cache
    private LruCache<String, Bitmap> appBitmapCache = null;

    public static GlobalContext getInstance() {
	return globalContext;
    }

    public Activity getActivity() {
	return activity;
    }

    public void setActivity(Activity activity) {
	this.activity = activity;
    }

    public Activity getCurrentRunningActivity() {
	return currentRunningActivity;
    }

    public void setCurrentRunningActivity(Activity currentRunningActivity) {
	this.currentRunningActivity = currentRunningActivity;
    }

}
