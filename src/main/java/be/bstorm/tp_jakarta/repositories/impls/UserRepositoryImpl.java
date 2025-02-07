package be.bstorm.tp_jakarta.repositories.impls;

import be.bstorm.tp_jakarta.servlets.utils.EmfFactoryUtils;
import be.bstorm.tp_jakarta.entities.User;
import be.bstorm.tp_jakarta.repositories.UserRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@SessionScoped
public class UserRepositoryImpl implements UserRepository, Serializable {
    private final EntityManagerFactory emf ;

    public UserRepositoryImpl() {
        this.emf = EmfFactoryUtils.getEmf();
    }

    @Override
    public  User save(User user) {
        try(EntityManager em = emf.createEntityManager() ){

            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return user;
        }catch (Exception e){
            System.out.println( e.getMessage());
            return null;
        }
    }

    @Override
    public boolean existsByPseudonym(String pseudonym) {
        try (EntityManager em = emf.createEntityManager()){
            Query query = em.createQuery("SELECT count(u) > 0 FROM User u WHERE u.pseudonym = :pseudonym");
            query.setParameter("pseudonym", pseudonym);
            return (boolean) query.getSingleResult();
        }
    }

    @Override
    public Optional<User> findByPseudonym(String pseudonym) {
        try(EntityManager em = emf.createEntityManager()){
            Query query = em.createQuery("SELECT u From User u WHERE u.pseudonym = :pseudonym");
            query.setParameter("pseudonym", pseudonym);
            return Optional.of((User) query.getSingleResult());
        }
    }

    @Override
    public List<User> findAll() {
        try(EntityManager em = emf.createEntityManager()){
            return em.createQuery("SELECT u From User u", User.class).getResultList();
        }
    }
}
