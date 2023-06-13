package com.server.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Housemaster extends User implements Serializable {
    private String employeeId;
    /**
     * 管理楼栋
     */
    private String dormBuilding;
    /**
     * 权限
     */
    private String authorityId;
}
