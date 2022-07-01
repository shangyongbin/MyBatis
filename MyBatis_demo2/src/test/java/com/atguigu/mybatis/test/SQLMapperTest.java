package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SQLMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SQLMapperTest {

    @Test
    public void testGetUsersByTablename() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);

        List<User> t_user = mapper.getUsersByTablename("t_user");

        for (User user : t_user) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);

        User user = new User(null, "xiaoqing", "abc123", 18, "女", "abc123@qq.com");
        mapper.insertUser(user);

        System.out.println(user);
    }
}
