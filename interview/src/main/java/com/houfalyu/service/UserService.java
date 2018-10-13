package com.houfalyu.service;

import org.springframework.stereotype.Service;

/**
 * Created by houfalv on 2018/10/13.
 */
public interface UserService {

    boolean login(String username, String password);
}
