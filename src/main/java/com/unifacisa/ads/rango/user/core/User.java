package com.unifacisa.ads.rango.user.core;

import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID id;

    private String userName;

    private String email;

    private String password;

    private String role;

    public User() {
    }

    public User(UUID id, String userName, String email, String password, String role) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(userName, user.userName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, email, password, role);
    }
}
