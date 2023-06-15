package com.server.controller.vo;

import lombok.Data;

@Data
public class UserLogin {
    private String email;
    private String password;
    private String verification;
}
