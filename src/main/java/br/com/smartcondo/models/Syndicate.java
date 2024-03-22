package br.com.smartcondo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "syndicate")
public class Syndicate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String rg;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String phone;

    public Long getId() {
        return id;
    }

    public Syndicate setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Syndicate setName(String name) {
        this.name = name;
        return this;
    }

    public String getRg() {
        return rg;
    }

    public Syndicate setRg(String rg) {
        this.rg = rg;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Syndicate setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Syndicate setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public String toString() {
        return "Syndicate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
