package com.example.jpareference.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RentalCreateDto {
    private Long memberId;
    private Long bookId;
}
