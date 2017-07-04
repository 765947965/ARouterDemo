package com.example.arouterdemo.common;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @author: xiewenliang
 * @Filename:
 * @Description: (本身不处理事件,如滑动事件,但是事件继续传递给子控件)
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2017/5/3 14:22
 */

public class HitRecyclerView extends RecyclerView {
    public HitRecyclerView(Context context) {
        super(context);
    }

    public HitRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HitRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
