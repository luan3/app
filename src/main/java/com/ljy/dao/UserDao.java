package com.ljy.dao;

import com.ljy.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {
    User login(@Param(value = "name") String name, @Param(value = "password") String password);
}
