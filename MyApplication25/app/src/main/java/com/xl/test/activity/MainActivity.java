package com.xl.test.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.xl.test.Base.BaseActivity;
import com.xl.test.R;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.convenientBanner)
    ConvenientBanner convenientBanner;
    private List<String> networkImages;
    private String[] images = {"http://img2.imgtn.bdimg.com/it/u=3093785514," +
            "1341050958&fm=21&gp=0.jpg",
//            "http://img2.3lian.com/2014/f2/37/d/40.jpg",
//            "http://d.3987.com/sqmy_131219/001.jpg",
//            "http://img2.3lian.com/2014/f2/37/d/39.jpg",
            "http://www.8kmm.com/UploadFiles/2012/8/201208140920132659.jpg",
            "http://f.hiphotos.baidu.com/image/h%3D200/sign=1478eb74d5a20cf45990f9df460b4b0c" +
                    "/d058ccbf6c81800a5422e5fdb43533fa838b4779.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/09fa513d269759ee50f1971ab6fb43166c22dfba" +
                    ".jpg"
    };


    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void loadData() {
        super.loadData();
        networkImages = Arrays.asList(images);
        convenientBanner.setPages(new CBViewHolderCreator<NetWorkImageHolder>() {
            @Override
            public NetWorkImageHolder createHolder() {
                return new NetWorkImageHolder();
            }
        }, networkImages).setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap
                .ic_page_indicator_focused})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setPointViewVisible(true);
        ;

    }

    class NetWorkImageHolder implements Holder<String> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);

            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            Glide.with(MainActivity.this).load(data).into(imageView);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        convenientBanner.startTurning(2000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        convenientBanner.stopTurning();
    }
}
