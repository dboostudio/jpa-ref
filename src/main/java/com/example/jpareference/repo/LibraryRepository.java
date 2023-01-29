package com.example.jpareference.repo;

import com.example.jpareference.entity.Library;
import com.example.jpareference.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}
