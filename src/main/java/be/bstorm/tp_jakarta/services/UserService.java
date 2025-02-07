package be.bstorm.tp_jakarta.services;

import be.bstorm.tp_jakarta.entities.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User Log (String pseudonym, String password);
    User save (User user);


    List<User> findAll();


    User findById(Long id);


    void update(User user, Long id);
}
