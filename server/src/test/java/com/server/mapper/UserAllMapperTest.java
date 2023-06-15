package com.server.mapper;

import com.server.mapper.po.UserInfo;
import com.server.utils.StringsUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserAllMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void addTest(){
        UserInfo user=new UserInfo();
        user.setUserId(StringsUtils.makeId("Tom"));
        userMapper.insert(user);
    }

    @Test
    public void updateTest(){
        UserInfo user=new UserInfo();
        user.setUserId("d0b7703fbd143980bd3e02cd6989ee5e");
        user.setPassword("12345");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    public void deleteTest(){
        userMapper.deleteById("test1");
        UserInfo userInfo = userMapper.selectById("test1");
        System.out.println(userInfo);
    }
}
