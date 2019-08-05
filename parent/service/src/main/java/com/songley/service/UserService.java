package com.songley.service;


import com.songley.dao.UserDao;
import com.songley.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User dologin(User user){
        user = this.userDao.login(user.getUsername(),user.getPassword());
        return user;
    }


}
