package com.houfalyu.mmall.util;

/**
 * Created by houfalv on 2018/10/8.
 * 向前端传递的响应码
 */
public enum ResponseCode {
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEDD_LOGIN(10,"NEDD_LOGIN"),
    ILLEGAL_ARGUEMENT(2,"ILLEGAL_ARGUEMENT");

    private final Integer code;
    private final String desc;

    ResponseCode(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
