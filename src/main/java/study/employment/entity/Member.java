package study.employment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import study.employment.dto.MemberDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "username", "password"})
public class Member extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "member_id")
  private Long id;

  @NotBlank
  @Column(length = 40, nullable = false, unique = true)
  private String username;

  @NotBlank
  @Column(length = 256, nullable = false)
  private String password;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "member_info_id")
  private MemberInfo memberInfo;

  @OneToMany(mappedBy = "member")
  private List<Board> boards = new ArrayList<>();

  public void addBoard(Board board) {
    boards.add(board);
    board.changeMember(this);
  }

  public Member(String s, String s1) {
    this.username = s;
    this.password = s1;
    this.memberInfo = new MemberInfo();
  }

  public void changeData(final MemberDto memberDto) {
    this.username = memberDto.getUsername();
    this.password = memberDto.getPassword();
    if (memberDto.getMemberInfoDto() != null) {
      this.memberInfo.changeDate(memberDto);
    }
  }
}