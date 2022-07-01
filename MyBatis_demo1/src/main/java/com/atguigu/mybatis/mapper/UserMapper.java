package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

/**
 * @author ybshang
 * @create 2022-05-10-16:14
 */

// 之前操作的表名叫t_user，对应的实体类叫User，因此dao叫UserDao
// 现在创建的mapper接口代替dao，因此mapper接口叫UserMapper
public interface UserMapper {
    /**
     * 添加用户信息
     */
    int insertUser();
    // 使用sql语句和jdbc操作数据库

    /**
     * 修改用户信息
     */
    int updateUser();

    /**
     * 删除用户
     */
    int deleteUser();

    /**
     * 查询一个用户信息
     */
    User getUserById();

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getAllUsers();
}
