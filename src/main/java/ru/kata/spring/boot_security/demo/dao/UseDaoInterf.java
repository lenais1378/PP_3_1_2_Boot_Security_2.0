package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UseDaoInterf {
    User findByName(String username);
    void delete(Long id);
    void update(User us);
    boolean add(User user);
    List<User> listUsers();
    User findById(Long id);
}
