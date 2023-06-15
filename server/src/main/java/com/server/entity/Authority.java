package com.server.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Authority implements Serializable {
    /**
     * 权限id
     */
    private String authority;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    /**
     * 发布打卡
     */
    private boolean publishClock;
    /**
     * 更新打卡
     */
    private boolean updateClock;
    /**
     * 学生信息读
     */
    private boolean studentRead;
    /**
     * 学生信息写
     */
    private boolean studentWrite;
    /**
     * 宿管信息读
     */
    private boolean housemasterRead;
    /**
     * 宿管信息写
     */
    private boolean housemasterWrite;
    /**
     * 公告信息读
     */
    private boolean noticeRead;
    /**
     * 公告信息写
     */
    private boolean noticeWrite;
}
