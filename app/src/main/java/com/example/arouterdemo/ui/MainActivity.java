package com.example.arouterdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.arouterdemo.R;
import com.example.basecommonlibrary.RouterCommonUtil;

@Route(path = "/ui/主页")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);
        findViewById(R.id.bt4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                RouterCommonUtil.startMainTextActivity(this, "测试文本");
                break;
            case R.id.bt2:
                RouterCommonUtil.startMainImageActivity(this, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492584424522&di=5dcde77431914e0b944b8af9ff5f9277&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D1489971249%2C1618541505%26fm%3D214%26gp%3D0.jpg");
                break;
            case R.id.bt3:
                RouterCommonUtil.startLibraryOneActivity(this);
                break;
            case R.id.bt4:
                RouterCommonUtil.startLibraryTwoActivity(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1002) {
            Toast.makeText(this, data.getStringExtra("arg2"), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
    }
}
