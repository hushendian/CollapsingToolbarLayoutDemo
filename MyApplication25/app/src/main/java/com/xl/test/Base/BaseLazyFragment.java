package com.xl.test.Base;

/**
 * Created by hushendian on 2017/9/3.
 */

public abstract class BaseLazyFragment extends BaseSuppportFragment {
    protected boolean isVisiable;


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisiable = true;
            onVisiable();
        } else {
            isVisiable = false;
            onInvisiable();
        }
    }


    protected void onVisiable() {
        getData();
        loadData();

    }

    protected abstract void onInvisiable();

    protected abstract void loadData(
    );

    protected abstract void getData();

}
