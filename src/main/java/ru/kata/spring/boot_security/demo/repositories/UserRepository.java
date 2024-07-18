package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    void addUser(User user);
    List<User> findAll();
    void delete(Long id);
    void update(User user);
    User getUserById(Long id);
}
