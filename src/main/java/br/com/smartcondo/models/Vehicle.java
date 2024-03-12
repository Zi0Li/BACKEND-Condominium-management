package br.com.smartcondo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resident_id", nullable = false)
    @JsonBackReference
    private Resident resident;


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

    public Resident getResident() {
        return resident;
    }

    public Vehicle setResident(Resident resident) {
        this.resident = resident;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) && Objects.equals(plate, vehicle.plate) && Objects.equals(type, vehicle.type) && Objects.equals(brand, vehicle.brand) && Objects.equals(color, vehicle.color) && Objects.equals(model, vehicle.model) && Objects.equals(year, vehicle.year) && Objects.equals(resident, vehicle.resident);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plate, type, brand, color, model, year, resident);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", resident=" + resident +
                '}';
    }
}
