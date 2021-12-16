package com.zcf.dao;

import com.zcf.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    @Select("select * from teacher")
    List<Teacher> getAllTeacher();
}
