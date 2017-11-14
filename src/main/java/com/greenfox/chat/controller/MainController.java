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

    @Autowired
    ChatRepo chatRepo;

    @Autowired
    LogService logService;

    @PostMapping("/registeruser")
    public String enter( @ModelAttribute ChatUser user, Model model, HttpServletRequest request) {
        logService.checkEnvironment(request);
        if (user.getUserName().equals("")) {
            model.addAttribute("errorMessage", "Add username pls");
            return "enter";
        } else if (user.getUserName().equals(userRepo.findOne(1L))) {
            model.addAttribute("errorMessage","This name is already occupied");
            return "enter";
        }
        userRepo.save(user);
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String getHomepage(Model model, HttpServletRequest request) {
        logService.checkEnvironment(request);
        model.addAttribute("user", userRepo.findOne(1L ));
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

    @PostMapping("/updateUserName")
    public String updateUsername(@ModelAttribute ChatUser user, HttpServletRequest request) {
        logService.checkEnvironment(request);
        userRepo.save(user);
        return "redirect:/index";
    }

    @PostMapping("/addMessage")
    public String addMessage(@ModelAttribute Message message, Model model) {
        message.setUsername(userRepo.findOne(1L).getUserName());
        chatRepo.save(message);
        return "redirect:/index";
    }
}