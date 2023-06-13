package com.server.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Administrator extends User implements Serializable {
    private String employeeId;
}
