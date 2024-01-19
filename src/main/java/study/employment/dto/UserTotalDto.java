package study.employment.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserTotalDto {

  private Long id;
  private String username;
  private String password;
  private int age;
  private String email;
  private Long userInfoId;
}
