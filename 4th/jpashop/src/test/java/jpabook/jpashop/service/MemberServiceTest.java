package jpabook.jpashop.service;

import static org.junit.Assert.*;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

  @Autowired
  MemberRepository memberRepository;

  @Autowired
  MemberService memberService;

  @Test
  public void 회읜가입() {
    // given
    Member member = new Member();
    member.setName("youngchul");

    // when
    Long savedId = memberService.join(member);

    // then
    assertEquals(member, memberRepository.findOne(savedId));
  }

}