package com.xl.test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xl.test.Adapter.RecyleViewAdapter;
import com.xl.test.Base.BaseLazyFragment;
import com.xl.test.Engin.Normal;
import com.xl.test.Engin.One;
import com.xl.test.Engin.Two;
import com.xl.test.Interface.Visitable;
import com.xl.test.Listener.OnRecyclerItemClickListener;
import com.xl.test.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by hushendian on 2017/9/3.
 */

public class TopicFragment extends BaseLazyFragment {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    private boolean isPreapered;
    private List<Visitable> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.topic_layout, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isPreapered = true;
        loadData();//解决viewpager不滑动不显示数据问题
    }

    @Override
    protected void onInvisiable() {

    }

    @Override
    protected String getTitle() {
        return getString(R.string.recent);
    }

    @Override
    protected void loadData() {
        if (!isPreapered || !isVisiable) {
            return;
        }
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recycleView.setAdapter(new RecyleViewAdapter(list));
        recycleView.addOnItemTouchListener(new OnRecyclerItemClickListener(recycleView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder v) {
                Toast.makeText(getActivity(), "点击了" + v.getLayoutPosition(), Toast
                        .LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(RecyclerView.ViewHolder v) {
                Toast.makeText(getActivity(), "长按了" + v.getLayoutPosition(), Toast
                        .LENGTH_SHORT).show();
            }


        });
    }

    @Override
    protected void getData() {
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Log.d("initData", "initData: " + i % 3);
            if (i % 3 == 2) {
                list.add(i, new One("Type One 0"));
            } else if (i % 3 == 1) {
                list.add(i, new Two(R.mipmap.ic_launcher_round));
            } else if (i % 3 == 0) {
                list.add(i, new Normal("Type Three 0"));
            }
        }

    }


}
