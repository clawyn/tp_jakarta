package be.bstorm.tp_jakarta.repositories;

import be.bstorm.tp_jakarta.entities.Weapon;
import java.util.List;
import java.util.Optional;

public interface WeaponRepository {

    List<Weapon> findAll();
    Optional<Weapon> findBySerialNumber (Long serialNumber);
    Optional<Weapon> findByName (String name);

    Weapon save(Weapon weapon);

    boolean existsBySerialNumber (Long serialNumber);

    void updateByName(Weapon weapon, String name );
    void update(Weapon weapon, Long serialNumber);


    void delete(Long serialNumber);
    void deleteAll(Weapon weapon);
}
