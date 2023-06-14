package com.server.service.serviceImpl;

import com.server.entity.User;
import com.server.mapper.UserMapper;
import com.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }
}
