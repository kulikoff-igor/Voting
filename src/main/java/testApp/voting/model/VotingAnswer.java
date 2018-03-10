package testApp.voting.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "votingAnswer")
public class VotingAnswer {
    public VotingAnswer() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "voteText")
    private String voteText;

    public VotingAnswer(String voteText, List<Vote> vote) {
        this.voteText = voteText;
        this.vote = vote;
    }

    public List<Vote> getVote() {
        return vote;
    }

    public void setVote(List<Vote> vote) {
        this.vote = vote;
    }

    @OneToMany(cascade = CascadeType.ALL)
    //@OneToMany(targetEntity = Vote.class, mappedBy = "votingAnswer", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Vote> vote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoteText() {
        return voteText;
    }

    public void setVoteText(String voteText) {
        this.voteText = voteText;
    }


}
