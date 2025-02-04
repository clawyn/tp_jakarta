package be.bstorm.tp_jakarta.repositories.impls;

import be.bstorm.tp_jakarta.servlets.utils.EmfFactoryUtils;
import be.bstorm.tp_jakarta.entities.Weapon;
import be.bstorm.tp_jakarta.repositories.WeaponRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@SessionScoped
public class WeaponRepositoryImpl implements WeaponRepository, Serializable {
    private EntityManagerFactory emf;

    public void WeaponRepositoryImpl(){
        emf = EmfFactoryUtils.getEmf();
    }

    @Override
    public List<Weapon> findAll() {
       try (EntityManager em = emf.createEntityManager()) {
           return em.createQuery("select w from Weapon w", Weapon.class).getResultList();
       }
    }

    @Override
    public Optional<Weapon> findBySerialNumber(Long serialNumber) {
        try(EntityManager em = emf.createEntityManager()) {
            return Optional.of(em.find(Weapon.class, serialNumber));
        }
    }

    @Override
    public Optional<Weapon> findByName ( String name) {
        try(EntityManager em = emf.createEntityManager()) {
            return Optional.of(em.find(Weapon.class, name));
        }
    }

    @Override
    public Weapon save(Weapon weapon) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(weapon);
            em.getTransaction().commit();
            return weapon;
        }
    }

    @Override
    public boolean existsBySerialNumber(Long serialNumber) {
        try(EntityManager em = emf.createEntityManager()) {
            Query query = em.createQuery("select count(w) > 0 from Weapon w where w.serialNumber = :serialNumber");
            query.setParameter("serialNumber", serialNumber);
            Long count = (Long) query.getSingleResult();
            boolean exists = count > 0;
            return exists;
        }
    }

    @Override
    public void updateByName(Weapon weapon, String name) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Weapon otherWeapon = em.find(Weapon.class, name);
            otherWeapon.setSerialNumber(weapon.getSerialNumber());
            otherWeapon.setName(weapon.getName());
            otherWeapon.setType(weapon.getType());
            otherWeapon.setModel(weapon.getModel());
            otherWeapon.setHistory(weapon.getHistory());

            em.getTransaction().commit();
        }

    }

    @Override
    public void update(Weapon weapon, Long serialNumber) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Weapon otherWeapon = em.find(Weapon.class,serialNumber);
            otherWeapon.setSerialNumber(weapon.getSerialNumber());
            otherWeapon.setName(weapon.getName());
            otherWeapon.setType(weapon.getType());
            otherWeapon.setModel(weapon.getModel());
            otherWeapon.setHistory(weapon.getHistory());

            em.getTransaction().commit();
        }

    }


    @Override
    public void delete(Long serialNumber) {


    }

    @Override
    public void deleteAll(Weapon weapon) {

    }
}
