package br.com.smartcondo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @ManyToOne
    @JoinColumn(name = "condominium_id", nullable = false)
    @JsonBackReference(value = "condominium")
    private Condominium condominium;

    @OneToMany(mappedBy = "kiosk", fetch = FetchType.EAGER)
    @JsonBackReference(value = "reservations")
    @JsonIgnore
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

    public Condominium getCondominium() {
        return condominium;
    }

    public Kiosk setCondominium(Condominium condominium) {
        this.condominium = condominium;
        return this;
    }

    @Override
    public String toString() {
        return "Kiosk{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", condominium=" + condominium +
                ", reservations=" + reservations +
                '}';
    }
}
