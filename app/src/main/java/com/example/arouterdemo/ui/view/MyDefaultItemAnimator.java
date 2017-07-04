package com.example.arouterdemo.ui.view;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * @author: xiewenliang
 * @Filename:
 * @Description:
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2017/5/2 9:55
 */

public class MyDefaultItemAnimator extends DefaultItemAnimator {

    @Override
    public boolean animateRemove(RecyclerView.ViewHolder holder) {
//        return super.animateRemove(holder);
        ViewPropertyAnimatorCompat animation = ViewCompat.animate(holder.itemView);
        animation.setDuration(500);
        animation.alphaBy(1);
        animation.alpha(0);
        animation.start();
//        animation.alpha()
        return true;
    }

    @Override
    public boolean animateAdd(RecyclerView.ViewHolder holder) {
//        return super.animateAdd(holder);
        ViewPropertyAnimatorCompat animation = ViewCompat.animate(holder.itemView);
        animation.setDuration(500);
        animation.alphaBy(0);
        animation.alpha(1);
        animation.start();
        return true;
    }
}
