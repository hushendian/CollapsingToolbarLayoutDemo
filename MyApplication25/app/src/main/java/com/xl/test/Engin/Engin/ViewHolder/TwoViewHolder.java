package com.xl.test.Engin.Engin.ViewHolder;

import android.view.View;
import android.widget.ImageView;

import com.xl.test.Adapter.RecyleViewAdapter;
import com.xl.test.Base.BaseViewHolder;
import com.xl.test.Engin.Two;
import com.xl.test.R;

/**
 * Created by hushendian on 2017/8/30.
 */

public class TwoViewHolder extends BaseViewHolder<Two> {
    public TwoViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(Two model, int position, RecyleViewAdapter adapter) {
        ImageView view = (ImageView) getView(R.id.studentPng);
        view.setImageResource(R.mipmap.ic_launcher_round);
    }
}
