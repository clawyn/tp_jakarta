package be.bstorm.tp_jakarta.services.impls;

import be.bstorm.tp_jakarta.entities.Weapon;
import be.bstorm.tp_jakarta.repositories.WeaponRepository;
import be.bstorm.tp_jakarta.services.WeaponService;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;

import java.io.Serializable;
import java.util.List;

//@WebServlet("/log")
public class WeaponServiceImpl implements WeaponService, Serializable {

    @Inject
    private WeaponRepository weaponRepository;

    public WeaponServiceImpl(){}

    public WeaponServiceImpl(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }


    @Override
    public List<Weapon> findAll() {
        return weaponRepository.findAll();
    }

    @Override
    public Weapon findBySerialNumber(Long serialNumber) {
        return weaponRepository.findBySerialNumber(serialNumber).orElseThrow();
    }

    @Override
    public Weapon save(Weapon weapon) {
        if (weaponRepository.existsBySerialNumber(weapon.getSerialNumber())) {
            throw new RuntimeException("already exists");
        }

        return weaponRepository.save(weapon);
    }

    @Override
    public void update(Weapon weapon, Long serialNumber) {
        Weapon weapons = weaponRepository.findBySerialNumber(weapon.getSerialNumber()).orElseThrow();
        weapons.setName(weapon.getName());
        weapons.setType(weapon.getType());
        weapons.setModel(weapon.getModel());
        weapons.setHistory(weapon.getHistory());
        weaponRepository.update(weapons, serialNumber);
    }
    @Override
    public void updateByName(Weapon weapon, String name){
        Weapon weapons = weaponRepository.findByName(weapon.getName()).orElseThrow();
        weapons.setName(weapon.getName());
        weapons.setType(weapon.getType());
        weapons.setModel(weapon.getModel());
        weapons.setHistory(weapon.getHistory());
        weaponRepository.updateByName(weapons, name);
    }


    @Override
    public void deleteBySerialNumber(Long serialNumber) {
        weaponRepository.delete(serialNumber);
    }

    @Override
    public void deleteWeapon(Weapon weapon){
        weaponRepository.deleteAll(weapon);
    }

    @Override
    public void addWeapon(Weapon weapon) {
        if(weaponRepository.existsBySerialNumber(weapon.getSerialNumber())){
            throw new IllegalArgumentException("already exists");
        }
        weaponRepository.save(weapon);

    }
}
