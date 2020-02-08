package com.users.xucanyou666.rxjava2_retrofit_mvp2.module.register;

import com.users.xucanyou666.rxjava2_retrofit_mvp2.base.BaseBean;
import com.users.xucanyou666.rxjava2_retrofit_mvp2.base.BaseView;
import com.users.xucanyou666.rxjava2_retrofit_mvp2.bean.User;

/**
 * Description : IRegisterView
 *
 * @author XuCanyou666
 * @date 2020/2/8
 */

public interface IRegisterView extends BaseView {

    /**
     * 显示注册成功
     *
     * @param successMessage
     */
    void showRegisterSuccess(String successMessage);

    /**
     * 显示注册失败
     *
     * @param errorMessage
     */
    void showRegisterFailed(String errorMessage);

    /**
     * 注册成功
     *
     * @param user
     */
    void doSuccess(BaseBean<User> user);

}
