package com.example.jpareference.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "books")
@DynamicUpdate
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "author")
    private List<Book> books;

    @Transient
    private String temp;

    public void addBook(Book book) {
        if (this.books == null)
            this.books = new ArrayList<>();
        this.books.add(book);
        if (book.getAuthor() != this)
            book.setAuthor(this);
    }

    public void addBooks(List<Book> books) {
        if (this.books == null)
            this.books = new ArrayList<>();
        this.books.addAll(books);
        books.forEach(b -> {
            if( b.getAuthor() != this)
                b.setAuthor(this);
        });
    }

}
