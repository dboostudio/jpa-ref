package com.example.jpareference.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Library {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "library")
    private List<Book> books;

    public void addBook(Book book) {
        this.getBooks().add(book);
        if (book.getLibrary() != this)
            book.setLibrary(this);
    }

    public void addBooks(List<Book> book) {
        book.forEach(_book -> {
            this.getBooks().add(_book);
            if (_book.getLibrary() != this)
                _book.setLibrary(this);
        });

    }
}
