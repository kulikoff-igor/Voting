package testApp.voting.service;

import testApp.voting.model.Voting;

import java.util.List;
import java.util.Optional;

public interface VotingService {
    Voting createVoting(Voting voting);

    List<Voting> getVotings();

    Voting updateVoting(Voting voting);

    Optional<Voting> getVotingByHref(String hrefVotingVal);
}
