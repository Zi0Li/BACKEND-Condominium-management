package br.com.smartcondo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "resident")
@JsonPropertyOrder({"id", "name", "cpf", "rg", "age", "phone"})
public class Resident {

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
    String block;

    @Column(nullable = false)
    String apt;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "condominium_id")
    @JsonBackReference(value = "condominium")
    private Condominium condominium;

    @JsonIgnore
    @OneToMany(mappedBy = "resident", fetch = FetchType.EAGER)
    private List<Vehicle> vehicles;

    @JsonIgnore
    @OneToMany(mappedBy = "resident", fetch = FetchType.EAGER)
    private List<AuthorizedPersons> authorizedPersons;

    @OneToMany(mappedBy = "resident")
    @JsonIgnore
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

    public String getBlock() {
        return block;
    }

    public Resident setBlock(String block) {
        this.block = block;
        return this;
    }

    public String getApt() {
        return apt;
    }

    public Resident setApt(String apt) {
        this.apt = apt;
        return this;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Resident setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
        return this;
    }

    public List<AuthorizedPersons> getAuthorizedPersons() {
        return authorizedPersons;
    }

    public Resident setAuthorizedPersons(List<AuthorizedPersons> authorizedPersons) {
        this.authorizedPersons = authorizedPersons;
        return this;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Resident setReservations(List<Reservation> reservations) {
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
                ", block='" + block + '\'' +
                ", apt='" + apt + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", condominium=" + condominium +
                ", vehicles=" + vehicles +
                ", authorizedPersons=" + authorizedPersons +
                ", reservations=" + reservations +
                '}';
    }
}
