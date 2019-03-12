package com.xpf.module1.test1.view;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xpf.basemodule.base.MvpBaseActivity;
import com.xpf.module1.R;
import com.xpf.module1.test1.contract.Test1Contract;
import com.xpf.module1.test1.presenter.Test1Presenter;
import com.xpf.routermodule.cons.PathConstants;

/**
 * Created by x-sir on 2019/3/12 :)
 * Function:
 */
@Route(path = PathConstants.MODULE1_TEST1ACTIVITY)
public class Test1Activity extends MvpBaseActivity<Test1Contract.IView,
        Test1Presenter<Test1Contract.IView>> implements Test1Contract.IView {

    @Override
    protected Test1Presenter<Test1Contract.IView> createPresenter() {
        return new Test1Presenter<>();
    }

    @Override
    protected void bindView() {
        setContentView(R.layout.activity_module1_test1);
    }
}
