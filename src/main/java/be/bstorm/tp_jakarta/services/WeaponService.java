package be.bstorm.tp_jakarta.services;

import be.bstorm.tp_jakarta.entities.Weapon;

import java.util.List;

public interface WeaponService {

    List<Weapon> findAll();
    Weapon findBySerialNumber(Long serialNumber);
    Weapon save (Weapon weapon);
    void update(Weapon weapon, Long serialNumber);
    void updateByName(Weapon weapon, String name);

    void deleteBySerialNumber(Long serialNumber);
    void deleteWeapon(Weapon weapon);
}
