package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.ParameterMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @author ybshang
 * @create 2022-06-14-14:46
 */
public class ParameterMapperTest {

    @Test
    public void testGetAllUsers() throws IOException {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> allUsers = mapper.getAllUsers();

        for (User user : allUsers) {
            System.out.println(user);
        }

    }

    @Test
    public void testGetUserByUsername() throws IOException {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User xiaoxiao1 = mapper.getUserByUsername("xiaoxiao1");
        System.out.println(xiaoxiao1);

    }

    @Test
    public void testCheckLogin() throws IOException {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User xiaoxiao1 = mapper.checkLogin("xiaoxiao1", "abc123");
        System.out.println(xiaoxiao1);

    }

    @Test
    public void testCheckLoginByMap() throws IOException {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "xiaoxiao1");
        map.put("password", "abc123");
        User xiaoxiao1 = mapper.checkLoginByMap(map);
        System.out.println(xiaoxiao1);

    }

    @Test
    public void testInsertUser() throws IOException {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);

        int i = mapper.insertUser(new User(null, "xiaoming", "123", 19, "男", "123@qq.com"));
        System.out.println(i);
    }

}
