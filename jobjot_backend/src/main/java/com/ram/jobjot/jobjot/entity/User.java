
package com.ram.jobjot.jobjot.entity;

import jakarta.persistence.*;

@Entity
// Marks this as a JPA entity
@Table(name = "app_user")
public class User {
@Id
    // Specifies this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates the ID
    private Long id;

    private String username;
    private String email;
    private String password;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}