package be.bstorm.tp_jakarta;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmfFactoryUtils {
    public static EntityManagerFactory emf;

    public static EntityManagerFactory getEmf() {
        emf = emf != null ? emf : Persistence.createEntityManagerFactory("tp_jakarta");
        return emf;
    }
}
