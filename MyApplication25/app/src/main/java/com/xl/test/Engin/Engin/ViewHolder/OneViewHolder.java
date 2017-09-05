package com.xl.test.Engin.Engin.ViewHolder;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xl.test.Adapter.RecyleViewAdapter;
import com.xl.test.Base.BaseViewHolder;
import com.xl.test.Engin.One;
import com.xl.test.R;

/**
 * Created by hushendian on 2017/8/30.
 */

public class OneViewHolder extends BaseViewHolder<One> {
    public OneViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(One model, int position, RecyleViewAdapter adapter) {
        Log.d("OneViewHolder", "setUpView: "+model);
        TextView name= (TextView) getView(R.id.studentName);
        Log.d("OneViewHolder", "setUpView: "+name);
        name.setText(model.getText());
    }
}
