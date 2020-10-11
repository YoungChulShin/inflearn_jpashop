package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    public void 회원가입 () throws Exception {
        // given
        Member member = new Member();
        member.setName("Shin");

        // when
        Long savedId = memberService.join(member);

        // then

        Member findMember = memberRepository.findOne(savedId);
        assertEquals(member, findMember);
    }

    @Test
    public void 중복_회원_예외 () throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("shin1");

        Member member2 = new Member();
        member2.setName("shin1");

        // when
        memberService.join(member1);

        // then
        Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }
}