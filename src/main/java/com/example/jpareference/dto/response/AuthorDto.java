package com.example.jpareference.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AuthorDto {
    private String name;
    private List<BookDto> books;
}
