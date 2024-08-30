package dao;

import jakarta.persistence.TypedQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import model.User;
import play.mvc.Http;

import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.transaction.Transactional;
import java.util.List;

public class UserDAO {
    //@PersistenceContext
    //@Inject
    @PersistenceContext
    private EntityManager em;



    @Inject
    public UserDAO(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void createUser(User user) {
        EntityTransaction transaction = em.getTransaction();
        System.out.println("User in UserDAO: ");


        transaction.begin();
        em.persist(user);
        transaction.commit();
    }

    public User getUser(Long id) {
        return em.find(User.class, id);
    }

    @Transactional
    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Transactional
    public void updateUser(User user) {

        em.merge(user);
    }

//


    //
    @Transactional
    public void deleteUser(Long id) {
        User user = em.find(User.class, id);

        if (user != null) {
            em.remove(user);
            em.flush();
        } else {
            System.out.println("Unable to find User");
        }
    }
}
