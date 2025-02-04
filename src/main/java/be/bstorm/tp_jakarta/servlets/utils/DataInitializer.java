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
        User admin = new User("admin", "admin", true, "admin");
        User accepted = new User("accepted", "accepted", true, "accepted");
        User rejected = new User("rejected", "rejected", false, "rejected");
        userService.addUser(accepted);
        userService.addUser(admin);
        userService.addUser(rejected);

        List<User> users = List.of(
                new User(1L,"John","Doe","Le Fantôme.","Ghost123",true,"accepted"),
                new User(2L,"Jane","Smith","La Voleuse.","Thief456",true,"accepted"),
                new User(3L,"Max","Payne","Le Punisseur.","Punish789",true,"accepted"),
                new User(4L,"Alice","Johnson","La Sorcière.","Witch101",true,"accepted"),
                new User(5L,"Bob","Brown","Le Hacker.","Hack202",true,"accepted"),
                new User(6L,"Clara","White","La Reine des Glaces.","IceQueen303",true,"accepted"),
                new User(7L,"Jack","Black","Le Maître des Ombres","Shadow404",true,"accepted"),
                new User(8L,"Luke","Skywalker","Le Jedi Noir .","DarkJedi606",true,"accepted"),
                new User(9L,"Diana","Prince","La Guerrière .","Warrior707",true,"accepted"),
                new User(10L,"Emma","Green","La Cambrioleuse.","Burglar505",true,"accepted")

        );

        users.forEach(userService :: save);

        Weapon weapon_0 = new Weapon(1L, "Épée de Aragorn", "Épée", "Épée elefique", "A récupéré le trône du Gondor avec.");
        Weapon weapon_1 = new Weapon(2L, "Sabre laser de Luke Skywalker", null, "Sabre laser", "A combattu l'Empire et rétabli l'équilibre dans la Force.");
        Weapon weapon_2 = new Weapon(3L, "Marteau de Thor", "Marteau", "Mjolnir", "A aidé à sauver l'univers des forces du mal.");
        Weapon weapon_3 = new Weapon(4L, "Bouclier de Captain America", "Bouclier", null, "A protégé le monde contre les menaces extraterrestres et les super-vilains.");
        Weapon weapon_4 = new Weapon(5L, "Baguette de Harry Potter", "Baguette magique", "Bois de houx et plume de phénix", "A vaincu Voldemort et sauvé le monde des sorciers.");
        Weapon weapon_5 = new Weapon(6L, "Trident de Aquaman", "Trident", null, " A régné sur Atlantis et protégé les océans.");
        Weapon weapon_6 = new Weapon(7L, "Katana de Michonne", "Katana", null, "A survécu à l'apocalypse zombie avec style.");
        Weapon weapon_7 = new Weapon(8L, "Arc de Legolas", "Arc", null, "A combattu aux côtés de la Communauté de l'Anneau.");
        Weapon weapon_8 = new Weapon(9L, "Pistolet de Han Solo", "Blaster", "DL-44", "A aidé à détruire l'Étoile de la Mort et à sauver la galaxie.");
        Weapon weapon_9 = new Weapon(10L, "Lasso de Wonder Woman", "Lasso", null, "A révélé la vérité et combattu pour la justice.");

        weaponService.save(weapon_0);
        weaponService.save(weapon_1);
        weaponService.save(weapon_2);
        weaponService.save(weapon_3);
        weaponService.save(weapon_4);
        weaponService.save(weapon_5);
        weaponService.save(weapon_6);
        weaponService.save(weapon_7);
        weaponService.save(weapon_8);
        weaponService.save(weapon_9);

    }
}

