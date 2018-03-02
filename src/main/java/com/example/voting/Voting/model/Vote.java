package com.example.voting.Voting.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vote")
public class Vote {
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

    @OneToMany(cascade = CascadeType.ALL)
    private List<VotingAnswerOption> votingAnswerOption = new ArrayList<>();

    @Column(name = "statusVote")
    private Boolean statusVote;


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

    public List<VotingAnswerOption> getVotingAnswerOption() {
        return votingAnswerOption;
    }

    public void setVotingAnswerOption(List<VotingAnswerOption> votingAnswerOption) {
        this.votingAnswerOption = votingAnswerOption;
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
