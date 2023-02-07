package org.example.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "stores")
    private Map<Book, Integer> stock;

    @OneToMany(mappedBy = "store")
    private Set<Stock> stock;

    @ManyToMany
    @JoinTable(name = "store_book",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
