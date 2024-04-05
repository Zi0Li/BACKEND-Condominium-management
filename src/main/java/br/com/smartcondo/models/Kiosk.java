package br.com.smartcondo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "kiosk")
public class Kiosk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String type;

    @Column(nullable = false)
    String description;

    public Long getId() {
        return id;
    }

    public Kiosk setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Kiosk setType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Kiosk setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Kiosk{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
