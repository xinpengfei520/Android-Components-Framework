package com.xpf.module1.test2.view;

import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xpf.basemodule.base.MvpBaseActivity;
import com.xpf.module1.R;
import com.xpf.module1.test2.contract.Test2Contract;
import com.xpf.module1.test2.presenter.Test2Presenter;
import com.xpf.routermodule.cons.PathConstants;

/**
 * Created by x-sir on 2019/3/12 :)
 * Function:添加注解，path 必须为 /XX/OO 的形式
 * 为了规范期间，格式为 /ModuleName/ActivityName
 */
@Route(path = PathConstants.MODULE1_TEST2ACTIVITY)
public class Test2Activity extends MvpBaseActivity<Test2Contract.IView,
        Test2Presenter<Test2Contract.IView>> implements Test2Contract.IView {

    @Override
    protected Test2Presenter<Test2Contract.IView> createPresenter() {
        return new Test2Presenter<>();
    }

    @Override
    protected void bindView() {
        setContentView(R.layout.activity_module1_test2);
        String data = getIntent().getStringExtra("data");
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}
