package study.employment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmploymentApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmploymentApplication.class, args);
  }

}
