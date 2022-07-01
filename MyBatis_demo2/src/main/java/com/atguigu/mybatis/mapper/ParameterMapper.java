package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ybshang
 * @create 2022-06-14-14:39
 */
public interface ParameterMapper {

    /**
     * 查询所有员工信息
     */
    List<User> getAllUsers();

    /**
     * 1. 单个参数
     * 根据用户名查询用户信息
     */
    User getUserByUsername(String username);

    /**
     * 2. 两个参数
     * 检测登录
     */
    User checkLogin(String username, String password);

    /**
     * 3. 参数为map
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 4. 参数为实体类对象
     * 添加用户信息
     */
    int insertUser(User user);

    /**
     * 5. 使用@Param注解命名参数
     * 验证登录
     */
    User checkLoginByParam(
            @Param("username") String username,
            @Param("password") String password
    );


}
