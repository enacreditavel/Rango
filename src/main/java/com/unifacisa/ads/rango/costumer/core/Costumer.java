package com.unifacisa.ads.rango.costumer.core;

import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;
import com.unifacisa.ads.rango.user.core.User;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Costumer {

    private UUID id;

    private String name;

    private String cpf;

    private User user;

    private LocalDateTime createdAt;

    public Costumer() {
    }

    public Costumer(UUID id, String name, String cpf, User user, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.user = user;
        this.createdAt = createdAt;
    }


    public static Costumer create(String name, String cpf, User user) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty.");
        }
        if (!isValidCpf(cpf)) {
            throw new IllegalArgumentException("Invalid CPF.");
        }
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }

        return new Costumer(user.getId(), name, cpf, user, LocalDateTime.now());
    }

    public void update(String newName){
        var updated = false;

        if (!this.name.matches(newName)){
            changeName(newName);
            updated = true;
        }

        if(!updated) throw new BadRequestException("No changes detected");

    }


    private void changeName(String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty.");
        }
        this.name = newName;
    }

    /**
     * Behavior to correct/change the CPF.
     */
//    public void changeCpf(String newCpf) {
//        if (newCpf == null || !isValidCpf(newCpf)) {
//            throw new IllegalArgumentException("Invalid CPF.");
//        }
//       Ex: Business rule - can only change the CPF if the current one is null
//         if (this.cpf != null) {
//            throw new BadRequestException("CPF cannot be changed once set.");
//         }
//        this.cpf = newCpf;
//    }
//
    public void assignUser(User newUser) {
        if (newUser == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        this.user = newUser;
    }

    public static boolean isValidCpf(String cpf) {
        if (cpf == null) return false;

        // Removes everything that is not digit
        String digits = cpf.replaceAll("\\D", "");
        if (digits.length() != 11) return false;

        // Rejects CPFs with all the same digits (ex.: 00000000000, 11111111111, ...)
        if (digits.chars().distinct().count() == 1) return false;

        try {
            int[] nums = new int[11];
            for (int i = 0; i < 11; i++) nums[i] = Character.digit(digits.charAt(i), 10);

            // Calculates first check digit (pos 9)
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += nums[i] * (10 - i);
            }
            int rem = sum % 11;
            int dv1 = (rem < 2) ? 0 : 11 - rem;
            if (nums[9] != dv1) return false;

            // Calculate second digit checker (pos 10)
            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += nums[i] * (11 - i);
            }
            rem = sum % 11;
            int dv2 = (rem < 2) ? 0 : 11 - rem;
            return nums[10] == dv2;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Costumer costumer = (Costumer) o;
        return Objects.equals(id, costumer.id) && Objects.equals(name, costumer.name) && Objects.equals(cpf, costumer.cpf) && Objects.equals(user, costumer.user) && Objects.equals(createdAt, costumer.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpf, user, createdAt);
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
