package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class EmpMapperTest {

    @Test
    public void testGetAllEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        List<Emp> allEmp = mapper.getAllEmp();

        allEmp.forEach(emp -> System.out.println(emp));
    }

    @Test
    public void testGetEmpWithDept() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        Emp empWithDept = mapper.getEmpWithDept(1);

        System.out.println(empWithDept);
    }

    @Test
    public void testGetEmpWithDeptByStep() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        Emp empWithDept = mapper.getEmpWithDeptByStep(1);

        System.out.println(empWithDept.getEmpName());
        System.out.println("-------------------------");
        System.out.println(empWithDept.getDept());
    }

    @Test
    public void testGetDeptWithEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);

        Dept deptWithEmp = mapper.getDeptWithEmp(1);

        System.out.println(deptWithEmp);
    }

    @Test
    public void testGetDeptWithEmpByStepOne() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);

        Dept deptWithEmp = mapper.getDeptWithEmpByStepOne(1);

        System.out.println(deptWithEmp.getDeptName());
    }
}
