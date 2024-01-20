package study.employment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.employment.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

  Board save(Board board);


}
