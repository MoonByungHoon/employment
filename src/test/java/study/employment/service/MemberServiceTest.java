package study.employment.service;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.employment.dto.MemberDto;
import study.employment.dto.MemberInfoDto;
import study.employment.repository.MemberRepository;

@SpringBootTest
@Transactional
class MemberServiceTest<T> {

  @Autowired
  private EntityManager em;

  @Autowired
  private MemberRepository memberRepository;

  @Autowired
  private MemberService memberService;

  @Test
  public void update() {
    MemberDto memberDto = new MemberDto();
    memberDto.setUsername("1234");
    memberDto.setPassword("1234");

    MemberDto memberDto2 = new MemberDto();
    memberDto2.setUsername("12341234");
    memberDto2.setPassword("12341234");

    MemberInfoDto memberInfoDto = new MemberInfoDto();

    memberInfoDto.setAge(1);
    memberInfoDto.setEmail("10");

    memberDto2.setMemberInfoDto(memberInfoDto);

    em.persist(memberDto.toEntity(memberDto));

    em.flush();
    em.clear();

//    MemberDto update = userService.update(memberDto, p);

//    System.out.println(update.getUsername());

  }
}