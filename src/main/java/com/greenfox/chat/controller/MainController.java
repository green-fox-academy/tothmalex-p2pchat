package com.greenfox.chat.controller;

import com.greenfox.chat.model.*;
import com.greenfox.chat.repository.ChatRepo;
import com.greenfox.chat.repository.UserRepo;
import com.greenfox.chat.serrvice.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
            model.addAttribute("newUser", new ChatUser());
            model.addAttribute("errorMessage", "Add username pls");
            return "enter";
        } else if (user.getUserName().equals(userRepo.findOne(1L))) {
            model.addAttribute("newUser", new ChatUser());
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
    @CrossOrigin("*")
    public String addMessage(@ModelAttribute Message message, Model model) {
        //message.setUserName(userRepo.findOne(1L).getUserName());
        RestTemplate restTemplate = new RestTemplate();
        Response response = new Response(message, new Client ("Alex"));
        HttpEntity<Response> httpEntity = new HttpEntity<>(response);
        Status s = restTemplate.postForObject("https://safe-tor-47532.herokuapp.com/api/message/receive", httpEntity, Status.class);
        return "redirect:/index";
    }
}