package com.server.entity;

import com.server.dto.UserAll;
import lombok.Data;

import java.io.Serializable;

@Data
public class Student extends UserAll implements Serializable {
    private String studentId;
    private String college;
    private String grade;
    private String clazz;
    /**
     * 宿舍楼栋号
     */
    private String dormBuilding;
    /**
     * 寝室号
     */
    private String dormNumber;
    private String authorityId;
}
