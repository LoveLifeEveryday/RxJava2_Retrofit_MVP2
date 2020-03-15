package com.users.xucanyou666.rxjava2_retrofit_mvp2.module.login;

import com.users.xucanyou666.rxjava2_retrofit_mvp2.base.BaseBean;
import com.users.xucanyou666.rxjava2_retrofit_mvp2.base.BaseView;
import com.users.xucanyou666.rxjava2_retrofit_mvp2.bean.User;
/**
 * Description : ILoginView
 *
 * @author XuCanyou666
 * @date 2020/2/8
 */

public interface ILoginView extends BaseView {

    /**
     * 显示登陆成功
     *
     * @param successMessage 成功信息
     */
    void showLoginSuccess(String successMessage);

    /**
     * 显示登陆失败
     *
     * @param errorMessage 失败信息
     */
    void showLoginFailed(String errorMessage);

    void doSuccess();

}
