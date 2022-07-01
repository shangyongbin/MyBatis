package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DynamicSQLMapperTest {

    @Test
    public void testGetEmpByCondition() {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);


        List<Emp> empByCondition = mapper.getEmpByCondition(new Emp(null, "ming", 16, null, null));

        System.out.println(empByCondition);
    }
}
