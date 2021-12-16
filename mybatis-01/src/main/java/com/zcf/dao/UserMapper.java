package com.zcf.dao;

import com.zcf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(@Param("uid") int id);

    int insertUser(User user);

    int insertUser2(Map map);

    int updateUser(User user);

    int deleteUserById(int id);

    List<User> getUserLike(String name);

    List<User> getUserLike2(String name);
}
