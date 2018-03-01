package com.example.voting.Voting.Controller;

import org.springframework.stereotype.Controller;
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

        String test= "test";
        System.out.println(voting.toString());

        return test;
    }
}
