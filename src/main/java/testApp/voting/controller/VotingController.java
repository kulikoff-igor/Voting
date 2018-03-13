package testApp.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import testApp.voting.model.Vote;
import testApp.voting.model.Voting;
import testApp.voting.service.VotingService;

import java.util.List;
import java.util.Optional;


/**
 * Created by admin on 01.03.2018.
 */
@RestController
@RequestMapping("/api/voting")
public class VotingController {
    @Autowired
    private VotingService votingService;

    public VotingController(VotingService votingService) {
        this.votingService = votingService;
    }

    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Voting createVoting(@RequestBody Voting voting) {
       System.out.println(voting.getTopicVote());
        return votingService.createVoting(voting);
    }

    @PutMapping("/start/{href}")
    public Voting startVoting(@PathVariable String href) {
        Voting voting = votingService.getVotingByHref(href).get();
        voting.setStatusVote(true);
        return votingService.updateVoting(voting);
    }

    @PutMapping("/stop/{href}")
    public Voting stopVoting(@PathVariable String href) {
        Voting voting = votingService.getVotingByHref(href).get();
        voting.setStatusVote(false);
        return votingService.updateVoting(voting);
    }

    @GetMapping("/get/{href}")
    public Optional<Voting> getVotingByHref(@PathVariable String href) {
        return votingService.getVotingByHref(href);
    }

    @GetMapping("/")
    public List<Voting> getVoting() {
        return votingService.getVotings();
    }

    @PutMapping("/vote/{href}/{votingAnswerId}")
    public void castVote(@PathVariable Integer votingAnswerId, @RequestBody Vote vote, @PathVariable String href) {
        Voting voting = votingService.getVotingByHref(href).get();
        voting.getVotingAnswers().get(votingAnswerId).addVote(vote);
        votingService.updateVoting(voting);
    }

}
