package com.xl.test.Engin.Engin.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.xl.test.Adapter.RecyleViewAdapter;
import com.xl.test.Base.BaseViewHolder;
import com.xl.test.Engin.Normal;
import com.xl.test.R;

/**
 * Created by hushendian on 2017/8/30.
 */

public class NormalViewHolder extends BaseViewHolder<Normal> {
    public NormalViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(Normal model, int position, RecyleViewAdapter adapter) {
        TextView name = (TextView) getView(R.id.sex);
        name.setText(model.getText());
    }
}
