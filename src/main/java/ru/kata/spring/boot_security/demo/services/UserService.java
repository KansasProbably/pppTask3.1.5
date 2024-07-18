package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    User getUser(long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(long id);


}
