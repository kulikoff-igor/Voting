package testApp.voting.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "votingAnswers")
public class Voting {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "hrefVote")
    private String hrefVote;

    @Column(name = "topicVote")
    private String topicVote;

    @Column(name = "creationDateVote")
    private String creationDateVote;

    @Column(name = "statusVote")
    private Boolean statusVote;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<VotingAnswer> votingAnswers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHrefVote() {
        return hrefVote;
    }

    public void setHrefVote(String hrefVote) {
        this.hrefVote = hrefVote;
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
