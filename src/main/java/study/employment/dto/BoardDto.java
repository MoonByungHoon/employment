package study.employment.dto;

import lombok.*;
import study.employment.entity.BaseEntity;
import study.employment.entity.Board;
import study.employment.entity.Member;

import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto extends BaseEntity {

  private Long id;
  private String title;
  private String content;
  private String writer;
  private MemberDto memberDto;

  public Board toEntity(final BoardDto boardDto) {
    return Board.builder()
            .title(boardDto.getTitle())
            .content(boardDto.getContent())
            .member(
                    boardDto.getMemberDto().getId() != null ?
                            boardDto.getMemberDto().toEntity(memberDto) : new Member()
            )
            .build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BoardDto boardDto = (BoardDto) o;
    return Objects.equals(id, boardDto.id) && Objects.equals(title, boardDto.title) && Objects.equals(content, boardDto.content) && Objects.equals(writer, boardDto.writer) && Objects.equals(memberDto, boardDto.memberDto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, content, writer, memberDto);
  }
}
