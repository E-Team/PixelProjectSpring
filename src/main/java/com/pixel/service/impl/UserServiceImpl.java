package com.pixel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixel.dao.UserDao;
import com.pixel.model.User;
import com.pixel.service.UserService;

//////////////////////////////////////////////////////
/////           PIXEL PROJECT    ///////////////
//////////////////////////////////////////////////////


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    public User save(User user) {
        return userDao.save(user);
    }

	@Override
	public User findByUserId(Long userId) {
		return userDao.findByUserId(userId);
	}

	

}
