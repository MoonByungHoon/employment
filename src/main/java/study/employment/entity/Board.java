package study.employment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.employment.dto.BoardDto;
import study.employment.dto.MemberDto;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "board_id")
  private Long id;

  @Column(nullable = false, length = 100)
  private String title;

  @Column(nullable = false, length = 300)
  private String content;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  public Board(String s, String s1, Member byId) {
    this.title = s;
    this.content = s1;
    this.member = byId;
  }

  public void changeMember(final Member member) {
    this.member = member;
  }

  public void changeData(final BoardDto boardDto) {
    this.title = boardDto.getTitle();
    this.content = boardDto.getContent();
    if (boardDto.getMemberDto() == null) {
      boardDto.setMemberDto(new MemberDto());
    }
    this.member = boardDto.getMemberDto().toEntity(boardDto.getMemberDto());
  }
}
