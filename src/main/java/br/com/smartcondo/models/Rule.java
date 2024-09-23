package br.com.smartcondo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rule")
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column()
    private List<String> content;

    @ManyToOne
    @JoinColumn(name = "condominium_id")
    @JsonBackReference(value = "condominium")
    private Condominium condominium;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content=" + content +
                '}';
    }
}
