package com.users.xucanyou666.rxjava2_retrofit_mvp2.http.gson;

import com.google.gson.TypeAdapter;
import com.users.xucanyou666.rxjava2_retrofit_mvp2.base.BaseException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @author yechao
 * @date 2019/11/18/018
 * Describe : 重写ResponseBodyConverter对json预处理
 */
public class BaseResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> adapter;

    /**
     * 登陆失效
     */
    private static final int LOG_OUT_TIME = -1001;

    BaseResponseBodyConverter(TypeAdapter<T> adapter) {
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String jsonString = value.string();
        try {
            JSONObject object = new JSONObject(jsonString);
            int code = object.getInt("errorCode");
            if (0 != code) {
                String data;
                //错误信息
                if (code == LOG_OUT_TIME) {
                    data = "登录失效，请重新登录";

                } else {
                    data = object.getString("errorMsg");
                }
                //异常处理
                throw new BaseException(code, data);
            }
            //正确返回整个json
            return adapter.fromJson(jsonString);

        } catch (JSONException e) {
            e.printStackTrace();
            //数据解析异常即json格式有变动
            throw new BaseException(BaseException.PARSE_ERROR_MSG);
        } finally {
            value.close();
        }
    }
}