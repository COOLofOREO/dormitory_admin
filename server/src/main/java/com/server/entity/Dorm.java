package com.server.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Dorm implements Serializable {
    private String dormId;
    private String apartmentId;
    /**
     * 寝室门牌号
     */
    private String dormNumber;
    /**
     * 床位数
     */
    private int capacity;
    /**
     * 寝室人数
     */
    private int number;
}
