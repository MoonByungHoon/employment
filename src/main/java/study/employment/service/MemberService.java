package study.employment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.employment.dto.MemberDto;
import study.employment.entity.Member;
import study.employment.repository.MemberRepository;
import study.employment.validate.DataValidate;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  private DataValidate validate;

  @Transactional
  public MemberDto signUp(final MemberDto memberDto) {
    if (!memberRepository.existsByUsername(memberDto.getUsername())) {
      memberRepository.save(memberDto.toEntity(memberDto));

      return memberDto;
    } else {
      throw new IllegalStateException("중복 회원입니다.");
    }
  }

  public Member signIn(final MemberDto memberDto) {

    if (memberRepository.existsByUsernameAndPassword(memberDto.getUsername(), memberDto.getPassword())) {
      return memberRepository.findByUsername(memberDto.getUsername());
    } else {
      throw new NoSuchElementException("아이디 혹은 비밀번호가 틀렸습니다.");
    }
  }

  public Member findById(final Long id) {

    return memberRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("찾으시는 아이디가 없습니다."));
  }

  public List<Member> findAll() {
    return memberRepository.findAll();
  }

  @Transactional
  public void remove(final MemberDto memberDto) {
    Member findUser = memberRepository.findByUsernameAndPassword(memberDto.getUsername(), memberDto.getPassword());

    memberRepository.deleteById(findUser.getId());
  }

  @Transactional
  public MemberDto update(final MemberDto memberDto) {

    if (memberRepository.existsByUsernameAndPassword(memberDto.getOldMemberDto().getUsername(), memberDto.getOldMemberDto().getPassword())) {
      Member findMember = memberRepository.findByUsernameAndPassword(memberDto.getOldMemberDto().getUsername(), memberDto.getOldMemberDto().getPassword());

      findMember.changeData(memberDto);

      memberDto.toDto(findMember);

      memberDto.setOldMemberDto(null);
      memberDto.setPassword("");

      return memberDto;
    } else {
      throw new NoSuchElementException("비밀번호를 잘못 입력하였습니다.");
    }
  }
}
