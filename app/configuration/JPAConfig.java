//package configuration;
//
//import com.google.inject.AbstractModule;
//import com.google.inject.Inject;
//import com.google.inject.Provider;
//import com.google.inject.Singleton;
//import play.db.jpa.JPAApi;
//
//import javax.persistence.EntityManager;
//
//public class JPAConfig extends AbstractModule {
//    @Override
//    protected void configure() {
//        bind(JPAApi.class).toProvider(JPAApiProvider.class).in(Singleton.class);
//        bind(EntityManager.class).toProvider(EntityManagerProvider.class).in(Singleton.class);
//    }
//
//    @Singleton
//    public static class JPAApiProvider implements Provider<JPAApi> {
//        @Inject
//        private play.db.jpa.JPAApi jpaApi;
//
//        @Override
//        public JPAApi get() {
//            return jpaApi;
//        }
//    }
//
//    @Singleton
//    public static class EntityManagerProvider implements Provider<EntityManager> {
//        @Inject
//        private JPAApi jpaApi;
//
//        @Override
//        public EntityMansager get() {
//            return jpaApi.em();
//        }
//    }
//}