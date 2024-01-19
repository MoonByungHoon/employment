package study.employment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import study.employment.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
