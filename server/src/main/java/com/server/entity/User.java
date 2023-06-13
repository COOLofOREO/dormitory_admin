package com.server.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private String userId;
    private String username;
    private String name;
    private String role;
    private String email;
    private String image;
    private String status;
    private String sex;
    private String age;
    private String phone;

    private String password;
    private int deleted;
    private Date createTime;
    private Date updateTime;
    private String loginIp;
}
