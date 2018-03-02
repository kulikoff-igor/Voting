package com.example.voting.Voting.model;

import javax.persistence.*;

@Entity
@Table(name = "votingAnswerOption")
public class VotingAnswerOption {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "votingAnswer")
    private String votingAnswer;

    @Column(name = "countResponses")
    private String countResponses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVotingAnswer() {
        return votingAnswer;
    }

    public void setVotingAnswer(String votingAnswer) {
        this.votingAnswer = votingAnswer;
    }

    public String getCountResponses() {
        return countResponses;
    }

    public void setCountResponses(String countResponses) {
        this.countResponses = countResponses;
    }

}
