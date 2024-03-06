package br.com.smartcondo.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import org.springframework.core.annotation.Order;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "resident")
@JsonPropertyOrder({"id", "name", "cpf", "rg", "age", "phone"})
public class Resident implements Serializable {

    private static final Long seriaVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String cpf;

    @Column(nullable = false)
    String rg;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    int age;

    @Column(nullable = false)
    String phone;

    @Column(nullable = false)
    String email;

    public Long getId() {
        return id;
    }

    public Resident setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Resident setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getRg() {
        return rg;
    }

    public Resident setRg(String rg) {
        this.rg = rg;
        return this;
    }

    public String getName() {
        return name;
    }

    public Resident setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Resident setAge(int age) {
        this.age = age;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Resident setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Resident setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resident resident = (Resident) o;
        return age == resident.age && Objects.equals(id, resident.id) && Objects.equals(cpf, resident.cpf) && Objects.equals(rg, resident.rg) && Objects.equals(name, resident.name) && Objects.equals(phone, resident.phone) && Objects.equals(email, resident.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, rg, name, age, phone, email);
    }
}
