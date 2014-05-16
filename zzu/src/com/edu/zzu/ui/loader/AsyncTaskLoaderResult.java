/**
 *@Copyright:Copyright (c) 2012 - 2100
 */
package com.edu.zzu.ui.loader;

import android.os.Bundle;
import com.edu.zzu.support.error.ZzuException;


/**
 * @Title:
 * @Description:
 * @Author:weichangbao
 * @Since:2014-5-14
 * @Version:
 */
public class AsyncTaskLoaderResult<E> {
    public E data;
    public ZzuException exception;
    public Bundle args;
}
