package com.pixel.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pixel.model.User;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository <User, Long> {
    List<User> findAll();

    User findByUserName(String userName);
    User findByUserId(Long userId);

    User save(User user);
}
