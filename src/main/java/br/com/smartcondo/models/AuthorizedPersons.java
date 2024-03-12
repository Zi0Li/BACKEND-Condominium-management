package br.com.smartcondo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "authorized_persons")
public class AuthorizedPersons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String rg;

    @Column(nullable = false)
    String cpf;

    @Column(nullable = false)
    String kinship;

    @Column(nullable = false)
    String phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resident_id", nullable = false)
    @JsonBackReference
    private Resident resident;

    public Long getId() {
        return id;
    }

    public AuthorizedPersons setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthorizedPersons setName(String name) {
        this.name = name;
        return this;
    }

    public String getRg() {
        return rg;
    }

    public AuthorizedPersons setRg(String rg) {
        this.rg = rg;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public AuthorizedPersons setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getKinship() {
        return kinship;
    }

    public AuthorizedPersons setKinship(String kinship) {
        this.kinship = kinship;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public AuthorizedPersons setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Resident getResident() {
        return resident;
    }

    public AuthorizedPersons setResident(Resident resident) {
        this.resident = resident;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorizedPersons that = (AuthorizedPersons) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(rg, that.rg) && Objects.equals(cpf, that.cpf) && Objects.equals(kinship, that.kinship) && Objects.equals(phone, that.phone) && Objects.equals(resident, that.resident);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rg, cpf, kinship, phone, resident);
    }
}
