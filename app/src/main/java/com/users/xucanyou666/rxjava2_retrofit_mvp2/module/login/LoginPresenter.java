package com.users.xucanyou666.rxjava2_retrofit_mvp2.module.login;

import com.users.xucanyou666.rxjava2_retrofit_mvp2.base.BaseBean;
import com.users.xucanyou666.rxjava2_retrofit_mvp2.base.BaseObserver;
import com.users.xucanyou666.rxjava2_retrofit_mvp2.base.BasePresenter;
import com.users.xucanyou666.rxjava2_retrofit_mvp2.bean.User;
/**
 * Description : LoginPresenter
 *
 * @author XuCanyou666
 * @date 2020/2/8
 */


class LoginPresenter extends BasePresenter<ILoginView> {

    LoginPresenter(ILoginView baseView) {
        super(baseView);
    }

    void login(String username, String password) {
        addDisposable(apiServer.login(username, password), new BaseObserver<BaseBean<User>>(baseView, true) {
            @Override
            public void onSuccess(BaseBean<User> bean) {
                baseView.showLoginSuccess("登录成功（￣▽￣）");
                baseView.doSuccess(bean);
            }

            @Override
            public void onError(String msg) {
                baseView.showLoginFailed(msg + "(°∀°)ﾉ");
            }
        });
    }
}
