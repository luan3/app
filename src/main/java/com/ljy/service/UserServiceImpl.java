package com.ljy.service;

import com.ljy.dao.UserDao;
import com.ljy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String name, String password) {
        User user = userDao.login(name, password);
        return user;
    }
}
