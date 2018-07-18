package com.example.dhht.permissionutil;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import permisson.FloatWindowManager;
import permisson.PermissonUtil;
import permisson.listener.PermissionListener;

public class MainActivity extends AppCompatActivity {

    TextView tv_hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_hello = findViewById(R.id.tv_hello);

        tv_hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FloatWindowManager.getInstance().applyOrShowFloatWindow(MainActivity.this);
                PermissonUtil.checkPermission(MainActivity.this, new PermissionListener() {
                    @Override
                    public void havePermission() {
                        Toast.makeText(MainActivity.this,"获取成功",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void requestPermissionFail() {
                        Toast.makeText(MainActivity.this,"获取失败",Toast.LENGTH_SHORT).show();
                    }
                }, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE});

            }
        });
    }
}