package testApp.voting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import testApp.voting.model.Vote;
import testApp.voting.model.Voting;
import testApp.voting.model.VotingAnswer;
import testApp.voting.repository.VotingRepository;
import testApp.voting.service.VotingService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VotingApplicationTests {
    @Autowired
    private VotingService votingService;

    @Autowired
    private VotingRepository votingRepository;

    @Test
    public void contextLoads() {
        Vote vote1 = new Vote("23.03.12");
        Vote vote2 = new Vote("23.03.12");
        Vote vote3 = new Vote("23.03.12");
        Vote vote6 = new Vote("23.03.12");
        Vote vote4 = new Vote("23.03.12");
        Vote vote5 = new Vote("23.03.12");
        List<Vote> voteList1 = Arrays.asList(vote1, vote2, vote3);
        List<Vote> voteList2 = Arrays.asList(vote4, vote5, vote6);
        VotingAnswer votingAnswer1 = new VotingAnswer("otvet1", voteList1);
        VotingAnswer votingAnswer2 = new VotingAnswer("otvet2", voteList2);


        List<VotingAnswer> votingAnswerList = Arrays.asList(votingAnswer1);

        Voting voting = new Voting("evssv", "test", "23.05.12", true, votingAnswerList);

        votingService.createVoting(voting);

        Optional<Voting> testVotingOptional = votingService.getVotingInfo("evssv");
        Voting testVoting = testVotingOptional.get();
        System.out.println("1. " + testVoting.getTopicVote() + " . " +testVoting.getVotingAnswers().toArray().length);
        testVoting.getVotingAnswers().add(votingAnswer2);
        votingService.updateVoting(testVoting);
        System.out.println("2. " + testVoting.getTopicVote() + " . " +testVoting.getVotingAnswers().toArray().length);

    }

}
