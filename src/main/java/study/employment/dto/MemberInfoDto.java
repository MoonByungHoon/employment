package study.employment.dto;

import lombok.*;
import study.employment.entity.MemberInfo;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberInfoDto {

  private Long userInfoId;
  private int age;
  private String email;

  public void toDto(MemberInfo memberInfo) {
    this.userInfoId = memberInfo.getId();
    this.age = memberInfo.getAge();
    this.email = memberInfo.getEmail();
  }
}
