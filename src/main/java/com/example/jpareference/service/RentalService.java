package com.example.jpareference.service;

import com.example.jpareference.dto.response.BookDto;
import com.example.jpareference.entity.*;
import com.example.jpareference.repo.AuthorRepository;
import com.example.jpareference.repo.BookRepository;
import com.example.jpareference.repo.MemberRepository;
import com.example.jpareference.repo.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final RentalRepository rentalRepository;

    @Transactional
    public void rental() throws Exception {
        Member member = Member.builder()
                .firstName("명훈")
                .lastName("강")
                .roleType(RoleType.MEMBER)
                .build();
        memberRepository.save(member);

        Author author = Author.builder()
                .name("강띵훈")
                .build();
        authorRepository.save(author);

        Author author1 = Author.builder()
                .name("부대환")
                .build();
        authorRepository.save(author1);

        Book book = Book.builder()
                .bookCategory(BookCategory.SOCIETY)
                .build();
        book.setAuthor(author);
        bookRepository.save(book);

        Rental rental = Rental.builder().build();
        rental.checkOut(book, member);
        rentalRepository.save(rental);

        book.setAuthor(author1);


//        book.rent(member);
    }


}
