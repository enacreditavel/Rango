package com.unifacisa.ads.rango.user.core;

import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class User {
    private UUID id;

    private String email;

    private String password;

    private String role;

    private UUID assignedId;

    public User() {
    }

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;

    }

    public User(UUID id, String email, String password, String role, UUID assignedId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.assignedId = assignedId;
    }

    public static User create(String email, String password, String role){
        if (!isValidEmail(email)) throw new IllegalArgumentException("Invalid email format.");
        if (!isValidPassword(password)) throw new IllegalArgumentException("Password does not meet complexity requirements.");
        if (!role.equalsIgnoreCase("ROLE_COSTUMER") && !role.equalsIgnoreCase("ROLE_RESTAURANT"))
            throw new IllegalArgumentException("Invalid role, please inform a valid role");
        return new User(email, password, role);
    }

    public void assignIdToUser(UUID assignedId) {
        if (assignedId == null || assignedId.toString().isBlank()) throw new IllegalArgumentException("Assigned Id cannot be null.");

        this.assignedId = assignedId;
    }

    public void changeEmail(String newEmail){
        if (!isValidEmail(newEmail)) throw new IllegalArgumentException("Invalid email format.");
        this.email = newEmail;
    }

    public void changePassword(String newPassword){
        if (!isValidPassword(newPassword)) throw new IllegalArgumentException("Password does not meet complexity requirements.");
        this.password = newPassword ;
    }

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");

    private static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()])[A-Za-z\\d!@#$%^&*()]{8,12}$");

    private static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    //GETTERS AND SETTERS

    public UUID getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(UUID assignedId) {
        this.assignedId = assignedId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, role);
    }
}
