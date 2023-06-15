package com.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.server.dto.UserAll;
import com.server.mapper.po.User;
import com.server.mapper.po.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {

    boolean addUser(UserAll userAll);

    List<UserAll> getUserByUsername(String username);

    UserAll getUserByEmail(String email);

    User getByEmail(String email);

    boolean updateLoginIpByEmail(String email,String loginIp);

    boolean updateTimeByEmail(String email, LocalDateTime now);
}
