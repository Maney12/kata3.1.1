package org.manoryskulov.spring.springboot.spring_course_springboot.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.manoryskulov.spring.springboot.spring_course_springboot.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void updateUser(User user) {
        if (user.getId() != null) {
            entityManager.merge(user); // Слияние с существующей записью
        } else {
            entityManager.persist(user); // Если нет ID, создаем новый
        }
    }

    @Override
    public void deleteUserById(long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }


}
