package com.example.basecommonlibrary.router.IInterceptor;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author: xiewenliang
 * @Filename:
 * @Description:
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2017/6/7 17:56
 */
@Route(path = "/service/1", name = "测试服务")
public class LoadingIservice implements IProvider {
    private Context mContext;

    @Override
    public void init(Context context) {
        this.mContext = context;
    }

    public void saveUserName(String name) {
        Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
    }
}
