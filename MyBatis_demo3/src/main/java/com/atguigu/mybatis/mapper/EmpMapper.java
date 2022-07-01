package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 查询所有员工
     */
    List<Emp> getAllEmp();

    /**
     * 查询员工和对应的部门信息
     */
    Emp getEmpWithDept(@Param("eid") int eid);

    Emp getEmpWithDeptByStep(@Param("eid") int eid);

    /**
     * 获取部门和它所有员工信息
     * 分步查询第2步
     */
    List<Emp> getEmpByDid(@Param("did") int did);
}
