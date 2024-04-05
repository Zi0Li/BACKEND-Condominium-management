package br.com.smartcondo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "condominium_address")
public class CondominiumAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    int cep;

    @Column(nullable = false)
    String street;

    @Column(nullable = false)
    String district;

    @Column(nullable = false)
    int number_address;

    @Column(nullable = false)
    String uf;

    @Column(nullable = false)
    List<String> block;

    @Column(nullable = false)
    List<String> number_apt;

    @Column(nullable = false)
    String city;

    @Column(nullable = false)
    String reference;

    public Long getId() {
        return id;
    }

    public CondominiumAddress setId(Long id) {
        this.id = id;
        return this;
    }

    public int getCep() {
        return cep;
    }

    public CondominiumAddress setCep(int cep) {
        this.cep = cep;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public CondominiumAddress setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public CondominiumAddress setDistrict(String district) {
        this.district = district;
        return this;
    }

    public int getNumber_address() {
        return number_address;
    }

    public CondominiumAddress setNumber_address(int number_address) {
        this.number_address = number_address;
        return this;
    }

    public String getUf() {
        return uf;
    }

    public CondominiumAddress setUf(String uf) {
        this.uf = uf;
        return this;
    }

    public List<String> getBlock() {
        return block;
    }

    public CondominiumAddress setBlock(List<String> block) {
        this.block = block;
        return this;
    }

    public List<String> getNumber_apt() {
        return number_apt;
    }

    public CondominiumAddress setNumber_apt(List<String> number_apt) {
        this.number_apt = number_apt;
        return this;
    }

    public String getCity() {
        return city;
    }

    public CondominiumAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public CondominiumAddress setReference(String reference) {
        this.reference = reference;
        return this;
    }

    @Override
    public String toString() {
        return "CondominiumAddress{" +
                "id=" + id +
                ", cep=" + cep +
                ", street='" + street + '\'' +
                ", district='" + district + '\'' +
                ", number_address=" + number_address +
                ", uf='" + uf + '\'' +
                ", block=" + block +
                ", number_apt=" + number_apt +
                ", city='" + city + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}