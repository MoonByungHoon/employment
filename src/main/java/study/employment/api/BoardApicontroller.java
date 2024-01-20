package study.employment.api;

import com.querydsl.core.QueryResults;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.employment.dto.BoardDto;
import study.employment.entity.Board;
import study.employment.service.BoardService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardApicontroller {

  private final BoardService boardService;

  @PostMapping("/create/{memberId}")
  public ResponseEntity<?> create(@RequestBody final BoardDto boardDto,
                                  @PathVariable(name = "memberId") final Long memberId) {

    return ResponseEntity.ok().body(boardService.create(boardDto, memberId));
  }

  @GetMapping("/read/{boardId}")
  public ResponseEntity<?> findById(@PathVariable(name = "boardId") final Long boardId) {

    return ResponseEntity.ok().body(boardService.findById(boardId));
  }

  @PutMapping("/update")
  public ResponseEntity<?> updateBoard(@RequestBody final BoardDto boardDto) {

    return ResponseEntity.ok().body(boardService.updateBoard(boardDto));
  }

  @DeleteMapping("/delete/{memberId}")
  public void remove(@RequestBody final BoardDto boardDto, @PathVariable(name = "memberId") final Long memberId) {
    boardService.remove(boardDto, memberId);
  }

  @GetMapping("/all/{offset}/{limit}")
  public ResponseEntity<?> findAll(@PathVariable(name = "offset") final Long offset,
                                   @PathVariable(name = "limit") final Long limit) {
    QueryResults<Board> results = boardService.findAll(offset, limit);

    return ResponseEntity.ok().body(results);
  }
}
