package com.users.xucanyou666.rxjava2_retrofit_mvp2.module.login;


import android.text.Editable;

import com.google.android.material.textfield.TextInputLayout;

/**
 * TextInputLayout监听器
 * created by xucanyou666
 * on 2020/2/7 18:09
 * email：913710642@qq.com
 */
 public class LoginTextWatcher implements android.text.TextWatcher {
    private TextInputLayout mTilUsername;
    private TextInputLayout mTilPassword;

     LoginTextWatcher(TextInputLayout username, TextInputLayout password) {
        mTilUsername = username;
        mTilPassword = password;
    }



    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        checkInput(mTilUsername);
        checkInput(mTilPassword);
    }

    /**
     * 判断输入内容是否合法
     *
     * @param textInputLayout textInputLayout
     */
    public static void checkInput(TextInputLayout textInputLayout) {
        if (textInputLayout != null) {
            if (textInputLayout.getEditText().getText().length() > textInputLayout.getCounterMaxLength()) {
                textInputLayout.setError("输入内容超过上限");
            } else if (textInputLayout.getEditText().getText().length() < textInputLayout.getCounterMaxLength() / 2) {
                textInputLayout.setError("最少6位");
            } else {
                textInputLayout.setError(null);
            }
        }
    }

}
