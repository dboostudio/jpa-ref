package com.example.jpareference.entity;

import com.example.jpareference.dto.response.BookDto;
import com.example.jpareference.repo.RentalRepository;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Library library;

    @Lob
    private String description;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "book")
    private Rental rental;

    @Enumerated
    private BookCategory bookCategory;

    public void setAuthor(Author author){

        // 기존 연관관계 Author -> Book 를 지운다.
        if (this.author != null)
            this.author.getBooks().remove(this);
        // Book -> Author 연관관계를 변경한다.
        this.author = author;
        // 새로운 Author -> Book 연관관계를 등록한다.
        author.addBook(this);
    }

    public void setLibrary(Library library){
        if (this.library != null && this.library.getBooks().contains(this))
            this.library.getBooks().remove(this);
        this.library = library;
        if (!library.getBooks().contains(this))
            library.getBooks().add(this);
    }

    public void setRental(Rental rental) throws Exception {
        // 기존 렌탈정보 삭제
        if (this.rental != null)
            this.rental.checkIn();
        // 렌탈정보 갱신
        this.rental = rental;
        if (rental.getBook() != this)
            rental.setBook(this);
    }

    public BookDto toDto() {
        return BookDto.builder()
                .bookCategory(this.bookCategory)
                .description(this.description)
                .build();
    }

}
