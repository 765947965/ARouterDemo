package com.example.arouterdemo.ui.text;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.arouterdemo.R;
import com.example.arouterdemo.common.MyRecyclerViewHolder;
import com.example.basecommonlibrary.router.IInterceptor.LoadingIservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author: xiewenliang
 * @Filename:
 * @Description:
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2017/4/19 10:47
 */
@Route(path = "/ui/text", group = "文本")
public class TextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        String str = getIntent().getStringExtra("arg1");
        if (!TextUtils.isEmpty(str)) {
            ((TextView) findViewById(R.id.textView)).setText(str);
        }
        List<String> list = new ArrayList<>();
        list.set(0, "aaaaaaaaaaaaa");
        final RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        final RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        RecyclerView recyclerView3 = (RecyclerView) findViewById(R.id.recyclerView3);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));

        recyclerView1.setAdapter(new RAdapter(this, getData(1)));
        recyclerView2.setAdapter(new RAdapter(this, getData(1)));
        recyclerView1.getItemAnimator().setAddDuration(15000);
        recyclerView3.setAdapter(new RAdapter(this, getData(30)));
//        recyclerView1.setItemAnimator(new MyDefaultItemAnimator());
//        recyclerView1.getItemAnimator().setAddDuration(1550);
        recyclerView1.postDelayed(new Runnable() {
            @Override
            public void run() {
                ((RAdapter) recyclerView1.getAdapter()).addItemConte("123343543543543", 1);
//                ((RAdapter)recyclerView1.getAdapter()).addItemConte("fadfsfdgdgdfdf",2);
////                recyclerView1.setAdapter(new RAdapter(TextActivity.this, getData(3)));
                ValueAnimator animator = new ValueAnimator().ofInt(0, getResources().getDimensionPixelOffset(R.dimen.dp_50));
                animator.setDuration(5000);
                animator.setStartDelay(50);
//                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int max = (int) animation.getAnimatedValue();
                        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) recyclerView2.getLayoutParams();
                        lp.setMargins(0, TextActivity.this.getResources().getDimensionPixelOffset(R.dimen.dp_50) + max, 0, 0);
                        recyclerView2.requestLayout();
                    }
                });
                animator.start();
            }
        }, 2000);
        recyclerView2.postDelayed(new Runnable() {
            @Override
            public void run() {
                ((RAdapter) recyclerView1.getAdapter()).notifyItemRemoved(1);
                ValueAnimator animator = new ValueAnimator().ofInt(0, getResources().getDimensionPixelOffset(R.dimen.dp_50));
                animator.setDuration(5000);
                animator.setStartDelay(50);
//                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int max = (int) animation.getAnimatedValue();
                        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) recyclerView2.getLayoutParams();
                        lp.setMargins(0, TextActivity.this.getResources().getDimensionPixelOffset(R.dimen.dp_100) - max, 0, 0);
                        recyclerView2.requestLayout();
                    }
                });
                animator.start();
            }
        }, 9000);
//        recyclerView1.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                ValueAnimator animator = new ValueAnimator().ofInt(600, 400);
//                animator.setDuration(250);
////                animator.setInterpolator(new AccelerateDecelerateInterpolator());
//                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        int max = (int) animation.getAnimatedValue();
//                        recyclerView1.getLayoutParams().height = max;
//                        recyclerView1.requestLayout();
//                    }
//
//                });
//                animator.start();
//            }
//        }, 7000);
//        recyclerView1.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                ((RAdapter)recyclerView1.getAdapter()).notifyItemRemoved(1);
////                recyclerView1.setAdapter(new RAdapter(TextActivity.this, getData(2)));
//            }
//        }, 7250);
        ((LoadingIservice) ARouter.getInstance().build("/service/1").navigation()).saveUserName("张三");
    }

    public static class RAdapter extends RecyclerView.Adapter {
        private Context context;
        private List<String> data;

        public RAdapter(Context context, List<String> data) {
            this.context = context;
            this.data = data;
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView textView = new TextView(context);
            textView.setTextSize(30);
            textView.setTextColor(Color.BLACK);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, context.getResources().getDimensionPixelOffset(R.dimen.dp_50));
            textView.setLayoutParams(lp);
            return new MyRecyclerViewHolder(textView);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((TextView) holder.itemView).setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public void addItemConte(String value, int position) {
            data.add(position, value);
            notifyItemInserted(position);
        }
    }

    private List<String> getData(int items) {
        Random random = new Random();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < items; i++) {
            list.add(String.valueOf(random.nextLong()));
        }
        return list;
    }


    @Override
    public void finish() {
        setResult(1002, getIntent().putExtra("arg2", new Date().toString()));
        super.finish();
    }
}
