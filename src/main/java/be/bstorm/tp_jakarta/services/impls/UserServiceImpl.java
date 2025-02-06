package be.bstorm.tp_jakarta.services.impls;

import be.bstorm.tp_jakarta.entities.User;
import be.bstorm.tp_jakarta.repositories.UserRepository;
import be.bstorm.tp_jakarta.services.UserService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;

@SessionScoped
public class UserServiceImpl implements UserService, Serializable {
    @Inject
    private UserRepository userRepository;
    public UserServiceImpl() {}
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        if (userRepository.existsByPseudonym(user.getPseudonym())){
            throw new IllegalArgumentException("User already exists");
        }
        if(user.getRole() == null){
            user.setRole("user");
        }
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

    @Override
    public User Log(String pseudonym, String password) {
        User user = userRepository.findByPseudonym(pseudonym).orElseThrow();/*null*/
        if (!BCrypt.checkpw(password, user.getPassword())){
            throw new IllegalArgumentException("Wrong password");
        }
        return user;
    }


    @Override
    public User save(User user) {
        if(userRepository.existsByPseudonym(user.getPseudonym())){
            throw new RuntimeException("User already exists");
        }

        return userRepository.save(user);
    }

}
