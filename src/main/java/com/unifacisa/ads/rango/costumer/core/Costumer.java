package com.unifacisa.ads.rango.costumer.core;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Costumer {

    UUID id;

    String name;

    String cpf;

    String email;

    LocalDateTime createdAt;

    public Costumer() {
    }

    public Costumer(UUID id, String name, String cpf, String email, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.createdAt = createdAt;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return Objects.equals(id, costumer.id) && Objects.equals(name, costumer.name) && Objects.equals(cpf, costumer.cpf) && Objects.equals(email, costumer.email) && Objects.equals(createdAt, costumer.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpf, email, createdAt);
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
