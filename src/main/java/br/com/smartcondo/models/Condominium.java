package br.com.smartcondo.models;

import br.com.smartcondo.controllers.RandomController;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "condominium")
public class Condominium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int code = RandomController.getRandom();

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int cep;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private int number_address;

    @Column(nullable = false)
    private String uf;

    @Column(nullable = false)
    private List<String> block;

    @Column(nullable = false)
    private List<String> number_apt;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String reference;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "syndicate_id", nullable = false)
    @JsonBackReference(value = "syndicate")
    private Syndicate syndicate;

    @OneToMany(mappedBy = "condominium")
    private List<Resident> residents;

    @OneToMany(mappedBy = "condominium")
    private List<Kiosk> kiosks;

    @OneToMany(mappedBy = "condominium")
    private List<Employees> employees;

    @OneToMany(mappedBy = "condominium")
    private List<Notification> notifications;

    @OneToMany(mappedBy = "condominium")
    private List<Report> reports;

    public Long getId() {
        return id;
    }

    public Condominium setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Condominium setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getName() {
        return name;
    }

    public Condominium setName(String name) {
        this.name = name;
        return this;
    }

    public Syndicate getSyndicate() {
        return syndicate;
    }

    public Condominium setSyndicate(Syndicate syndicate) {
        this.syndicate = syndicate;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Condominium setCode(int code) {
        this.code = code;
        return this;
    }


    public int getCep() {
        return cep;
    }

    public Condominium setCep(int cep) {
        this.cep = cep;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Condominium setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public Condominium setDistrict(String district) {
        this.district = district;
        return this;
    }

    public int getNumber_address() {
        return number_address;
    }

    public Condominium setNumber_address(int number_address) {
        this.number_address = number_address;
        return this;
    }

    public String getUf() {
        return uf;
    }

    public Condominium setUf(String uf) {
        this.uf = uf;
        return this;
    }

    public List<String> getBlock() {
        return block;
    }

    public Condominium setBlock(List<String> block) {
        this.block = block;
        return this;
    }

    public List<String> getNumber_apt() {
        return number_apt;
    }

    public Condominium setNumber_apt(List<String> number_apt) {
        this.number_apt = number_apt;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Condominium setCity(String city) {
        this.city = city;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public Condominium setReference(String reference) {
        this.reference = reference;
        return this;
    }

    private List<Kiosk> getKiosks() {
        return kiosks;
    }

    private Condominium setKiosks(List<Kiosk> kiosks) {
        this.kiosks = kiosks;
        return this;
    }

    private List<Resident> getResidents() {
        return residents;
    }

    private Condominium setResidents(List<Resident> residents) {
        this.residents = residents;
        return this;
    }

    private List<Employees> getEmployees() {
        return employees;
    }

    private Condominium setEmployees(List<Employees> employees) {
        this.employees = employees;
        return this;
    }

    private List<Notification> getNotifications() {
        return notifications;
    }

    private Condominium setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
        return this;
    }

    @Override
    public String toString() {
        return "Condominium{" +
                "id=" + id +
                ", code=" + code +
                ", cnpj='" + cnpj + '\'' +
                ", name='" + name + '\'' +
                ", cep=" + cep +
                ", street='" + street + '\'' +
                ", district='" + district + '\'' +
                ", number_address=" + number_address +
                ", uf='" + uf + '\'' +
                ", block=" + block +
                ", number_apt=" + number_apt +
                ", city='" + city + '\'' +
                ", reference='" + reference + '\'' +
                ", syndicate=" + syndicate +
                ", residents=" + residents +
                ", kiosks=" + kiosks +
                ", employees=" + employees +
                ", notifications=" + notifications +
                '}';
    }
}
