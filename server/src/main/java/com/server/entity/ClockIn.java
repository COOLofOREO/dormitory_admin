package com.server.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class ClockIn implements Serializable {
    private String clockId;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private Date beginTime;
    private Date endTime;
    /**
     * 能否补签
     */
    private boolean reparable;
}
