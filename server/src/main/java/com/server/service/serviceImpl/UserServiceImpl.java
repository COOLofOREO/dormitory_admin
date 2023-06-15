package com.server.service.serviceImpl;

import com.server.controller.vo.UserLogin;
import com.server.dto.UserAll;
import com.server.mapper.UserMapper;
import com.server.mapper.po.User;
import com.server.mapper.po.UserInfo;
import com.server.service.UserService;
import com.server.utils.StringsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean addUser(UserAll userAll) {
        return userMapper.addUser(userAll);
    }

    @Transactional
    @Override
    public boolean register(UserAll userAll) {
        //检查昵称重复
        List<UserAll> list=userMapper.getUserByUsername(userAll.getUsername());
        if(list!=null&&list.size()>0) return false;
        String pwd= userAll.getPassword();
        //MD5加密 生成32位密码
        String hashedPwd = DigestUtils.md5DigestAsHex((pwd).getBytes());
        userAll.setUserId(StringsUtils.makeId(userAll.getUsername()));
        userAll.setStatus("正常");
        userMapper.addUser(userAll);

        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(userAll.getUserId());
        userInfo.setPassword(hashedPwd);
        userInfo.setLoginIp(userAll.getLoginIp());
        userInfo.setEmail(userAll.getEmail());
        userInfo.setCreateTime(LocalDateTime.now());
        userInfo.setUpdateTime(LocalDateTime.now());

        userMapper.insert(userInfo);

        return true;
    }

    @Transactional
    @Override
    public boolean loginByPwd(UserLogin userLogin,String loginIp){
        User user = userMapper.getUserByEmail(userLogin.getEmail());
        if(user==null) return false;
        String pwd=StringsUtils.toMD5(userLogin.getPassword());
        //密码错误
        if(!pwd.equals(userLogin.getPassword())) return false;
        //更新登录时间和ip
        userMapper.updateLoginIpByEmail(userLogin.getEmail(),loginIp);
        userMapper.updateTimeByEmail(userLogin.getEmail(),LocalDateTime.now());
        return true;
    }

    @Transactional
    @Override
    public boolean loginByVerification(UserLogin userLogin,String loginIp){
        //验证邮箱验证码
        ValueOperations ops = redisTemplate.opsForValue();
        String verification = (String) ops.get(userLogin.getEmail());
        boolean bool=userLogin.getVerification().equals(verification);
        //删除验证码记录
        redisTemplate.delete(userLogin.getEmail());
        if(bool){
            //验证码正确
            //更新登录时间和ip
            userMapper.updateLoginIpByEmail(userLogin.getEmail(),loginIp);
            userMapper.updateTimeByEmail(userLogin.getEmail(),LocalDateTime.now());
            return true;
        }
        return false;
    }
}
