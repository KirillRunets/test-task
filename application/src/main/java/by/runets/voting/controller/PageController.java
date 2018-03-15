package by.runets.voting.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String getIndex(){
        return "index";
    }

    @RequestMapping("/user")
    public String getUser(){
        return "user";
    }

    @RequestMapping("/question")
    public String getQuestion(){
        return "question";
    }
}
