package testApp.voting.repository;

import testApp.voting.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VotingRepository extends JpaRepository<Voting, Integer> {

    Optional<Voting> findByHrefVote(String hrefVoteVal);
}
