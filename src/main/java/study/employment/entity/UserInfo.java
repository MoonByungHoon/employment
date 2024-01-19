package study.employment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class UserInfo {

  @Id @GeneratedValue
  @Column(name = "user_info_id")
  private Long id;

//  유저가 원하면 입력
  private int age;

//  유저가 원하면 입력
  @Column(length = 100, nullable = false)
  private String email;

  public UserInfo(int age, String email) {
    this.age = age;
    this.email = email;
  }
}
