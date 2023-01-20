package com.example.jpareference.controller;

import com.example.jpareference.dto.response.AuthorDto;
import com.example.jpareference.entity.Author;
import com.example.jpareference.entity.Book;
import com.example.jpareference.service.AuthorServiceExample;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorServiceExample authorServiceExample;

    @GetMapping("/author/{id}")
    public AuthorDto getAuthor(@PathVariable Long id){
        Author author = authorServiceExample.registerBookToAuthor();
        AuthorDto authorDto = AuthorDto.builder()
                .name(author.getName())
                .build();
        authorDto.setBooks(author.getBooks().stream().map(Book::toDto).toList());
        return authorDto;
    }
}
