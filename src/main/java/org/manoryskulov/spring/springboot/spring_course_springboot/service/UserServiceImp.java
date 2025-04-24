package org.manoryskulov.spring.springboot.spring_course_springboot.service;


import org.manoryskulov.spring.springboot.spring_course_springboot.dao.UserDaoImp;
import org.manoryskulov.spring.springboot.spring_course_springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDaoImp userDao;

    @Autowired
    public UserServiceImp(UserDaoImp userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUserById(long id) {
        userDao.deleteUserById(id);
    }

    @Transactional
    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }


}
