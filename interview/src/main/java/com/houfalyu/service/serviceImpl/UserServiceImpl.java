package com.houfalyu.service.serviceImpl;

import com.houfalyu.entity.User;
import com.houfalyu.mapper.UserMapper;
import com.houfalyu.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by houfalv on 2018/10/13.
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String username, String password) {
        String md5Password = DigestUtils.md5Hex(password);
        User user = userMapper.loginByUsername(username);
        if (user == null) {
            return false;
        }

        return false;
    }
}
