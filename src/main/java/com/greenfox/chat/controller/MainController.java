package com.greenfox.chat.controller;

import com.greenfox.chat.model.ChatUser;
import com.greenfox.chat.model.Message;
import com.greenfox.chat.repository.ChatRepo;
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
    ChatRepo chatRepo;

    @Autowired
    LogService logService;



    long id = 1;

    @PostMapping("/registeruser")
    public String enter( @ModelAttribute ChatUser user, Model model, HttpServletRequest request) {
        logService.checkEnvironment(request);
        if (user.getUserName().equals("")) {
            model.addAttribute("errorMessage", "Add username pls");
            return "enter";
        } else if (user.getUserName().equals(userRepo.findAll())) {
            model.addAttribute("errorMessage","This name is already occupied");
            return "enter";
        }
        userRepo.save(user);
        return "redirect:/index";
    }

    @RequestMapping("/")
    public String getHomepage(Model model, HttpServletRequest request) {
        logService.checkEnvironment(request);
        model.addAttribute("user", userRepo.findAll());
        model.addAttribute("newMessage", new Message());
        model.addAttribute("messages", chatRepo.findAll());
        return "index";
    }

    @GetMapping("/enter")
    public String enter( Model model, HttpServletRequest request ) {
        logService.checkEnvironment(request);
        model.addAttribute("newUser", new ChatUser());
        return "enter";
    }
}