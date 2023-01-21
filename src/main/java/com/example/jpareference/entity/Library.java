package com.example.jpareference.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Library {

    @Id
    @GeneratedValue
    private Long id;

    private String address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "library")
    private List<Book> books;

    public void addBook(Book book) {
        this.getBooks().add(book);
        if (book.getLibrary() != this)
            book.setLibrary(this);
    }
}
