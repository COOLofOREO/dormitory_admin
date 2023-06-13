package com.server.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Apartment implements Serializable {
    private String apartmentId;
    private String apartmentName;
    private String housemasterId;
    /**
     * 寝室房间数
     */
    private String dormNumber;
    /**
     * 位置
     */
    private String location;
}
