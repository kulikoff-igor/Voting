package testApp.voting.repository;

import org.springframework.data.jpa.repository.Query;
import testApp.voting.model.Vote;
import testApp.voting.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VotingRepository extends JpaRepository<Voting, Integer> {

    Optional<Voting> findByHrefVoting(String hrefVotingVal);

    @Query(countQuery = "SELECT\n" +
            "  dishescomposition.amount\n" +
            "FROM menu\n" +
            "  INNER JOIN dish\n" +
            "    ON menu.idDish = dish.id\n" +
            "  INNER JOIN dishescomposition\n" +
            "    ON dishescomposition.idDish = dish.id")
    List<Vote> findById(Integer idVal);

}
