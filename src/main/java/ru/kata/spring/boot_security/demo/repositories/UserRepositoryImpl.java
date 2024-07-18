package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public User findUserByEmail(String email) {
        return entityManager.createQuery("select u from User u join fetch u.roles where u.email = :id", User.class)
                .setParameter("id", email)
                .getResultList().stream().findAny().orElse(null);
    }

    public void delete(Long id) {
        User us = entityManager.find(User.class, id);
        entityManager.remove(us);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public List<User> findAll() {
        return entityManager.createQuery("select s from User s", User.class).getResultList();
    }

    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}
