package com.xpf.android_components_framework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.xpf.routermodule.PathConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 520;
    private static final String DATA = "data";
    @BindView(R.id.btnModule1Page)
    Button btnModule1Page;
    @BindView(R.id.btnModule2Page)
    Button btnModule2Page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String key = bundle != null ? bundle.getString("key") : "";
            Toast.makeText(MainActivity.this, "回调的内容：" + key, Toast.LENGTH_LONG).show();
        }
    }

    @OnClick({R.id.btnModule1Page, R.id.btnModule2Page})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnModule1Page:
                jumpToActivity(PathConstants.MODULE1_MODULE1ACTIVITY);
                break;
            case R.id.btnModule2Page:
                jumpToActivity(PathConstants.MODULE2_MODULE2ACTIVITY);
                break;
            default:
                break;
        }
    }

    /**
     * 跳转到 module1 的 Module1Activity 页面
     *
     * @param path
     */
    public void jumpToActivity(String path) {
        // 1.方式一：一般启动方式
        ARouter.getInstance()
                // 内容就是想跳转去那个 module 注解的 path
                .build(path)
                // 传参，不用就不需写啦
                .withString(DATA, "app传过来的内容")
                .navigation();

        // 2.方式二：带回调的启动，会回调 onActivityResult()
//        ARouter.getInstance()
//                .build(path)
//                .withString(DATA, "app传过来的内容")
//                .navigation(MainActivity.this, REQUEST_CODE);

        // 3.方式三：上面的处理和下面的处理功能一样
//        Intent intent = new Intent(this, Module1Activity.class);
//        intent.putExtra(DATA, "app传过来的内容");
//        startActivityForResult(intent, REQUEST_CODE);
    }

}
