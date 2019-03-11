package com.xpf.module1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * 添加注解，path 必须为 /XX/OO 的形式
 * 为了规范期间，格式为 /ModuleName/ActivityName
 */
@Route(path = "/module1/Module1Activity")
public class Module1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1);

        String data = getIntent().getStringExtra("data");
        Toast.makeText(this, "传递的参数：" + data, Toast.LENGTH_LONG).show();
    }
}
