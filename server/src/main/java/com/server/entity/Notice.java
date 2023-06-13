package com.server.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Notice implements Serializable {
    private String noticeId;
    private String title;
    private String content;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private Date beginTime;
    private Date endTime;
}
