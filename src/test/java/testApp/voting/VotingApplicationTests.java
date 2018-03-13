package testApp.voting;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import testApp.voting.controller.VotingController;
import testApp.voting.model.Vote;
import testApp.voting.model.Voting;
import testApp.voting.model.VotingAnswer;
import testApp.voting.repository.VotingRepository;
import testApp.voting.service.VotingService;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VotingApplication.class)
public class VotingApplicationTests {

    private static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private VotingService votingService;

    @Autowired
    private VotingRepository votingRepository;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    private MockMvc restVotingMockMvc;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        VotingController votingController = new VotingController(votingService);

        this.restVotingMockMvc = MockMvcBuilders.standaloneSetup(votingController)
                .setCustomArgumentResolvers(pageableArgumentResolver)
                .setMessageConverters(jacksonMessageConverter)
                .build();
    }


    @Test
    public void contextLoads() throws Exception {
        Vote vote1 = new Vote("23.03.12");
        Vote vote2 = new Vote("23.03.12");
        Vote vote3 = new Vote("23.03.12");
        Vote vote6 = new Vote("23.03.12");
        Vote vote4 = new Vote("23.03.12");
        Vote vote5 = new Vote("23.03.12");
        List<Vote> voteList1 = Arrays.asList(vote1, vote2);
        List<Vote> voteList2 = Arrays.asList(vote4, vote5, vote6);
        VotingAnswer votingAnswer1 = new VotingAnswer("otvet1", voteList1);
        VotingAnswer votingAnswer2 = new VotingAnswer("otvet2", voteList2);


        List<VotingAnswer> votingAnswerList = Arrays.asList(votingAnswer1);

        Voting voting = new Voting("evssv", "test", "23.05.12", true, votingAnswerList);

        /*votingService.createVoting(voting);
        Optional<Voting> testVotingOptional = votingService.getVotingByHref("evssv");
        Voting testVoting = testVotingOptional.get();
        System.out.println("1. " + testVoting.getTopicVote() + " . " + testVoting.getVotingAnswers().toArray().length);
        testVoting.getVotingAnswers().add(votingAnswer2);
        votingService.updateVoting(testVoting);
        List<Vote> testVotingOptional1 = votingService.getListVoteVotingAnswer("evssv", 1);
        Vote testVoting1 = testVotingOptional1.get(2);
        System.out.println("2. " + testVotingOptional1.size() + " . ");*/

        restVotingMockMvc.perform(post("/api/voting/")
                .contentType(APPLICATION_JSON_UTF8)
                .content(json(voting)));


    }
    @SuppressWarnings("unchecked")
    private String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.jacksonMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}


