package com.example.jpareference.service;

import com.example.jpareference.entity.Rental;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RentalServiceTest {

    @Autowired
    private RentalService rentalService;

    @Test
    @DisplayName("책을 빌려보자.")
    void rentBook() throws Exception {
        rentalService.rental();
    }

}