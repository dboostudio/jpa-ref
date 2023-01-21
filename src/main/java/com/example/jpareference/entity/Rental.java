package com.example.jpareference.entity;

import com.example.jpareference.repo.BookRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "isDeleted = false")
public class Rental {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Library library;

    @ManyToOne
    private Member member;

    @OneToOne
    private Book book;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime rentalStart;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime rentalEnd;

    @Builder.Default
    private Boolean isDeleted = false;

    public void checkIn() {
        this.isDeleted = true;
    }

    public void checkOut(Book book, Member member) throws Exception {
        if (this.book != null)
            throw new Exception("대여정보는 수정할 수 없습니다.");

        this.setMember(member);
        this.setBook(book);
        this.rentalStart = LocalDateTime.now();
        this.rentalEnd = LocalDateTime.now().plusDays(7);
    }

    protected void setBook(Book book) throws Exception {
        if (book.getRental() != null)
            throw new Exception("누군가 빌린 책이다.");
        this.book = book;
        book.setRental(this);
    }

    protected void setMember(Member member) {
        this.member = member;
        member.addRental(this);
    }
}
