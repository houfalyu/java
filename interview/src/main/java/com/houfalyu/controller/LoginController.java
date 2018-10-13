package com.houfalyu.controller;

import com.houfalyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by houfalv on 2018/10/13.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        ModelAndView modelAndView) {
        boolean loginResult = userService.login(username,password);

        if (loginResult) {
            modelAndView.addObject("message","登陆成功");
            return "class/manage";
        }

        modelAndView.addObject("message","账号或密码错误!");

        return "redirect:/login";
    }
}
