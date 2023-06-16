package com.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.server.mapper.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
