package com.apirestful.crud.model;

import lombok.Getter;
import jakarta.persistence.*;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Objects;

@Entity
@Table(name = "user_table")
public class User {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @Setter
    @Column(length = 25, nullable= false)
    private String name;
    @Getter
    @Setter
    @Column(length = 20, nullable= false, unique=true)
    private String username;
    @Getter
    @Setter
    @Column(length = 100, nullable= false)
    private String password;


    public User(String name, String username, String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        this.name = name;
        this.username = username;
        this.password = encoder.encode(password);
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User: " + "id: " + id + ", name: " + name + ", username: " + username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
