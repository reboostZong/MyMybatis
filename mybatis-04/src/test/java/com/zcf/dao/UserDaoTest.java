package com.zcf.dao;

import com.zcf.pojo.User;
import com.zcf.util.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    /** logger */
    private Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void testGetUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        System.out.println(userList);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testLog() {
        logger.info("start method testLog...");


        logger.info("end method testLog...");
    }

    @Test
    public void testGetUserListByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);

        List<User> userListByLimit = mapper.getUserListByLimit(map);
        System.out.println(userListByLimit);


        sqlSession.close();
    }

    @Test
    public void testGetUserListByRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 分页参数rowBounds

        RowBounds rowBounds = new RowBounds(0, 2);
        List<User> list = sqlSession.selectList("com.zcf.dao.UserMapper.getUserListByRowBounds",null, rowBounds);
        System.out.println(list);


        sqlSession.close();
    }
}
