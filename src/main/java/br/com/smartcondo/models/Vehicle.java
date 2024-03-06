package br.com.smartcondo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String plate;

    @Column(nullable = false)
    String type;

    @Column(nullable = false)
    String brand;

    @Column(nullable = false)
    String color;

    @Column(nullable = false)
    String model;

    @Column(nullable = false)
    String year;


    public Long getId() {
        return id;
    }

    public Vehicle setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPlate() {
        return plate;
    }

    public Vehicle setPlate(String plate) {
        this.plate = plate;
        return this;
    }

    public String getType() {
        return type;
    }

    public Vehicle setType(String type) {
        this.type = type;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Vehicle setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Vehicle setColor(String color) {
        this.color = color;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Vehicle setModel(String model) {
        this.model = model;
        return this;
    }

    public String getYear() {
        return year;
    }

    public Vehicle setYear(String year) {
        this.year = year;
        return this;
    }
}
