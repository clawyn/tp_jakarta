package be.bstorm.tp_jakarta.repositories;

import be.bstorm.tp_jakarta.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    boolean existsByPseudonym(String pseudonym);
    Optional<User> findByPseudonym(String pseudonym);


    List<User> findAll();
}
