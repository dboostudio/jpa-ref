package com.example.jpareference.service;

import com.example.jpareference.entity.Author;
import com.example.jpareference.repo.AuthorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class AuthorServiceTest {

    @Autowired
    AuthorService authorService;

    @Autowired
    AuthorRepository authorRepository;

    @Test
    @DisplayName("변경감지 테스트 - 저장 후 set")
    void saveAndchangeAwareness() throws Exception {
        // given
        // when
        Long authorId = authorService.createAuthorAndChangeName("name!");
        // then
        Optional<Author> byId = authorRepository.findById(authorId);
        System.out.println(byId.get());
//        byId.get().getName().equals("돈키호테");
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

}