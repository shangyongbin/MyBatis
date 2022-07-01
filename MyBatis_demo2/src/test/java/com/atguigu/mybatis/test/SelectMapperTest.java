package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author ybshang
 * @create 2022-06-14-16:08
 */
public class SelectMapperTest {

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);

        User user = mapper.getUserById(9);

        System.out.println(user);
    }
}
