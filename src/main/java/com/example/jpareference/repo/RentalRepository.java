package com.example.jpareference.repo;

import com.example.jpareference.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RentalRepository extends JpaRepository<Rental, Long> {
}
