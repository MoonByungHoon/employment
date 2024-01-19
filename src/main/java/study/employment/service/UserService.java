package study.employment.service;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.employment.entity.User;
import study.employment.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

  @Autowired
  private final EntityManager em;
  private final UserRepository userRepository;

  public void signUp (final User user) throws NullPointerException, IllegalStateException{

  }
}
