package com.example.jpareference.service;

import com.example.jpareference.entity.Member;
import com.example.jpareference.repo.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("property엑세스를 통해 컬럼저장")
    void savePropertyByPropertyAccessGetter() throws Exception {
        // given
        Long id = memberService.saveMember();
        Member member = memberRepository.findById(id).get();
        System.out.println(member);
        // when
        // then
    }

}