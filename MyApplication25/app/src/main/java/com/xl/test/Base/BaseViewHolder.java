package com.xl.test.Base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import com.xl.test.Adapter.RecyleViewAdapter;

import hugo.weaving.DebugLog;

/**
 * Created by hushendian on 2017/8/30.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    private final SparseArray<View> views;
    private final View mItemView;

    @DebugLog
    protected BaseViewHolder(View itemView) {
        super(itemView);
        views = new SparseArray<>();
        this.mItemView = itemView;
    }

    @DebugLog
    protected View getView(int resId) {
        View view = views.get(resId);
        if (view == null) {
            view = mItemView.findViewById(resId);
            views.put(resId, view);
        }
        return view;
    }

    public abstract void setUpView(T model, int position, RecyleViewAdapter adapter);
}
