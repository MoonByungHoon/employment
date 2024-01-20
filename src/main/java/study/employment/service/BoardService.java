package study.employment.service;

import com.querydsl.core.QueryResults;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.employment.dto.BoardDto;
import study.employment.dto.MemberDto;
import study.employment.entity.Board;
import study.employment.entity.Member;
import study.employment.repository.BoardRepository;
import study.employment.repository.MemberRepository;
import study.employment.repository.query.BoardQuery;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

  private final EntityManager em;
  private final BoardRepository boardRepository;
  private final MemberRepository memberRepository;

  @Transactional
  public Board create(final BoardDto boardDto, final Long memberId) {
    if (memberRepository.existsById(memberId)) {
      Member findMember = memberRepository.findById(memberId)
              .orElseThrow(() -> new EntityNotFoundException("가입되어있는 회원이 아닙니다."));

      MemberDto memberDto = new MemberDto();
      memberDto.toDto(findMember);

      boardDto.setMemberDto(memberDto);
      boardDto.setWriter(findMember.getUsername());

      Board board = new Board();
      board.changeData(boardDto);

      return boardRepository.save(board);
    } else {
      throw new EntityNotFoundException("가입되어있는 회원이 아닙니다.");
    }
  }

  public Board findById(final Long boardId) {
    return boardRepository.findById(boardId)
            .orElseThrow(() -> new EntityNotFoundException("해당 글이 없습니다."));
  }


  @Transactional
  public Board updateBoard(final BoardDto boardDto) {
    Board findBoard = boardRepository.findById(boardDto.getId())
            .orElseThrow(() -> new EntityNotFoundException("해당 글이 없습니다."));
    String findUsername = memberRepository.findById(boardDto.getMemberDto().getId()).orElseThrow(() -> new EntityNotFoundException("가입한 회원이 아닙니다.")).getUsername();
    if (boardDto.getWriter().equals(findUsername)) {
      findBoard.changeData(boardDto);

      boardRepository.save(findBoard);

      return findBoard;
    } else {
      throw new EntityNotFoundException("작성자가 다릅니다.");
    }
  }

  @Transactional
  public void remove(final BoardDto boardDto, final Long memberId) {

    String findUsername = memberRepository.findById(memberId)
            .orElseThrow(() -> new EntityNotFoundException("가입된 회원이 아닙니다.")).getUsername();


    if (boardDto.getWriter().equals(findUsername)) {
      boardRepository.deleteById(boardDto.getId());
    }
  }

  public QueryResults<Board> findAll(final Long offset, final Long limit) {
    BoardQuery boardQuery = new BoardQuery(em);

    return boardQuery.findAll(offset, limit);
  }
}
