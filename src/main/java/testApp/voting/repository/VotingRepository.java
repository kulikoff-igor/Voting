package testApp.voting.repository;

import testApp.voting.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotingRepository extends JpaRepository<Voting, Integer> {

}
