package com.xpf.module2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * 添加注解，path必须为 /XX/OO 的形式
 * 为了规范期间，格式为 /ModuleName/ActivityName
 */
@Route(path = "/module2/Module2Activity")
public class Module2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2);

        String data = getIntent().getStringExtra("data");
        Toast.makeText(this, "传递的参数：" + data, Toast.LENGTH_LONG).show();
    }
}
