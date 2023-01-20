package com.example.jpareference.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Author author;

    @Lob
    private String description;

    @Enumerated
    private BookCategory bookCategory;

    public void setAuthor(Author author){
        if (this.author != null) {
            this.author.getBooks().remove(this);
        }
        this.author = author;
        author.getBooks().add(this);
    }

}
