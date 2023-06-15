package com.server.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 自定义元数据对象处理器
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入操作，自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入操作，开启自动填充......");
        boolean createTime=metaObject.hasSetter("createTime");
        boolean updateTime=metaObject.hasSetter("updateTime");
        Object createTime1 = getFieldValByName("createTime", metaObject);
        Object updateTime1 = getFieldValByName("updateTime", metaObject);
        if(createTime&&createTime1==null){
            metaObject.setValue("createTime", LocalDateTime.now());
        }
        if(updateTime&&updateTime1==null){
            metaObject.setValue("updateTime",LocalDateTime.now());
        }
    }

    /**
     * 更新操作，自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新操作，开启自动填充......");
        boolean updateTime=metaObject.hasSetter("updateTime");
        Object updateTime1 = getFieldValByName("updateTime", metaObject);
        if(updateTime&&updateTime1==null){
            metaObject.setValue("updateTime",LocalDateTime.now());
        }
    }
}
