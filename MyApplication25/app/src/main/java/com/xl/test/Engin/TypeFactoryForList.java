package com.xl.test.Engin;

import android.view.View;

import com.xl.test.Base.BaseViewHolder;
import com.xl.test.Engin.Engin.ViewHolder.NormalViewHolder;
import com.xl.test.Engin.Engin.ViewHolder.OneViewHolder;
import com.xl.test.Engin.Engin.ViewHolder.TwoViewHolder;
import com.xl.test.Interface.TypeFactory;
import com.xl.test.R;

import hugo.weaving.DebugLog;

/**
 * Created by hushendian on 2017/8/30.
 */

public class TypeFactoryForList implements TypeFactory {
    private final int TYPE_RESOURCE_ONE = R.layout.item_recycle_one;
    private final int TYPE_RESOURCE_TWO = R.layout.item_recycle_two;
    private final int TYPE_RESOURCE_NORMAL = R.layout.item_recycle_normal;

    @Override
    public int type(One one) {
        return TYPE_RESOURCE_ONE;
    }

    @Override
    public int type(Two two) {
        return TYPE_RESOURCE_TWO;
    }

    @Override
    public int type(Normal normal) {
        return TYPE_RESOURCE_NORMAL;
    }

    @DebugLog
    @Override
    public BaseViewHolder createViewHolder(int viewType, View view) {

        if (TYPE_RESOURCE_ONE == viewType) {
            return new OneViewHolder(view);
        } else if (TYPE_RESOURCE_TWO == viewType) {
            return new TwoViewHolder(view);
        } else if (TYPE_RESOURCE_NORMAL == viewType) {
            return new NormalViewHolder(view);
        }
        return null;
    }


}
