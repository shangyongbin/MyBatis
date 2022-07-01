package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SQLMapper {


    /**
     * 批量删除
     */


    /**
     * 设置表名
     */
    List<User> getUsersByTablename(@Param("tablename") String tablename);

    /**
     * 获取自增的主键
     */
    void insertUser(User user);
}
