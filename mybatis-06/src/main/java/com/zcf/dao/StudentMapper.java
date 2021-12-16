package com.zcf.dao;

import com.zcf.pojo.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> manyToOneGetStudents();

    List<Student> manyToOneGetStudents2();
}
