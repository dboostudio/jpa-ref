package com.example.jpareference.dto.response;

import com.example.jpareference.entity.Author;
import com.example.jpareference.entity.BookCategory;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {
    private String description;
    private BookCategory bookCategory;
}
