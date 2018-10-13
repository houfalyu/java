package com.houfalyu.mmall.util;

import javax.xml.ws.Response;
import java.io.Serializable;

/**
 * Created by houfalv on 2018/10/9.
 * 通用的服务端响应对象
 * 可向前端传递 state message data
 */
public class ServerResponse<T> implements Serializable {
    private Integer status;
    private String message;
    private T data;

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public ServerResponse(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ServerResponse(int status) {
        this(status, null, null);
    }

    public ServerResponse(int status, String message) {
        this(status, message, null);
    }

    public ServerResponse(int status, T data) {
        this(status, null, data);
    }


    /**
     * 向外界暴露是否相应成功
     *
     * @return
     */
    public boolean isSuccessful() {
        return this.status.equals(ResponseCode.SUCCESS.getCode());
    }

    /**
     * 相应成功返回
     */
    public static <T> ServerResponse<T> createResponseBySuccess() {
        return new ServerResponse(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createResponseBySuccess(T data) {
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse<T> createResponseBySuccessWithMessage(String message) {
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), message);
    }

    public static <T> ServerResponse<T> createResponseBySuccessWithMessageData(String message, T data) {
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 响应失败返回
     */

    public static <T> ServerResponse<T> createResponseByError() {
        return new ServerResponse(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createResponseByErrorWithMessage(String message) {
        return new ServerResponse(ResponseCode.ERROR.getCode(), message);
    }

    public static <T> ServerResponse<T> createResponseByErrorWithCodeMessage(String message, Integer code) {
        return new ServerResponse(code, message);
    }

}