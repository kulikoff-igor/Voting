package com.example.voting.Voting.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping("/")
    public ModelAndView index() {
        System.out.println("++++");
       return new ModelAndView("index");
    }
}

