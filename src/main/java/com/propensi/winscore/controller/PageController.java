package com.propensi.winscore.controller;

import com.propensi.winscore.model.UserModel;
import com.propensi.winscore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class PageController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    private String home(Model model) {
        model.addAttribute("home", true);
        return "landing-page";
    }

    @RequestMapping("/login")
    public String login() {
        return "Login";
    }

    @PostMapping("/register")
    public String register(@RequestBody UserModel userModel) {
        return "Register";
    }

    @RequestMapping("/admin-register")
    public String registerAdmin() {
        return "Ree";
    }

    @RequestMapping("/admin")
    public String admin(Model model){
        model.addAttribute("home", true);
        return "home";
    }
    @RequestMapping("/user")
    public String staff(Model model){
        model.addAttribute("home", true);
        return "home";
    }
}
