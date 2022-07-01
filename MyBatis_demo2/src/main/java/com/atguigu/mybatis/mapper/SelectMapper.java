package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author ybshang
 * @create 2022-06-14-16:04
 */
public interface SelectMapper {

    /**
     * 1.
     * 根据id查询用户信息
     */
    User getUserById(@Param("id") Integer id);
}
