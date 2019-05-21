package com.pro516.thrifttogether.ui.mine.reservation;

import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.pro516.thrifttogether.R;
import com.pro516.thrifttogether.entity.mine.ReservationBean;
import com.pro516.thrifttogether.ui.base.BaseActivity;
import com.pro516.thrifttogether.ui.mine.adapter.ReservationAdapter;
import com.pro516.thrifttogether.ui.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MineReservationActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener, View.OnClickListener {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_mine_reservation;
    }

    @Override
    protected void init() {
        AppCompatImageButton backBtn = findViewById(R.id.common_toolbar_function_left);
        backBtn.setVisibility(View.VISIBLE);
        backBtn.setImageDrawable(getDrawable(R.drawable.ic_arrow_back_24dp));
        backBtn.setOnClickListener(this);
        AppCompatTextView title = findViewById(R.id.title);
        title.setText("我的预订");
        initData();
        initRecyclerView();
    }
    List<ReservationBean> mData;
    private void initRecyclerView() {
        RecyclerView mRecyclerView = findViewById(R.id.mine_reservation);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(MineReservationActivity.this, DividerItemDecoration.VERTICAL_LIST));
        ReservationAdapter mAdapter = new ReservationAdapter(R.layout.item_mine_reservation, mData);
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN); // 加载动画类型
        mAdapter.isFirstOnly(false);   // 是否第一次才加载动画
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(MineReservationActivity.this, "点击：" + position, Toast.LENGTH_SHORT).show();
                //startActivity(OrderDetailsActivity.class);
            }
        });
    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mData.add(new ReservationBean(
                    "https://img.meituan.net/msmerchant/054b5de0ba0b50c18a620cc37482129a45739.jpg@380w_214h_1e_1c",
                    "海底捞",
                    "宁波亚细亚店",
                    new Date(),
                    2
            ));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_toolbar_function_left:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void onLoadMoreRequested() {

    }
}
