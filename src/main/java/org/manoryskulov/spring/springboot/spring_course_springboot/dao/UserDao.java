package org.manoryskulov.spring.springboot.spring_course_springboot.dao;


import org.manoryskulov.spring.springboot.spring_course_springboot.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    void updateUser(User user);

    void deleteUserById(long id);

    public User findById(long id);
}
