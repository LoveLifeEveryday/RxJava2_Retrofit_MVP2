package com.users.xucanyou666.rxjava2_retrofit_mvp2.module.login;

import android.text.TextUtils;

import com.users.xucanyou666.rxjava2_retrofit_mvp2.base.BaseBean;
import com.users.xucanyou666.rxjava2_retrofit_mvp2.base.BaseObserver;
import com.users.xucanyou666.rxjava2_retrofit_mvp2.base.BasePresenter;
import com.users.xucanyou666.rxjava2_retrofit_mvp2.bean.User;
import com.users.xucanyou666.rxjava2_retrofit_mvp2.common.GlobalConstant;
import com.yechaoa.yutils.SpUtil;
import com.yechaoa.yutils.YUtils;

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


    /**
     * 登陆
     *
     * @param username         username
     * @param password         password
     * @param usernameCountMax 账号规定输入字符最大值
     * @param passwordCountMax 密码规定输入字符最大值
     */
    void login(String username, String password, int usernameCountMax, int passwordCountMax) {
        YUtils.closeSoftKeyboard();
        //判断输入的账号密码是否符合规范
        if (isValid(username, password, usernameCountMax, passwordCountMax)) {
            addDisposable(apiServer.login(username, password), new BaseObserver<BaseBean<User>>(baseView, true) {
                @Override
                public void onSuccess(BaseBean<User> bean) {
                    baseView.showLoginSuccess("登录成功（￣▽￣）");
                    //将登陆的账号存进sp里面
                    SpUtil.setBoolean(GlobalConstant.IS_LOGIN, true);
                    SpUtil.setString(GlobalConstant.USERNAME, bean.data.username);
                    SpUtil.setString(GlobalConstant.PASSWORD, bean.data.password);
                    baseView.doSuccess();
                }

                @Override
                public void onError(String msg) {
                    baseView.showLoginFailed(msg + "(°∀°)ﾉ");
                }
            });
        } else {
            baseView.showLoginFailed("填写错误 (°∀°)ﾉ");
        }

    }


    /**
     * 判断输入的账号密码是否符合规范
     *
     * @param userName         username
     * @param password         password
     * @param usernameCountMax 账号规定输入字符最大值
     * @param passwordCountMax 密码规定输入字符最大值
     * @return 是否合规
     */
    private boolean isValid(String userName, String password, int usernameCountMax, int passwordCountMax) {
        return check(userName, usernameCountMax) && check(password, passwordCountMax);
    }

    /**
     * 判断输入是否规范
     *
     * @param string              输入的内容
     * @param tilCounterMaxLength textInputLayout控件的输入字符的最大长度
     * @return 是否合规
     */
    private boolean check(String string, int tilCounterMaxLength) {
        return !TextUtils.isEmpty(string) && string.length() <= tilCounterMaxLength && tilCounterMaxLength / 2 <= string.length();
    }
}
