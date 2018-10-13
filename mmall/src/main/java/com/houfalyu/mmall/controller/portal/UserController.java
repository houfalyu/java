package com.houfalyu.mmall.controller.portal;

import com.houfalyu.mmall.service.UserService;
import com.houfalyu.mmall.util.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by houfalv on 2018/10/9.
 * 前端 用户业务控制器
 */
@Api(description = "门户 用户接口")
@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 前台 用户登陆
     *
     * @param username 用户名
     * @param passwd   密码
     * @return
     */
    @ApiOperation(value = "前台 用户登陆")
    @PostMapping("/login.do")
    public ServerResponse login(@ApiParam("账号") @RequestParam String username,
                                @ApiParam("密码") @RequestParam String passwd, HttpSession httpSession) {
        return userService.login(username, passwd, httpSession);
    }

    /**
     * 前台 用户注册
     *
     * @param username 用户名
     * @param passwd   密码
     * @return
     */
    @ApiOperation(value = "前台 用户注册")
    @PostMapping("/register.do")
    public ServerResponse register(@ApiParam("账号") @RequestParam String username,
                                   @ApiParam("密码") @RequestParam String passwd,
                                   @ApiParam("邮箱") @RequestParam String email,
                                   @ApiParam("电话号码") @RequestParam String phone,
                                   @ApiParam("忘记密码问题") @RequestParam String question,
                                   @ApiParam("忘记密码答案") @RequestParam String answer) {
        return userService.register(username, passwd, email, phone, question, answer);
    }

    /**
     * 校验用户是否存在
     *
     * @param str
     * @param type
     */
    @ApiOperation(value = "前台 用户校验")
    @PostMapping("/check_valid.do")
    public ServerResponse checkValid(@ApiParam("待校验的值") @RequestParam String str,
                                     @ApiParam("值类型") @RequestParam String type) {
        return userService.checkValid(str, type);
    }

    /**
     * 获取登陆状态的用户信息
     *
     * @param httpSession
     * @return
     */
    @ApiOperation(value = "前台 获取登录用户信息")
    @PostMapping("/get_user_info.do")
    public ServerResponse getUserInfo(HttpSession httpSession) {
        return userService.getUserInfo(httpSession);
    }

    /**
     * 用户忘记密码
     *
     * @param username
     * @return
     */
    @ApiOperation(value = "前台 用户忘记密码")
    @PostMapping("/forget_get_question.do")
    public ServerResponse forgetGetQuestion(@ApiParam("用户名") @RequestParam String username) {
        return userService.forgetGetQuestion(username);
    }

    @PostMapping("/forget_check_answer.do")
    public void forgetCheckAnswer(@ApiParam("用户名") @RequestParam String username,
                                  @ApiParam("用户忘记密码问题") @RequestParam String question,
                                  @ApiParam("用户忘记密码答案") @RequestParam String answer){

    }
}
