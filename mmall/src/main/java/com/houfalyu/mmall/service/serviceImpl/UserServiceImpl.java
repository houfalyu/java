package com.houfalyu.mmall.service.serviceImpl;

import com.houfalyu.mmall.entity.MmallUser;
import com.houfalyu.mmall.mapper.MmallUserMapper;
import com.houfalyu.mmall.service.UserService;
import com.houfalyu.mmall.util.Const;
import com.houfalyu.mmall.util.ServerResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by houfalv on 2018/10/9.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MmallUserMapper userMapper;

    /**
     * 前台 用户登陆
     *
     * @param username 用户名
     * @param passwd   密码
     * @return
     */
    @Override
    public ServerResponse login(String username, String passwd, HttpSession httpSession) {
        String md5Passwd = DigestUtils.md5Hex(passwd);

        HashMap<String, String> parameterMap = new HashMap<>();
        parameterMap.put(Const.DB_TABLE_MMALL_USER_USERNAME, username);

        MmallUser user = userMapper.validateByCondition(parameterMap);

        if (user != null) {
            if (user.getPassword().toLowerCase().equals(md5Passwd)) {
                user.setPassword(null);
                user.setPhone(null);
                httpSession.setAttribute(Const.SESSION_CURRENT_USER, user);
                return ServerResponse.createResponseBySuccess(user);
            }
            return ServerResponse.createResponseByErrorWithMessage("账号或密码错误!");
        }
        return ServerResponse.createResponseByErrorWithMessage("账号或密码错误!");
    }

    /**
     * 前台 用户注册
     *
     * @param username 用户名
     * @param passwd   密码
     * @param email
     * @param phone
     * @param question
     * @param answer
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public ServerResponse register(String username, String passwd, String email, String phone, String question, String answer) {
        /*MmallUser user = userMapper.validateByCondition(new HashMap<String, String>() {
            {
                put(Const.DB_TABLE_MMALL_USER_USERNAME, username);
                put(Const.DB_TABLE_MMALL_USER_PHONE, phone);
            }
        });*/

        MmallUser mmallUser = userMapper.validateByUsername(username);
        MmallUser mmallUser1 = userMapper.validateByPhone(phone);

        if (mmallUser == null && mmallUser1 == null) {
            MmallUser registerUser = new MmallUser();
            registerUser.setUsername(username);
            registerUser.setPassword(DigestUtils.md5Hex(passwd));
            registerUser.setEmail(email);
            registerUser.setPhone(phone);
            registerUser.setQuestion(question);
            registerUser.setAnswer(answer);
            registerUser.setRole(1);
            registerUser.setCreateTime(new Date());
            registerUser.setUpdateTime(new Date());
            try {
                userMapper.insertSelective(registerUser);
                return ServerResponse.createResponseBySuccessWithMessage("注册成功!");
            } catch (Exception e) {
                e.printStackTrace();
                return ServerResponse.createResponseByErrorWithMessage("注册失败！");
            }

        }
        return ServerResponse.createResponseByErrorWithMessage("用户已存在，请更换后重试");
    }

    /**
     * 检查用户是否存在
     *
     * @param str  待判断的值
     * @param type 字段类型
     */
    @Override
    public ServerResponse checkValid(String str, String type) {
        MmallUser mmallUser = null;

        if (type.toLowerCase().equals(Const.DB_TABLE_MMALL_USER_USERNAME)) {
            mmallUser = userMapper.validateByUsername(str);
        }
        if (type.toLowerCase().equals(Const.DB_TABLE_MMALL_USER_PHONE)) {
            mmallUser = userMapper.validateByPhone(str);
        }

        if (mmallUser == null) {
            return ServerResponse.createResponseBySuccessWithMessage("校验成功！");
        }
        return ServerResponse.createResponseByErrorWithMessage("用户已经存在");
    }

    /**
     * 获取登陆状态下的账户信息
     *
     * @param httpSession
     * @return
     */
    @Override
    public ServerResponse getUserInfo(HttpSession httpSession) {
        MmallUser mmallUser = (MmallUser) httpSession.getAttribute(Const.SESSION_CURRENT_USER);
        if (mmallUser == null) {
            return ServerResponse.createResponseByErrorWithMessage("用户未登录，请登陆!");
        }
        mmallUser.setPhone(null);
        mmallUser.setPassword(null);
        return ServerResponse.createResponseBySuccess(mmallUser);
    }

    /**
     * 用户忘记密码
     *
     * @param username
     * @return
     */
    @Override
    public ServerResponse forgetGetQuestion(String username) {
        String question = userMapper.selectQuestionByUsername(username);
        if (StringUtils.isNotEmpty(question)) {
            return ServerResponse.createResponseBySuccessWithMessage(question);
        }
        return ServerResponse.createResponseByErrorWithMessage("该用户未设置找回密码问题");
    }


}
