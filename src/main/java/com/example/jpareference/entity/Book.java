package com.example.jpareference.entity;

import com.example.jpareference.dto.response.BookDto;
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

        // 기존 연관관계 Author->Book 를 지운다.
        if (this.author != null && this.author.getBooks().contains(this))
            this.author.getBooks().remove(this);
        // Book -> Author 연관관계를 변경한다.
        this.author = author;
        // 새로운 Author -> Book 연관관계를 등록한다.
        if (!author.getBooks().contains(this))
            author.getBooks().add(this);
    }

    public BookDto toDto() {
        return BookDto.builder()
                .bookCategory(this.bookCategory)
                .description(this.description)
                .build();
    }

}
