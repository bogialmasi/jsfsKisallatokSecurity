package hu.kisallatokSecurity.controllers;

import hu.kisallatokSecurity.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/")
    public String front(){
        return "index";
    }

    @GetMapping("/pictures")
    public String pics(){
        return "pictures";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/new-owner")
    public String newowner(){
        return "newowner";
    }

    @PostMapping("/new-owner")
    public String newOwner(@RequestParam("ownername") String name,
                           @RequestParam("owneraddress") String address,
                           Model model){
        System.out.println("name: "+name);
        int status = ownerService.newOwner(name, address);
        model.addAttribute("status", status);
        return "admin";
    }
}
