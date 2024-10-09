package br.com.smartcondo.models;

import jakarta.persistence.*;

import java.util.List;

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

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "syndicate", fetch = FetchType.EAGER)
    private List<Condominium> condominiums;

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

    public String getEmail() {
        return email;
    }

    public Syndicate setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<Condominium> getCondominiums() {
        return condominiums;
    }

    public Syndicate setCondominiums(List<Condominium> condominiums) {
        this.condominiums = condominiums;
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
                ", email='" + email + '\'' +
                ", condominiums=" + condominiums +
                '}';
    }
}
