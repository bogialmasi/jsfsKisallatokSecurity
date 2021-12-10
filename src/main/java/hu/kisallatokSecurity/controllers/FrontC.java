package hu.kisallatokSecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontC {
    @GetMapping("/")
    public String front(){
        return "index";
    }
    @GetMapping("/pictures")
    public String pictures(){
        return "pictures";
    }
}
