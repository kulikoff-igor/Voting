package com.example.voting.Voting.controller;

import org.springframework.web.bind.annotation.*;


/**
 * Created by admin on 01.03.2018.
 */
@RestController
public class AddVotingController {

    public AddVotingController() {
    }

    @RequestMapping(value = "/addVoting", method = RequestMethod.POST)
    public String addVoting(@RequestParam String voting) {

        String test= "the data on the server";
        System.out.println(voting.toString());

        return test;
    }
}
