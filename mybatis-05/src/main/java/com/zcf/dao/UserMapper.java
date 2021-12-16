package com.zcf.dao;

import com.zcf.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUserList();

    @Select("select * from user where id = #{uid}")
    User getUserById(@Param("uid") int id);

    @Insert("insert into user(id, name, pwd) values(#{id}, #{name}, #{pwd})")
    int insertUser(User user);

    @Update("update user set name=#{name}, pwd=#{pwd} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id =#{a}")
    int deleteUser(int id);





}
