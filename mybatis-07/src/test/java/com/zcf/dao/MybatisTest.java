package com.zcf.dao;

import com.zcf.pojo.Teacher;
import com.zcf.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    @Test
    public void testGetAllTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> allTeacher = mapper.getAllTeacher();
        System.out.println(allTeacher);


        sqlSession.close();
    }

    @Test
    public void testGetAllTeacher2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> allTeacher = mapper.getAllTeacher2();
        System.out.println(allTeacher);


        sqlSession.close();
    }
}
