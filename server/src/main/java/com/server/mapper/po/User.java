package com.server.mapper.po;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    @TableId
    private String userId;
    private String username;
    private String role;
    private String email;
    private String status;
    private String image;
    private String name;
    private String sex;
    private int age;
    private String phone;
}
