package br.com.smartcondo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "resident")
@JsonPropertyOrder({"id", "name", "cpf", "rg", "age", "phone"})
public class Resident{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String rg;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    int age;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "condominium_id", nullable = false)
    @JsonBackReference(value = "condominium")
    private Condominium condominium;

    @OneToMany(mappedBy = "resident")
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "resident")
    private List<AuthorizedPersons> authorizedPersons;

    @OneToMany(mappedBy = "resident")
    private List<Reservation> reservations;

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

    private List<Vehicle> getVehicles() {
        return vehicles;
    }

    private Resident setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
        return this;
    }

    private List<AuthorizedPersons> getAuthorizedPersons() {
        return authorizedPersons;
    }

    private Resident setAuthorizedPersons(List<AuthorizedPersons> authorizedPersons) {
        this.authorizedPersons = authorizedPersons;
        return this;
    }

    private List<Reservation> getReservations() {
        return reservations;
    }

    private Resident setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
        return this;
    }

    public Condominium getCondominium() {
        return condominium;
    }

    public Resident setCondominium(Condominium condominium) {
        this.condominium = condominium;
        return this;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", vehicles=" + vehicles +
                ", authorizedPersons=" + authorizedPersons +
                ", reservations=" + reservations +
                ", condominium=" + condominium +
                '}';
    }


}
