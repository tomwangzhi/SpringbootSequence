package com.wz.springboot.service;

import com.wz.springboot.dao.UserDao;
import com.wz.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User findUserById(long id) {
        User user = userDao.findById(id).get();
        return user;
    }

    @Transactional
    public boolean updateUserById(User user) {
        User findUser = userDao.findById(user.getId()).get();
        if (findUser != null) {
            userDao.save(user);
            return true;
        }
        return false;

    }
}
