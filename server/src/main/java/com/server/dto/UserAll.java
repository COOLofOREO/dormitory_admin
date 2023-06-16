package com.server.dto;

import com.server.mapper.po.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserAll extends User{

    private String password;
    private Integer deleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String loginIp;
}
