package be.bstorm.tp_jakarta;

import be.bstorm.tp_jakarta.entities.User;
import be.bstorm.tp_jakarta.repositories.impls.UserRepositoryImpl;
import be.bstorm.tp_jakarta.services.UserService;
import be.bstorm.tp_jakarta.services.impls.UserServiceImpl;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;

@WebListener
public class DataInitializer implements ServletContextListener {
    private final UserService userService;
    public DataInitializer() {
        this.userService = new UserServiceImpl(new UserRepositoryImpl());
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        User admin = new User("admin", "admin", true,"admin");
        User accepted = new User("admin","admin", true);
        User rejected = new User("lambda","lambda", false);
        userService.addUser(accepted);
        userService.addUser(admin);
        userService.addUser(rejected);
       // add list weapon and weapon.forEach(weaponService :: save);
    }
}
