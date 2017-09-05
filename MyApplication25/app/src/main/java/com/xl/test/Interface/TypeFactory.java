package com.xl.test.Interface;

import android.view.View;

import com.xl.test.Base.BaseViewHolder;
import com.xl.test.Engin.Normal;
import com.xl.test.Engin.One;
import com.xl.test.Engin.Two;

/**
 * Created by hushendian on 2017/8/30.
 */

public interface TypeFactory {
    int type(One one);

    int type(Two two);

    int type(Normal normal);

    BaseViewHolder createViewHolder(int viewType, View view);
}
