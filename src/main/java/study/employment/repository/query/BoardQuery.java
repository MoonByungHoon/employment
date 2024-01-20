package study.employment.repository.query;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import study.employment.entity.Board;

import static study.employment.entity.QBoard.board;

@RequiredArgsConstructor
public class BoardQuery {

  private final EntityManager em;
  private JPAQueryFactory queryFactory;

  public QueryResults<Board> findAll(final Long offset, final Long limit) {
    queryFactory = new JPAQueryFactory(em);

    QueryResults<Board> results = queryFactory
            .selectFrom(board)
            .orderBy(board.id.desc())
            .offset(offset)
            .limit(limit)
            .fetchResults();
    return results;
  }
}
