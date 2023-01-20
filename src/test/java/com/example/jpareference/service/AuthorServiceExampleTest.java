package com.example.jpareference.service;

import com.example.jpareference.entity.Author;
import com.example.jpareference.entity.Book;
import com.example.jpareference.repo.AuthorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class AuthorServiceExampleTest {

    @Autowired
    AuthorServiceExample authorService;

    @Autowired
    AuthorRepository authorRepository;

    @Test
    @DisplayName("변경감지 테스트 - 저장 후 set")
    void saveAndchangeAwareness() throws Exception {
        // given
        // when
        Author author = authorService.createAuthorAndChangeName("name!");
        // then
        Optional<Author> byId = authorRepository.findById(author.getId());
        System.out.println(byId.get());
        byId.get().getName().equals("돈키호테");
    }

    @Test
    @DisplayName("변경감지 테스트 - 조회 후 set")
    void findAndchangeAwareness() throws Exception {
        // given
        // when
        Long authorId = authorService.findAuthorAndChangeName();
        // then
        Optional<Author> byId = authorRepository.findById(authorId);
        System.out.println(byId.get());
        byId.get().getName().equals("돈키호테2");
    }

    @Test
    @DisplayName("저자에 책 등록하기")
    void registerBookToAuthor() throws Exception {
        // given
        Author author = authorService.registerBookToAuthor();
        List<Book> books = author.getBooks();
        System.out.println(books);

        // when
        // then
    }
    @Test
    @DisplayName("책의 저자 변경하기")
    void testSetAuthor() throws Exception {
        // given
        List<Author> authors = authorService.testSetAuthor();
        System.out.println(authors.get(0).getName());
        System.out.println(authors.get(0).getBooks());
        System.out.println(authors.get(1).getName());
        System.out.println(authors.get(1).getBooks());

        // when
        // then
    }

    @Test
    @DisplayName("저자에 책 등록하기")
    void testAddBook() throws Exception {
        // given
        List<Author> authors = authorService.testAddBook();
        System.out.println(authors.get(0).getName());
        System.out.println(authors.get(0).getBooks());
        System.out.println(authors.get(1).getName());
        System.out.println(authors.get(1).getBooks());

        // when
        // then
    }

}