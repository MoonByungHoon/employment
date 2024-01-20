package study.employment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import study.employment.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

  boolean existsByUsername(String username);

  boolean existsByUsernameAndPassword(String username, String password);

  Member findByUsername(String username);

  Member findByUsernameAndPassword(String username, String password);
}
