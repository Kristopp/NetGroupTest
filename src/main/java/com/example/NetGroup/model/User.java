package com.example.NetGroup.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "user")
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false, updatable = false)
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "admin")
    private boolean admin;

    public User() {
    }
    //Constructor

    public User(
            String username,
            String email,
            String password
    ) {
        this.email = email;
        this.username = username;
        this.password = password;

    }

    public Long getId(Long id) {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return username;
    }

    public void setName(String s) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String s) {
        this.email = email;
    }



    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String encode) {
        this.password = password;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin() {
        this.admin = false;
    }

    @Override
    public String toString() {
        return "Users{ " +
                "id=" + id +
                ", name " + username + '\'' +
                ", password " + password + '\'' +
                ", created_at " + createdAt + '\'' +
                ", admin" + admin + '\'' +
                "}";
    }


}
