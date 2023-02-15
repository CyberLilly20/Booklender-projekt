package se.lexicon.G4.Booklender.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.G4.Booklender.model.entity.Loan;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {
    @Query("select l from Loan l inner join l.loanTaker b where b.userId =:t")
    Optional<Loan> findByLoanTakerUserId(@Param("t") int userId);

    @Query("select l from Loan l inner join l.book b where b.bookId = :b")
    Optional<Loan> findByBookBookId(@Param("b") int bookId);

    List<Loan> findByTerminated(boolean terminated);

    List<Loan> findAllByBook_BookId(int bookId);

    List<Loan> findAllByLoanTaker_UserId(int userId);
}