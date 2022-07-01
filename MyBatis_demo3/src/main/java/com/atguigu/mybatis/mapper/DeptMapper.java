package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {


    /**
     * 分布查询的第2步：通过did查询部分信息
     */
    Dept getEmpWithDeptByStepTwo(@Param("did") int did);

    /**
     * 获取部门和所有员工信息
     */
    Dept getDeptWithEmp(@Param("did") int did);

    /**
     * 通过分布查询部门和所有员工信息
     * 第1步：查询部门信息
     */
    Dept getDeptWithEmpByStepOne(@Param("did") int did);

}
