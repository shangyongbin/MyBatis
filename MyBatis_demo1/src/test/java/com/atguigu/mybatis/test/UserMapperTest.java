package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * @author ybshang
 * @create 2022-05-10-16:31
 */
public class UserMapperTest extends TestCase {
    @Test
    public void testInsertUser() throws IOException {
        // 1. 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2. 获取SqlSession
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is); // 工厂模式
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // true为自动提交事务

        // 3. 获取mapper实例
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);// 代理模式，返回接口实现类的实例

        // 4. 测试
        int result = mapper.insertUser();
        // (1) 根据UserMapper接口找到映射文件UserMapper.xml
        // (2) 根据调用方法insertUser找到id='insertUser'的sql语句
        System.out.println("result:" + result);

        // 提交事务
//        sqlSession.commit();
        // jdbc中事务是自动提交的，当需要手动管理事务时，才会将自动提交关闭
        //
    }

    @Test
    public void testUpdateUser() throws IOException {
        // 1. 加载核心配置文件mybatis-config.xml
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2. 获取SqlSession
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取mapper实例
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 4. 使用
        int result = mapper.updateUser();

    }

    @Test
    public void testDeleteUserById() throws IOException {
        // 1. 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2. 获取SqlSession
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取mapper实例
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 4. 使用
        int i = mapper.deleteUser();

        System.out.println(i);
    }

    @Test
    public void testGetUserById() throws IOException {
        // 1. 加载核心配置文件mybatis-config.xml
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2. 获取SqlSession
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取mapper实例
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 4. 使用
        User user = mapper.getUserById();
        System.out.println(user);
    }

    @Test
    public void testGetAllUsers() throws IOException {
        // 1. 加载核心配置文件mybatis-config.xml
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2. 获取SqlSession
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取mapper实例
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 4. 使用

        List<User> allUsers = mapper.getAllUsers();

        allUsers.forEach(user -> System.out.println(user));

    }
}