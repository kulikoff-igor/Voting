package testApp.voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testApp.voting.model.Voting;
import testApp.voting.repository.VotingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VotingServiceImpl implements VotingService {

    @Autowired
    private VotingRepository votingRepository;

    @Override
    public Voting createVoting(Voting voting) {
        return votingRepository.saveAndFlush(voting);
    }

    @Override
    public List<Voting> getVotings() {
        return votingRepository.findAll();
    }

    @Override
    public Voting updateVoting(Voting voting) {
        return votingRepository.saveAndFlush(voting);
    }

    @Override
    public Optional<Voting> getVotingByHref(String hrefVoteVal) {
        return votingRepository.findByHrefVoting(hrefVoteVal);
    }
}
