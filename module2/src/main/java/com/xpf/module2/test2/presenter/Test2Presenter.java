package com.xpf.module2.test2.presenter;

import com.xpf.basemodule.base.MvpBasePresenter;
import com.xpf.module2.test2.contract.Test2Contract;
import com.xpf.module2.test2.model.Test2Model;

/**
 * Created by x-sir on 2019/3/12 :)
 * Function:
 */
public class Test2Presenter<T extends Test2Contract.IView>
        extends MvpBasePresenter<T> implements Test2Contract.IPresenter {

    private Test2Contract.IModel mModel = new Test2Model();


}
