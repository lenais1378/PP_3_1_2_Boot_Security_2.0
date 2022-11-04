package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public User findByName(String username) {
        return entityManager.createQuery("select u FROM User u JOIn fETCH u.roles WHERe u.username = :id", User.class)
                .setParameter("id", username)
                .getResultList().stream().findAny().orElse(null);
    }

    public  void delete(Long id) {
        User us = entityManager.find(User.class, id);
        entityManager.remove(us);
    }

    public void update(User us) {
        entityManager.merge(us);
    }

    public boolean add(User user) {
        entityManager.persist(user);
        return true;
    }

    public List<User> listUsers() {
        return entityManager.createQuery("select s from User s", User.class).getResultList();
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }
}

