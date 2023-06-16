package com.server.mapper;

import com.server.mapper.po.UserInfo;
import com.server.utils.StringsUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserAllMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void addTest(){
        UserInfo user=new UserInfo();
        user.setUserId(StringsUtils.makeId("Tom"));
        userInfoMapper.insert(user);
    }

    @Test
    public void updateTest(){
        UserInfo user=new UserInfo();
        user.setUserId("d0b7703fbd143980bd3e02cd6989ee5e");
        user.setPassword("12345");
        int i = userInfoMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    public void deleteTest(){
        userInfoMapper.deleteById("test1");
        UserInfo userInfo = userInfoMapper.selectById("test1");
        System.out.println(userInfo);
    }

    @Test
    public void getUsernameTest(){
        List<String> usernames = userInfoMapper.getUsernames();
        for (int i = 0; i < usernames.size(); i++) {
            System.out.println(usernames.get(i));
        }
    }
}
