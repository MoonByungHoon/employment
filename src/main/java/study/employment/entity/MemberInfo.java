package study.employment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import study.employment.dto.MemberDto;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MemberInfo extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "member_info_id")
  private Long id;

  //  유저가 원하면 입력
  private int age;

  //  유저가 원하면 입력
  @Column(length = 100)
  private String email;

  public void changeDate(MemberDto memberDto) {
    this.age = memberDto.getMemberInfoDto().getAge();
    this.email = memberDto.getMemberInfoDto().getEmail();
  }
}
