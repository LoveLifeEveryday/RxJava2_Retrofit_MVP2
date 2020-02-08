package com.users.xucanyou666.rxjava2_retrofit_mvp2.base;

import java.io.Serializable;

/**
 * Description : BaseBean 实体类的基类
 *
 * @author XuCanyou666
 * @date 2020/2/7
 */


public class BaseBean<T> implements Serializable {


    /**
     * data :
     * errorCode : 0
     * errorMsg :
     */

    public int errorCode;
    public String errorMsg;
    public T data;

    public BaseBean(int code, String data) {
        this.errorCode = code;
        this.data = (T) data;
    }
}
