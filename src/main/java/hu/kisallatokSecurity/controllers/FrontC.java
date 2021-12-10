package hu.kisallatokSecurity.controllers;

import hu.kisallatokSecurity.domain.Owner;
import hu.kisallatokSecurity.services.OService.OService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class FrontC {
    @Autowired
    private OService oService;
    @GetMapping("/")
    public String front(){
        return "index";
    }
    @GetMapping("/pictures")
    public String pictures(){
        return "pictures";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    @GetMapping("/newowner")
    public String newOwner(){return "newowner";}
    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public String addOwner(@RequestParam("oname") String name, @RequestParam("oaddress") String address, Model model){
        int statusCode = oService.newOwner(name, address);
        model.addAttribute("status", statusCode);
        return "admin";
    }
}
