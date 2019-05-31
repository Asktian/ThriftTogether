package com.pro516.thrifttogether.ui.home.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.pro516.thrifttogether.R;
import com.pro516.thrifttogether.ui.home.entity.StoreProduct;

import java.util.List;

public class ShowStoreProductAdapter extends BaseQuickAdapter<StoreProduct,BaseViewHolder> {

    public ShowStoreProductAdapter(int layoutResId, @Nullable List<StoreProduct> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, StoreProduct item) {
        helper.setText(R.id.store_product_name, item.getName())
                .setText(R.id.store_product_price, item.getPrice())
                .setText(R.id.store_product_time, item.getTime());
        RequestOptions mRequestOptions = RequestOptions.circleCropTransform()
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存
        Log.i("Constraints", "init view");
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(30);
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);

        Glide.with(mContext).load(item.getImage()).apply(options).into((ImageView) helper.getView(R.id.store_product_image));
    }
}