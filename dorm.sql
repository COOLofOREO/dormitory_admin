DROP DATABASE IF EXISTS dormitory;
CREATE DATABASE dormitory;
USE dormitory;

DROP TABLE IF EXISTS uesr;
CREATE TABLE uesr(
    `user_id` VARCHAR(32) NOT NULL   COMMENT '用户id' ,
    `username` VARCHAR(32)    COMMENT '用户名' ,
    `role` VARCHAR(2)    COMMENT '角色代号' ,
    `email` VARCHAR(255)    COMMENT '邮箱' ,
    `status` VARCHAR(255)    COMMENT '状态' ,
    `image` VARCHAR(255)    COMMENT '头像' ,
    `name` VARCHAR(50)    COMMENT '姓名' ,
    `sex` VARCHAR(10)    COMMENT '性别' ,
    `age` INT    COMMENT '年龄' ,
    `phone` VARCHAR(15)    COMMENT '电话号码' ,
    PRIMARY KEY (user_id)
)  COMMENT = '用户表';

DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info(
    `user_id` VARCHAR(32) NOT NULL   COMMENT '用户id' ,
    `email` VARCHAR(255)    COMMENT '邮箱' ,
    `password` VARCHAR(255)    COMMENT '登录密码' ,
    `create_time` DATETIME    COMMENT '创建时间' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `login_ip` VARCHAR(15)    COMMENT '上次登录IP' ,
    `deleted` INT    COMMENT '逻辑删除' ,
    PRIMARY KEY (user_id)
)  COMMENT = '用户信息';

DROP TABLE IF EXISTS student;
CREATE TABLE student(
    `user_id` VARCHAR(32) NOT NULL   COMMENT '学生id' ,
    `student_id` VARCHAR(32)    COMMENT '学号' ,
    `college` VARCHAR(50)    COMMENT '所在学院' ,
    `grade` VARCHAR(16)    COMMENT '年级' ,
    `clazz` VARCHAR(16)    COMMENT '班级' ,
    `dorm_building` VARCHAR(32)    COMMENT '宿舍楼栋' ,
    `dorm_number` INT    COMMENT '寝室号' ,
    `authority_id` VARCHAR(2)    COMMENT '权限' ,
    PRIMARY KEY (user_id)
)  COMMENT = '学生表';

DROP TABLE IF EXISTS housemaster;
CREATE TABLE housemaster(
    `user_id` VARCHAR(32) NOT NULL   COMMENT '宿管id' ,
    `employee_id` VARCHAR(32)    COMMENT '职工号' ,
    `dorm_building` VARCHAR(32)    COMMENT '管理楼栋' ,
    `authority_id` VARCHAR(2)    COMMENT '权限' ,
    PRIMARY KEY (user_id)
)  COMMENT = '宿舍管理员';

DROP TABLE IF EXISTS system_administrator;
CREATE TABLE system_administrator(
    `user_id` VARCHAR(32)    COMMENT '管理员id' ,
    `employee_id` VARCHAR(32)    COMMENT '职工号' 
)  COMMENT = '系统管理员';

DROP TABLE IF EXISTS authority;
CREATE TABLE authority(
    `authority` VARCHAR(2) NOT NULL   COMMENT '权限id' ,
    `create_by` VARCHAR(32)    COMMENT '创建人id' ,
    `create_time` DATETIME    COMMENT '创建时间' ,
    `update_by` VARCHAR(32)    COMMENT '更新人id' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `publish_clock` VARCHAR(1)    COMMENT '发布打卡' ,
    `update_clock` VARCHAR(1)    COMMENT '更新打卡' ,
    `student_read` VARCHAR(1)    COMMENT '学生信息读' ,
    `student_write` VARCHAR(1)    COMMENT '学生信息写' ,
    `housemaster_read` VARCHAR(1)    COMMENT '宿管信息读' ,
    `housemaster_write` VARCHAR(1)    COMMENT '宿管信息写' ,
    `notice_read` VARCHAR(1)    COMMENT '公告信息读' ,
    `notice_write` VARCHAR(1)    COMMENT '公告信息写' ,
    PRIMARY KEY (authority)
)  COMMENT = '权限表';

DROP TABLE IF EXISTS clock_in;
CREATE TABLE clock_in(
    `clock_id` VARCHAR(32) NOT NULL   COMMENT '考勤编号' ,
    `create_by` VARCHAR(32)    COMMENT '创建人id' ,
    `create_time` DATETIME    COMMENT '创建时间' ,
    `update_by` VARCHAR(32)    COMMENT '更新人id' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `begin_time` DATETIME    COMMENT '开始时间' ,
    `end_time` DATETIME    COMMENT '结束时间' ,
    `reparable` VARCHAR(1)    COMMENT '能否补签' ,
    PRIMARY KEY (clock_id)
)  COMMENT = '考勤表';

DROP TABLE IF EXISTS clock_dorm;
CREATE TABLE clock_dorm(
    `id` VARCHAR(32) NOT NULL   COMMENT 'id' ,
    `clock_id` VARCHAR(32)    COMMENT '考勤编号' ,
    `dorm_building` VARCHAR(32)    COMMENT '宿舍楼栋' ,
    PRIMARY KEY (id)
)  COMMENT = '考勤-楼栋联系表';

DROP TABLE IF EXISTS notice;
CREATE TABLE notice(
    `notice_id` VARCHAR(32) NOT NULL   COMMENT '公告id' ,
    `title` VARCHAR(64)    COMMENT '公告标题' ,
    `content` VARCHAR(2000)    COMMENT '公告内容' ,
    `create_by` VARCHAR(32)    COMMENT '创建人' ,
    `create_time` DATETIME    COMMENT '创建时间' ,
    `update_by` VARCHAR(32)    COMMENT '更新人' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `begin_time` DATETIME    COMMENT '开始时间' ,
    `end_time` DATETIME    COMMENT '截止时间' ,
    PRIMARY KEY (notice_id)
)  COMMENT = '公告表';

DROP TABLE IF EXISTS apartment;
CREATE TABLE apartment(
    `apartment_id` VARCHAR(32) NOT NULL   COMMENT '楼栋id' ,
    `apartment_name` VARCHAR(32)    COMMENT '楼栋名' ,
    `housemaster_id` VARCHAR(32)    COMMENT '宿舍管理员' ,
    `dorm_number` INT    COMMENT '寝室数' ,
    `location` VARCHAR(256)    COMMENT '位置' ,
    PRIMARY KEY (apartment_id)
)  COMMENT = '宿舍楼栋';

DROP TABLE IF EXISTS dorm;
CREATE TABLE dorm(
    `dorm_id` VARCHAR(32) NOT NULL   COMMENT '寝室id' ,
    `apartment_id` VARCHAR(32)    COMMENT '所属楼栋' ,
    `dorm_number` VARCHAR(32)    COMMENT '门牌号' ,
    `capacity` INT    COMMENT '床位数' ,
    `number` INT    COMMENT '寝室人数' ,
    PRIMARY KEY (dorm_id)
)  COMMENT = '寝室表';

DROP TABLE IF EXISTS dorm_student;
CREATE TABLE dorm_student(
    `dorm_id` VARCHAR(32)    COMMENT '寝室id' ,
    `user_id` VARCHAR(32)    COMMENT '学生id' ,
    `apartment_id` VARCHAR(32)    COMMENT '所属楼栋' ,
    `bed_number` INT    COMMENT '床位号' ,
    `enter_time` DATETIME    COMMENT '入住时间' ,
    `apart_time` DATETIME    COMMENT '搬离时间' 
)  COMMENT = '寝室-学生联系表';
