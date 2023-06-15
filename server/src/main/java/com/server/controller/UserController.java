package com.server.controller;

import com.server.common.R;
import com.server.controller.vo.UserLogin;
import com.server.dto.UserAll;
import com.server.service.UserService;
import com.server.utils.IpAddressUtil;
import com.server.utils.RegexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public R register(HttpServletRequest request,@RequestBody UserAll userAll){
        String email= userAll.getEmail();
        if(!RegexUtils.isEmail(email)) return R.error("邮箱格式错误!");
        String phone= userAll.getPhone();
        if(!RegexUtils.isMobilePhone(phone)) return R.error("手机号码格式错误!");
        if(userAll.getAge()<=0) return R.error("年龄错误！");
        userAll.setLoginIp(IpAddressUtil.getIpAddress(request));
        if(userService.register(userAll)) return R.success(userAll.getUserId());
        return R.error("注册失败");
    }

    @PostMapping("/login")
    public R login(HttpServletRequest request, @RequestParam int loginWay,
                   @RequestBody UserLogin userLogin){
        String email=userLogin.getEmail();
        if(!RegexUtils.isEmail(email)) return R.error("邮箱格式错误!");

        String loginIp=IpAddressUtil.getIpAddress(request);
        if(loginWay==0){
            if(userService.loginByPwd(userLogin,loginIp))
                return R.success("登录成功");
        }else if (loginWay==1){
            if(userService.loginByVerification(userLogin,loginIp))
                return R.success("登录成功");
        }
        return R.error("登录失败");
    }
}
