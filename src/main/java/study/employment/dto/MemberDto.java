package study.employment.dto;

import lombok.*;
import study.employment.entity.Member;
import study.employment.entity.MemberInfo;

import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

  private Long id;
  private String username;
  private String password;
  private MemberInfoDto memberInfoDto;
  private MemberDto oldMemberDto;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MemberDto memberDto = (MemberDto) o;
    return Objects.equals(id, memberDto.id) && Objects.equals(username, memberDto.username) && Objects.equals(password, memberDto.password) && Objects.equals(memberInfoDto, memberDto.memberInfoDto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, password, memberInfoDto);
  }

  public Member toEntity(final MemberDto memberDto) {

    return Member.builder()
            .id(memberDto.getId() != null ?
                    memberDto.getId() : null)
            .username(memberDto.getUsername())
            .password(memberDto.getPassword())
            .memberInfo(
                    memberDto.getMemberInfoDto() != null ?
                            MemberInfo.builder()
                                    .email(memberDto.getMemberInfoDto().getEmail())
                                    .age(memberDto.getMemberInfoDto().getAge())
                                    .build() : new MemberInfo()
            )
            .build();
  }

  public void toDto(final Member member) {
    this.id = member.getId();
    this.username = member.getUsername();
    MemberInfoDto memberInfoDto1 = new MemberInfoDto();
    memberInfoDto1.toDto(member.getMemberInfo());
    this.memberInfoDto = memberInfoDto1;
  }
}