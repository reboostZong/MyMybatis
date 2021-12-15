package com.zcf.dao;

import com.zcf.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    List<User> getUserListByLimit(Map<String, Integer> map);

    List<User> getUserListByRowBounds();

}
