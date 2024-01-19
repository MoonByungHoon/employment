package study.employment.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.employment.entity.User;

@Getter @Setter
@NoArgsConstructor
public class UserTotalDto {

  private Long id;
  private String username;
  private String password;
  private int age;
  private String email;
  private Long userInfoId;

  public UserTotalDto(String username, String password, int age, String email) {
    this.username = username;
    this.password = password;
    this.age = age;
    this.email = email;
  }
}
