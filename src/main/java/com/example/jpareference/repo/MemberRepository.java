package com.example.jpareference.repo;

import com.example.jpareference.entity.Author;
import com.example.jpareference.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
