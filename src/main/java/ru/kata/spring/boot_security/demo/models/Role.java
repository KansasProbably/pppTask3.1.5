package ru.kata.spring.boot_security.demo.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @Override
    public String toString() {
        return name.substring(5).replaceAll("[()<\\[\\]>]", "");
    }

    @Override
    public String getAuthority() {
        return name.substring(5).replaceAll("[()<\\[\\]>]", "");
    }
}