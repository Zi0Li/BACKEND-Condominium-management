package br.com.smartcondo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String cpf;

    @Column(nullable = false)
    String rg;

    @Column(nullable = false)
    String cic;

    @Column(nullable = false)
    String phone;

    @Column(nullable = false)
    String position;

    @Column(nullable = false)
    String workload;

    public Long getId() {
        return id;
    }

    public Employees setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employees setName(String name) {
        this.name = name;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Employees setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getRg() {
        return rg;
    }

    public Employees setRg(String rg) {
        this.rg = rg;
        return this;
    }

    public String getCic() {
        return cic;
    }

    public Employees setCic(String cic) {
        this.cic = cic;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Employees setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public Employees setPosition(String position) {
        this.position = position;
        return this;
    }

    public String getWorkload() {
        return workload;
    }

    public Employees setWorkload(String workload) {
        this.workload = workload;
        return this;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", cic='" + cic + '\'' +
                ", phone='" + phone + '\'' +
                ", position='" + position + '\'' +
                ", workload='" + workload + '\'' +
                '}';
    }
}
