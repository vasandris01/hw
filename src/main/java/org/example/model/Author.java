package org.example.model;

import jakarta.persistence.*;

import java.util.List;

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "store")

    @ManyToOne
    @JoinColumn(name = "id")
            @Column(name = "zlasdfg")
    List<Store> store;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
