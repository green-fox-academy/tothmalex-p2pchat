package com.greenfox.chat.controller;

import com.greenfox.chat.model.ChatUser;
import com.greenfox.chat.repository.UserRepo;
import com.greenfox.chat.serrvice.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class MainController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    LogService logService;

    long id = 1;

    @PostMapping("/registeruser")
    public String enter( @ModelAttribute ChatUser user, Model model, HttpServletRequest request) {
        logService.checkEnvironment(request);
        if (user.getUserName().equals("")) {
            model.addAttribute("errorMessage", "Add username pls");
            return "enter";
        } else if (user.getUserName().equals(userRepo.findOne(id).getUserName())) {
            model.addAttribute("errorMessage","This name is already occupied");
            return "enter";
        }
        userRepo.save(user);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index( HttpServletRequest request ) {
        logService.checkEnvironment(request);
        return "index";
    }

    @GetMapping("/enter")
    public String enter( Model model, HttpServletRequest request ) {
        logService.checkEnvironment(request);
        model.addAttribute("newUser", new ChatUser());
        return "enter";
    }
}