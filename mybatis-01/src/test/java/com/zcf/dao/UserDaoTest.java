package com.zcf.dao;

import com.zcf.pojo.User;
import com.zcf.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void testGetUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();
        System.out.println(userList);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setId(8);
        user.setName("zcf3");
        user.setPwd("1+1");

        int i = mapper.insertUser(user);
        System.out.println(i);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setId(8);
        user.setName("zcf3");
        user.setPwd("1+1");

        int i = mapper.updateUser(user);
        System.out.println(i);

        sqlSession.commit();

        sqlSession.close();
    }


    @Test
    public void testDeleteUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int i = mapper.deleteUserById(7);
        System.out.println(i);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testGetUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userLike = mapper.getUserLike("%zcf%");
        System.out.println(userLike);

        sqlSession.close();
    }


    @Test
    public void testInsertUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("a", 7);
        map.put("b", "zcf2");
        map.put("c", "0000");

        mapper.insertUser2(map);

        sqlSession.commit();

        sqlSession.close();
    }
}
