package com.example.jpareference.service;

import com.example.jpareference.entity.Member;
import com.example.jpareference.entity.RoleType;
import com.example.jpareference.repo.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long saveMember(){
        Member member = new Member();
        member.setFirstName("대환");
        member.setLastName("부");
        member.setRoleType(RoleType.MEMBER);

        Member save = memberRepository.save(member);
        return save.getId();
    }
}
