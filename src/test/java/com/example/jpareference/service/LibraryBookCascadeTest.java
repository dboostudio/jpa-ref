package com.example.jpareference.service;

import com.example.jpareference.entity.Author;
import com.example.jpareference.entity.Book;
import com.example.jpareference.entity.BookCategory;
import com.example.jpareference.entity.Library;
import com.example.jpareference.repo.AuthorRepository;
import com.example.jpareference.repo.LibraryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LibraryBookCascadeTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    @Test
    @DisplayName("book을 직접 저장하지 않고 부모 Library에 Set하기만한 상태로 Library를 저장하면 cascade (영속성전이)를 통해 저장된다.")
    void bookLibraryCascasde() throws Exception {
        // given
        Author author = Author.builder()
                .name("작가1").build();

        Book book1 = Book.builder()
                .bookCategory(BookCategory.SOCIETY)
                .description("책1")
                .build();
        Book book2 = Book.builder()
                .bookCategory(BookCategory.SOCIETY)
                .description("책2")
                .build();
        Book book3 = Book.builder()
                .bookCategory(BookCategory.SOCIETY)
                .description("책3")
                .build();
        Book book4 = Book.builder()
                .bookCategory(BookCategory.SOCIETY)
                .description("책4")
                .build();
        Book book5 = Book.builder()
                .bookCategory(BookCategory.SOCIETY)
                .description("책5")
                .build();
        Book book6 = Book.builder()
                .bookCategory(BookCategory.SOCIETY)
                .description("책6")
                .build();
        Book book7 = Book.builder()
                .bookCategory(BookCategory.SOCIETY)
                .description("책7")
                .build();
        List<Book> bookList = List.of(book1, book2, book3, book4, book5, book6, book7);

        authorRepository.save(author);
        author.addBooks(bookList);

        Library library = Library.builder()
                .name("국립중앙도서관")
                .address("주소")
                .build();

        library.setBooks(bookList);
        libraryRepository.save(library);
//        library.addBooks(bookList);


        // when
        // then
    }
}
