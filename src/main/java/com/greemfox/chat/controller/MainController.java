package com.greenfox.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {

    @GetMapping({"", "/"})
    public String openingMain(  ) {
        return "index";
    }

    @GetMapping("/enter")
    public String add(Model model){
        model.addAttribute("message", new User());
        return "enter";
    }
}