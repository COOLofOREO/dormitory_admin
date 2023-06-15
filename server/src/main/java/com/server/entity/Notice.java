package com.server.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Notice implements Serializable {
    private String noticeId;
    private String title;
    private String content;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
}
