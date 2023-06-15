package com.server.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest
public class UtilsTest {

    @Test
    public void dateTest(){
        Date date=new Date();
        System.out.println(date);
        LocalDateTime time=LocalDateTime.now();
        System.out.println(time);
    }

    @Test
    public void UuidTest(){
        System.out.println(StringsUtils.makeId("Mike"));
        System.out.println(StringsUtils.makeId("Mike"));
    }

    @Test
    public void md5Test(){
        String pwd="12345";
        String s = DigestUtils.md5DigestAsHex((pwd).getBytes());
        String st=DigestUtils.md5DigestAsHex("123".getBytes());
        System.out.println(s);
        System.out.println(st);
    }
}
