package com.xpf.module2.test1.presenter;

import com.xpf.basemodule.base.MvpBasePresenter;
import com.xpf.module2.test1.contract.Test1Contract;
import com.xpf.module2.test1.model.Test1Model;

/**
 * Created by x-sir on 2019/3/12 :)
 * Function:
 */
public class Test1Presenter<T extends Test1Contract.IView>
        extends MvpBasePresenter<T> implements Test1Contract.IPresenter {

    private Test1Contract.IModel mModel = new Test1Model();

}
