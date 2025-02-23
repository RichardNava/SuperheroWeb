package com.core.dao;

import com.core.exceptions.PreexistingEntityException;
import com.core.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.RollbackException;
import jakarta.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserController {

    private final EntityManagerFactory emf;

    public UserController() {
        this.emf = Persistence.createEntityManagerFactory("SuperHeroesWebPU");
    }

    // Operaciones CRUD
    // Create
    public void createUser(User user) throws PreexistingEntityException {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }

    }

    //UPDATE
    public void updateUser(User user) {
        try (EntityManager em = emf.createEntityManager()) {
            if (readUser(findUserByName(user.getUsername()).getId()) != null) {
                em.getTransaction().begin();
                em.merge(user);
                em.getTransaction().commit();
            }
            else {
                System.out.println("No existe ese usuario");
            }
        }
    }

    //READ
    public User readUser(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(User.class, id);
        }
    }

    public User findUserByName(String username) {
        try (EntityManager em = emf.createEntityManager()) {
            Query query = em.createNamedQuery("User.findByUsername",User.class);
            return  (User) query.setParameter("username", username).getResultStream().findFirst()
                    .orElse(null);
        }
    }

    public Optional<User> findUserByEmail(String email) {
        try (EntityManager em = emf.createEntityManager()) {
            Query query = em.createNamedQuery("User.findByEmail",User.class);
            return  query.setParameter("email", email).getResultStream().findFirst();

        }
    }

    //DELETE
    public void deleteUser(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            User user = em.find(User.class, id);
            if (user != null) {
                em.remove(user);
            }
            else {
                System.out.println("No existe ese usuario");
            }
            em.getTransaction().commit();
        }
    }
}
