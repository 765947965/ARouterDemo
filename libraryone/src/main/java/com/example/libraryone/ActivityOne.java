package com.example.libraryone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.basecommonlibrary.CommonStation;
import com.example.basecommonlibrary.RouterCommonUtil;

/**
 * @author: xiewenliang
 * @Filename:
 * @Description:
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2017/4/25 14:29
 */
@Route(path = "/libraryOne/主页", extras = CommonStation.CHECK_LOADING)
public class ActivityOne extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_one_activity_main);
        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.bt1) {
            RouterCommonUtil.startMainActivity(this);

        } else if (i == R.id.bt2) {
            RouterCommonUtil.startLibraryTwoActivity(this);
        }
    }
}
