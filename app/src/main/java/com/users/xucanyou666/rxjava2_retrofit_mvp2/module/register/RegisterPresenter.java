package com.users.xucanyou666.rxjava2_retrofit_mvp2.module.register;

import com.users.xucanyou666.rxjava2_retrofit_mvp2.base.BaseBean;
import com.users.xucanyou666.rxjava2_retrofit_mvp2.base.BaseObserver;
import com.users.xucanyou666.rxjava2_retrofit_mvp2.base.BasePresenter;
import com.users.xucanyou666.rxjava2_retrofit_mvp2.bean.User;

/**
 * Description : RegisterPresenter
 *
 * @author XuCanyou666
 * @date 2020/2/8
 */


class RegisterPresenter extends BasePresenter<IRegisterView> {

    RegisterPresenter(IRegisterView baseView) {
        super(baseView);
    }

    void submit(String username, String password, String repassword) {

        addDisposable(apiServer.register(username, password, repassword), new BaseObserver<BaseBean<User>>(baseView, true) {
            @Override
            public void onSuccess(BaseBean<User> bean) {
                baseView.showRegisterSuccess("注册成功（￣▽￣）");
                baseView.doSuccess(bean);
            }

            @Override
            public void onError(String msg) {
                baseView.showRegisterFailed(msg + "(°∀°)ﾉ");
            }
        });

    }
}
