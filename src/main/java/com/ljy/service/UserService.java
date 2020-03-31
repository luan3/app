package com.ljy.service;

import com.ljy.pojo.User;

public interface UserService {
    User login(String name, String password);
}
