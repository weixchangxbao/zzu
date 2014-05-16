/**
 *@Copyright:Copyright (c) 2012 - 2100
 */
package com.edu.zzu.ui.loader;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.AsyncTaskLoader;
import com.edu.zzu.support.error.ZzuException;


/**
 * @Title:
 * @Description:
 * @Author:weichangbao
 * @Since:2014-5-14
 * @Version:
 */
public abstract class AsyncNetRequestTaskLoader<T> extends
	AsyncTaskLoader<AsyncTaskLoaderResult<T>> {

	private AsyncTaskLoaderResult<T> result;
	private Bundle args;

	public AsyncNetRequestTaskLoader(Context context) {
		super(context);
	}

	@Override
	protected void onStartLoading() {
		super.onStartLoading();
		if (result == null) {
			forceLoad();
		} else {
			deliverResult(result);
		}
	}

	@Override
	public AsyncTaskLoaderResult<T> loadInBackground() {

		T data = null;
		ZzuException exception = null;

		try {
			data = loadData();
		} catch (ZzuException e) {
			exception = e;
		}

		result = new AsyncTaskLoaderResult<T>();
		result.data = data;
		result.exception = exception;
		result.args = this.args;

		return result;
	}

	protected abstract T loadData() throws ZzuException;

	public void setArgs(Bundle args) {
		if (result != null) {
			throw new IllegalArgumentException(
					"can't setArgs after loader executes");
		}
		this.args = args;
	}

}
