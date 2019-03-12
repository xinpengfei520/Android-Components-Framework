package com.xpf.module2.test1.view;

import android.content.Intent;
import android.view.KeyEvent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xpf.basemodule.base.MvpBaseActivity;
import com.xpf.module2.R;
import com.xpf.module2.test1.contract.Test1Contract;
import com.xpf.module2.test1.presenter.Test1Presenter;
import com.xpf.routermodule.cons.PathConstants;

/**
 * 添加注解，path必须为 /XX/OO 的形式
 * 为了规范期间，格式为 /ModuleName/ActivityName
 */
@Route(path = PathConstants.MODULE2_TEST1ACTIVITY)
public class Test1Activity extends MvpBaseActivity<Test1Contract.IView,
        Test1Presenter<Test1Contract.IView>> implements Test1Contract.IView {

    @Override
    protected Test1Presenter<Test1Contract.IView> createPresenter() {
        return new Test1Presenter<>();
    }

    @Override
    protected void bindView() {
        setContentView(R.layout.activity_module2_test1);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent intent = new Intent();
        intent.putExtra("key", "我是module2的 Test1Activity 传过来的数据");
        setResult(RESULT_OK, intent);
        finish();
        return true;
    }
}
