package com.xpf.mainmodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xpf.routermodule.cons.PathConstants;
import com.xpf.routermodule.util.RouterUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by x-sir on 2019/3/12 :)
 * Function:主页面
 */
@Route(path = PathConstants.MAIN_MODULE_MAINACTIVITY)
public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 520;
    private static final String DATA = "data";
    private static final String CONTENT = "我是MainModule传过来的数据。";

    @BindView(R2.id.btnModule1Page1)
    Button btnModule1Page1;
    @BindView(R2.id.btnModule1Page2)
    Button btnModule1Page2;
    @BindView(R2.id.btnModule2Page1)
    Button btnModule2Page1;
    @BindView(R2.id.btnModule2Page2)
    Button btnModule2Page2;

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
            Toast.makeText(MainActivity.this, "回调的内容：" + key, Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick({R2.id.btnModule1Page1, R2.id.btnModule1Page2, R2.id.btnModule2Page1, R2.id.btnModule2Page2})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.btnModule1Page1) {
            RouterUtils.jumpToActivity(PathConstants.MODULE1_TEST1ACTIVITY);
        } else if (id == R.id.btnModule1Page2) {
            RouterUtils.jumpToActivityWithParam(PathConstants.MODULE1_TEST2ACTIVITY, DATA, CONTENT);
        } else if (id == R.id.btnModule2Page1) {
            RouterUtils.jumpToActivityWithCallback(PathConstants.MODULE2_TEST1ACTIVITY, this, REQUEST_CODE);
        } else if (id == R.id.btnModule2Page2) {
            RouterUtils.jumpToActivityWithParamAndCallback(PathConstants.MODULE2_TEST2ACTIVITY, DATA, CONTENT, this, REQUEST_CODE);
        }
    }

}
