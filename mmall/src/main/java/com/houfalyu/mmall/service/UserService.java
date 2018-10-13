package com.houfalyu.mmall.service;

import com.houfalyu.mmall.util.ServerResponse;

import javax.servlet.http.HttpSession;

/**
 * Created by houfalv on 2018/10/9.
 */
public interface UserService {

    /**
     * 前台 用户登陆
     * @param username      用户名
     * @param passwd        密码
     * @return
     */
    ServerResponse login(String username, String passwd, HttpSession httpSession);

    /**
     * 前台 用户注册
     * @param username      用户名
     * @param passwd        密码
     * @param email
     * @param phone
     * @param question
     * @param answer
     * @return
     */
    ServerResponse register(String username, String passwd, String email, String phone, String question, String answer);

    /**
     * 检查用户是否存在
     * @param str           待判断的值
     * @param type          字段类型
     */
    ServerResponse checkValid(String str, String type);

    /**
     * 获取登陆状态下的账户信息
     *
     * @param httpSession
     * @return
     */
    ServerResponse getUserInfo(HttpSession httpSession);

    /**
     * 用户忘记密码
     * @param username
     * @return
     */
    ServerResponse forgetGetQuestion(String username);
}
