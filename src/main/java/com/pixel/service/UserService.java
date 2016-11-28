package com.pixel.service;


import java.util.List;

import com.pixel.model.User;

public interface UserService {

    List<User> findAllUsers();

    User findByUserName(String userName);
    User findByUserId(Long userId);

    User save(User user);


}

