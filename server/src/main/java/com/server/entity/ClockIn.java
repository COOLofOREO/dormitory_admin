package com.server.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ClockIn implements Serializable {
    private String clockId;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    /**
     * 能否补签
     */
    private boolean reparable;
}
