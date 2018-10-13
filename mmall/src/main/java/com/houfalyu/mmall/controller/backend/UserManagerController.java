package com.houfalyu.mmall.controller.backend;

import org.springframework.web.bind.annotation.*;

/**
 * Created by houfalv on 2018/10/9.
 */
@RestController
@CrossOrigin
public class UserManagerController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


}

