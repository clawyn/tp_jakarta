package be.bstorm.tp_jakarta.services;

import be.bstorm.tp_jakarta.entities.User;

public interface UserService {
    void addUser(User user);
    User Log (String pseudonym, String password);
}
