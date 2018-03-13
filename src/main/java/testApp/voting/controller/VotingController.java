package testApp.voting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import testApp.voting.model.Voting;

import java.util.List;


/**
 * Created by admin on 01.03.2018.
 */
@RestController
@RequestMapping("/api/voting")
public class VotingController {

    public VotingController() {

    }
    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<Voting> createVoting(@RequestBody Voting voting) {
        return null;
    }
    @PutMapping("/start/{href}")
    public List<Voting> startVoting(@PathVariable String href) {
        return null;
    }
    @PutMapping("/stop/{href}")
    public List<Voting> stopVoting( @PathVariable String href) {
        return null;
    }
    @GetMapping("/get/{href}")
    public Voting getVotingByHref(@PathVariable String href) {
        return null;
    }
    @GetMapping("/")
    public List<Voting> getVoting() {
        return null;
    }
    @PutMapping("/vote/href/{votingAnswer}/{vote}")
    public List<Voting> castVote(@PathVariable String  votingAnswer, @PathVariable String vote) {
        return null;
    }

}
