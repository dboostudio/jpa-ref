package com.example.jpareference.service;

import com.example.jpareference.entity.Author;
import com.example.jpareference.entity.Book;
import com.example.jpareference.entity.BookCategory;
import com.example.jpareference.repo.AuthorRepository;
import com.example.jpareference.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Transactional
    public Author createAuthor(String name) {
        Author author = Author.builder()
                .name(name)
                .books(new ArrayList<>())
                .build();
        authorRepository.save(author);
        return author;
    }

    @Transactional
    public Author createAuthorAndChangeName(String name) {
        Author author = Author.builder()
                .name(name)
                .books(new ArrayList<>())
                .build();
        authorRepository.save(author);
        author.setName("돈키호테");
        return author;
    }

    @Transactional
    public Long findAuthorAndChangeName(){
        Author author = createAuthorAndChangeName("name2");
        Optional<Author> byId = authorRepository.findById(author.getId());

        byId.get().setName("돈키호테2");
        return byId.get().getId();
    }

    @Transactional
    public Author registerBookToAuthor(){
        Author author = createAuthor("제갈공명");
        Book book1 = Book.builder()
                .bookCategory(BookCategory.SCIENCE)
                .description("제갈공명 전투의 과학적 사실")
                .build();
        Book book2 = Book.builder()
                .bookCategory(BookCategory.SOCIETY)
                .description("제갈공명이 삼국시대에 끼친 영향")
                .build();

        book1.setAuthor(author);
        book2.setAuthor(author);

        bookRepository.saveAll(List.of(book1, book2));
        return author;

    }

}
