package be.bstorm.tp_jakarta.repositories;

import be.bstorm.tp_jakarta.entities.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    boolean existsByPseudonym(String pseudonym);
    Optional<User> findByPseudonym(String pseudonym);
}
