package br.com.smartcondo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean view;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resident_id")
    @JsonBackReference(value = "resident")
    private Resident resident;

    @ManyToOne()
    @JoinColumn(name = "condominium_id", nullable = false)
    @JsonBackReference(value = "condominium")
    private Condominium condominium;

    public Long getId() {
        return id;
    }

    public Report setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Report setDate(String date) {
        this.date = date;
        return this;
    }

    public String getType() {
        return type;
    }

    public Report setType(String type) {
        this.type = type;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Report setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Report setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Report setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean getView() {
        return view;
    }

    public Report setView(boolean view) {
        this.view = view;
        return this;
    }

    public Resident getResident() {
        return resident;
    }

    public Report setResident(Resident resident) {
        this.resident = resident;
        return this;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
