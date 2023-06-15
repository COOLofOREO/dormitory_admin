package com.server.service;

import com.server.controller.vo.UserLogin;
import com.server.dto.UserAll;

public interface UserService {

    boolean addUser(UserAll userAll);

    /**
     * 用户注册
     * @param userAll
     * @return
     */
    boolean register(UserAll userAll);

    /**
     * 密码登录
     * @param userLogin
     * @param loginIp
     * @return
     */
    boolean loginByPwd(UserLogin userLogin,String loginIp);

    /**
     * 验证码登录
     * @param userLogin
     * @param loginIp
     * @return
     */
    boolean loginByVerification(UserLogin userLogin,String loginIp);
}
