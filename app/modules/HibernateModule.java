package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateModule extends AbstractModule {
    @Override
    protected void configure() {
        // No direct bindings needed here
    }

    @Provides
    @Singleton
    public EntityManagerFactory provideEntityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("defaultPersistenceUnit");

        return emf;
    }

    @Provides
    @Singleton
    public EntityManager provideEntityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }
}
