package study.employment;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.employment.entity.Board;
import study.employment.entity.Member;
import study.employment.repository.MemberRepository;

@Component
@RequiredArgsConstructor
public class InitDb {

  private final InitService initService;

  @PostConstruct
  public void init() {
    initService.dbInit1();
  }

  @Component
  @Transactional
  @RequiredArgsConstructor
  static class InitService {
    private final EntityManager em;
    private final MemberRepository memberRepository;

    public void dbInit1() {
      for (int i = 1; i <= 10; i++) {
        em.persist(new Member(String.valueOf(i), String.valueOf(i)));
        em.persist(new Board("title" + i, "content" + i, memberRepository.findById((long) i).orElseThrow(() -> new EntityNotFoundException("자동 실패"))));
//        dasdasd
      }

      em.flush();
      em.clear();
    }
  }
}

