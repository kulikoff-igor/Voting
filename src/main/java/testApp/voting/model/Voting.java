package testApp.voting.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "voting")
public class Voting {

    public Voting() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "hrefVoting")
    private String hrefVoting;

    @Column(name = "topicVote")
    private String topicVote;

    @Column(name = "creationDateVote")
    private String creationDateVote;

    @Column(name = "statusVote")
    private Boolean statusVote;

    @OneToMany(cascade = CascadeType.ALL)
    private List<VotingAnswer> votingAnswers;

    public Voting(String hrefVoting, String topicVote, String creationDateVote, Boolean statusVote, List<VotingAnswer> votingAnswers) {
        this.hrefVoting = hrefVoting;
        this.topicVote = topicVote;
        this.creationDateVote = creationDateVote;
        this.statusVote = statusVote;
        this.votingAnswers = votingAnswers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHrefVoting() {
        return hrefVoting;
    }

    public void setHrefVoting(String hrefVoting) {
        this.hrefVoting = hrefVoting;
    }

    public String getTopicVote() {
        return topicVote;
    }

    public void setTopicVote(String topicVote) {
        this.topicVote = topicVote;
    }

    public String getCreationDateVote() {
        return creationDateVote;
    }

    public List<VotingAnswer> getVotingAnswers() {
        return votingAnswers;
    }

    public void setVotingAnswers(List<VotingAnswer> votingAnswers) {
        this.votingAnswers = votingAnswers;
    }

    public void setCreationDateVote(String creationDateVote) {
        this.creationDateVote = creationDateVote;
    }

    public Boolean getStatusVote() {
        return statusVote;
    }

    public void setStatusVote(Boolean statusVote) {
        this.statusVote = statusVote;
    }

}
