package br.com.smartcondo.models;

import java.io.Serializable;

public class Resident implements Serializable {

    private static final Long seriaVersionUID = 1L;

    long id;
    String cpf;
    String rg;
    String name;
    int age;
    String phone;

    public Long getId() {
        return id;
    }

    public Resident setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Resident setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getRg() {
        return rg;
    }

    public Resident setRg(String rg) {
        this.rg = rg;
        return this;
    }

    public String getName() {
        return name;
    }

    public Resident setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Resident setAge(int age) {
        this.age = age;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Resident setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
