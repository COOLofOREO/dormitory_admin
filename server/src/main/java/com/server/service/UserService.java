package com.server.service;

import com.server.controller.vo.UserLogin;
import com.server.dto.UserAll;
import com.server.mapper.po.UserInfo;

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

    /**
     * 注销用户
     * @param userInfo
     * @return
     */
    boolean delete(UserInfo userInfo);

    /**
     * 更新用户信息
     * @param userAll
     * @return
     */
    boolean update(UserAll userAll);
}
