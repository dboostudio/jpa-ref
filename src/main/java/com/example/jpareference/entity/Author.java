package com.example.jpareference.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

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
        this.getBooks().add(book);
        if (book.getAuthor() != this)
            book.setAuthor(this);
    }

}
