package com.pro516.thrifttogether.ui.home;

import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.pro516.thrifttogether.R;
import com.pro516.thrifttogether.entity.home.BannerInfo;
import com.pro516.thrifttogether.ui.base.BaseFragment;
import com.pro516.thrifttogether.ui.home.activity.HomeCityPickerActivity;
import com.stx.xhb.xbanner.XBanner;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;
import com.yzq.zxinglibrary.android.CaptureActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by hncboy on 2019-03-19.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init(View view) {
        AppCompatImageButton mScanQrcodeBtn = view.findViewById(R.id.scan_qrcode_btn);
        LinearLayout cityPickerLLayout = view.findViewById(R.id.city_picker_layout);
        LinearLayout homeSearchLLayout = view.findViewById(R.id.home_search_layout);
        mScanQrcodeBtn.setOnClickListener(this);
        cityPickerLLayout.setOnClickListener(this);
        homeSearchLLayout.setOnClickListener(this);
        initBanner(view);
    }

    private void initBanner(View view) {
        List<BannerInfo> bannerInfos = new ArrayList<>();
        String[] imageUrls = getResources().getStringArray(R.array.bannerImageUrls);
        for (String imageUrl : imageUrls) {
            BannerInfo bannerInfo = new BannerInfo();
            bannerInfo.setImageUrl(imageUrl);
            bannerInfos.add(bannerInfo);
        }

        XBanner mXBanner = view.findViewById(R.id.xbanner);
        mXBanner.setBannerData(bannerInfos);
        mXBanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                toast("点击了第" + position + "图片");
            }
        });
        //加载广告图片
        mXBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getContext()).load(((BannerInfo)
                        model).getXBannerUrl()).into((ImageView) view);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scan_qrcode_btn:
                AndPermission.with(this)
                        .runtime()
                        .permission(Permission.Group.STORAGE, Permission.Group.CAMERA)
                        .onGranted(permissions -> {
                            startActivity(CaptureActivity.class, false);
                        })
                        .onDenied(permissions -> {
                            toast("请开启权限");
                        })
                        .start();
                break;
            case R.id.city_picker_layout:
                startActivity(HomeCityPickerActivity.class);
                break;
            case R.id.home_search_layout:
                break;
            default:
                break;
        }
    }
}