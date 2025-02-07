package be.bstorm.tp_jakarta.servlets.utils;

import be.bstorm.tp_jakarta.entities.User;
import be.bstorm.tp_jakarta.entities.Weapon;
import be.bstorm.tp_jakarta.repositories.impls.UserRepositoryImpl;
import be.bstorm.tp_jakarta.repositories.impls.WeaponRepositoryImpl;
import be.bstorm.tp_jakarta.services.UserService;
import be.bstorm.tp_jakarta.services.WeaponService;
import be.bstorm.tp_jakarta.services.impls.UserServiceImpl;
import be.bstorm.tp_jakarta.services.impls.WeaponServiceImpl;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

@WebListener
public class DataInitializer implements ServletContextListener {

    private final UserService userService;
    private final WeaponService weaponService;


    public DataInitializer() {
        this.userService = new UserServiceImpl(new UserRepositoryImpl());
        this.weaponService = new WeaponServiceImpl(new WeaponRepositoryImpl());
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String password = BCrypt.hashpw("all",BCrypt.gensalt());
        User admin = new User("admin", password, "admin");
        User accepted = new User("accepted", password, "accepted");
        User rejected = new User("rejected", password, "rejected");
        userService.addUser(accepted);
        userService.addUser(admin);
        userService.addUser(rejected);

        List<User> users = List.of(
                new User( "John", "Doe", "Le Fantôme.", password, "accepted"),
                new User( "Jane", "Smith", "La Voleuse.", password,  "accepted"),
                new User("Max", "Payne", "Le Punisseur.", password,  "accepted"),
                new User("Alice", "Johnson", "La Sorcière.", password,  "accepted"),
                new User( "Bob", "Brown", "Le Hacker.", password, "accepted"),
                new User("Clara", "White", "La Reine des Glaces.", password,  "accepted"),
                new User( "Jack", "Black", "Le Maître des Ombres", password, "accepted"),
                new User( "Luke", "Skywalker", "Le Jedi Noir .", password,  "accepted"),
                new User( "Diana", "Prince", "La Guerrière .", password,  "accepted"),
                new User( "Emma", "Green", "La Cambrioleuse.", password,  "accepted"),
                new User ("claire","mageren","cm",password,"admin")

        );

        users.forEach(userService::save);

        List<Weapon> weapons = List.of(
            new Weapon( "Épée de Aragorn", "Épée", "Épée elefique", "A récupéré le trône du Gondor avec."),
            new Weapon( "Sabre laser de Luke Skywalker", "Sabre", "Sabre laser", "A combattu l'Empire et rétabli l'équilibre dans la Force."),
            new Weapon( "Marteau de Thor", "Marteau", "Mjolnir", "A aidé à sauver l'univers des forces du mal."),
            new Weapon( "Bouclier de Captain America", "Bouclier", null, "A protégé le monde contre les menaces extraterrestres et les super-vilains."),
            new Weapon( "Baguette de Harry Potter", "Baguette magique", "Bois de houx et plume de phénix", "A vaincu Voldemort et sauvé le monde des sorciers."),
            new Weapon( "Trident de Aquaman", "Trident", null, " A régné sur Atlantis et protégé les océans."),
            new Weapon( "Katana de Michonne", "Katana", null, "A survécu à l'apocalypse zombie avec style."),
            new Weapon( "Arc de Legolas", "Arc", null, "A combattu aux côtés de la Communauté de l'Anneau."),
            new Weapon( "Pistolet de Han Solo", "Blaster", "DL-44", "A aidé à détruire l'Étoile de la Mort et à sauver la galaxie."),
            new Weapon( "Lasso de Wonder Woman", "Lasso", null, "A révélé la vérité et combattu pour la justice.")
        );
        weapons.forEach(weaponService :: save);
    }
}

