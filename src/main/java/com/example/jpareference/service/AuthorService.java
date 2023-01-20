package com.example.jpareference.service;

import com.example.jpareference.entity.Author;
import com.example.jpareference.repo.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    @Autowired
    AuthorRepository authorRepositorty;

    @Transactional
    public Long createAuthorAndChangeName(String name) {
        Author author = Author.builder()
                .name(name)
                .books(new ArrayList<>())
                .build();
        authorRepositorty.save(author);
        author.setName("돈키호테");
        return author.getId();
    }

    @Transactional
    public Long findAuthorAndChangeName(){
        Long authorAndChangeName = createAuthorAndChangeName("name2");
        Optional<Author> byId = authorRepositorty.findById(authorAndChangeName);

        byId.get().setName("돈키호테2");
        return byId.get().getId();
    }

}
