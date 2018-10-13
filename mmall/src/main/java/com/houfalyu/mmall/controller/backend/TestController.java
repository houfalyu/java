package com.houfalyu.mmall.controller.backend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by houfalv on 2018/10/9.
 */
@RestController
@CrossOrigin
public class TestController {

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }
}
