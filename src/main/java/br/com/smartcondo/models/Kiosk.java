package br.com.smartcondo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

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

    @OneToMany(mappedBy = "kiosk", fetch = FetchType.EAGER)
    private List<Reservation> reservations;

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

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Kiosk setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
        return this;
    }

    @Override
    public String toString() {
        return "Kiosk{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", reservations=" + reservations +
                '}';
    }
}
