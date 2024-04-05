package br.com.smartcondo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resident_id", nullable = false)
    @JsonBackReference(value = "resident")
    private Resident resident;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kiosk_id", nullable = false)
    @JsonBackReference(value = "kiosk")
    private Kiosk kiosk;

    public Long getId() {
        return id;
    }

    public Reservation setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Reservation setDate(String date) {
        this.date = date;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Reservation setDescription(String description) {
        this.description = description;
        return this;
    }

    public Resident getResident() {
        return resident;
    }

    public Reservation setResident(Resident resident) {
        this.resident = resident;
        return this;
    }

    public Kiosk getKiosk() {
        return kiosk;
    }

    public Reservation setKiosk(Kiosk kiosk) {
        this.kiosk = kiosk;
        return this;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", resident=" + resident +
                ", kiosk=" + kiosk +
                '}';
    }
}
