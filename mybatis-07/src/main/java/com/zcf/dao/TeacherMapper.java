package com.zcf.dao;

import com.zcf.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getAllTeacher();

    List<Teacher> getAllTeacher2();
}
