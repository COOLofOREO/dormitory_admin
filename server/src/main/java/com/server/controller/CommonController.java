package com.server.controller;

import com.server.common.R;
import com.server.exception.ServiceException;
import com.server.utils.MailUtils;
import com.server.utils.RegexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/verification")
    public R<String> sendVerification(String email){
        if(!RegexUtils.isEmail(email)) return R.error("邮箱格式错误");
        String title="验证码";
        String text="您的验证码为：";
        String text1="，有效时间为2分钟,请小心使用，勿将其泄露于他人。";
        Random random=new Random(System.currentTimeMillis());
        double num=random.nextDouble();
        String code=""+num;
        code=code.substring(2,8);
        log.info("验证码：{}",code);
        text=text+code+text1;
        boolean bool=MailUtils.sendMail(email,title,text);
        if(bool){
            //缓存验证码,有效期2min
            //若之前已发送，则会覆盖之前的
            ValueOperations ops = redisTemplate.opsForValue();
            ops.set(email,code,2L, TimeUnit.MINUTES);
            return R.success("发送成功");
        }
        else throw new ServiceException("邮件发送失败");
    }
}
