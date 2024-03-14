package br.com.smartcondo.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
@JsonPropertyOrder({"id", "user_id", "user_type", "email", "password"})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    Long user_id;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String user_type;

    public Long getId() {
        return id;
    }

    public Users setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUser_id() {
        return user_id;
    }

    public Users setUser_id(Long user_id) {
        this.user_id = user_id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Users setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Users setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUser_type() {
        return user_type;
    }

    public Users setUser_type(String user_type) {
        this.user_type = user_type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id) && Objects.equals(user_id, users.user_id) && Objects.equals(email, users.email) && Objects.equals(password, users.password) && Objects.equals(user_type, users.user_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, email, password, user_type);
    }
}
