package org.mrchv.springbootcrud.service;

import org.mrchv.springbootcrud.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserById(Long id);
    void saveUser(User user);
    void removeUserById(Long id);
}
