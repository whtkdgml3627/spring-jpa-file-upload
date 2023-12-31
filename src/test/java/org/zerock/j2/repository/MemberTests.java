package org.zerock.j2.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.j2.entity.Member;

import java.util.Optional;

@SpringBootTest
@Log4j2
public class MemberTests {

  @Autowired(required = false)
  private MemberRepository memberRepository;

  @Test
  public void testInsert(){
    Member member = Member.builder()
      .email("whtkdgml3627@naver.com")
      .pw("1111")
      .nickname("SangHee")
      .build();

    memberRepository.save(member);
  }

  @Test
  public void testRead(){
    String email = "user00@gmail.com";

    Optional<Member> result = memberRepository.findById(email);

    Member member = result.orElseThrow();
    log.info(member);
  }
}
