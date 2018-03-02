package com.example.voting.Voting.repository;

import com.example.voting.Voting.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotingRepository extends JpaRepository<Vote, Integer> {

}
