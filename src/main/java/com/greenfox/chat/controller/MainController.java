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

    @PostMapping("/registeruser")
    public String enter( @ModelAttribute ChatUser user, Model model, HttpServletRequest request) {
        logService.checkEnvironment(request);
        if (user.getUserName().equals("")) {
            model.addAttribute("errorMessage", "Please enter a username!");
            return "redirect:/enter";
        }
        for (ChatUser u : userRepo.findAll()) {
            if (u.getUserName().equals(user.getUserName())) {
                return "redirect:/index";
            }
        }
        return "redirect:/";
    }

    //?userId=" + u.getUserId()

    @PostMapping("/registeruser2")
    public String enterUser( HttpServletRequest request, @RequestParam String userName ) {
        logService.checkEnvironment(request);
        if (userName == null) {

            return "redirect:/enter";
        } else {
            userRepo.save(new ChatUser(userName));
            return "redirect:/index";
        }
    }

    @GetMapping("/index")
    public String index( HttpServletRequest request ) {
        logService.checkEnvironment(request);
        return "index";
    }

    @GetMapping("/enter")
    public String enter( HttpServletRequest request ) {
        logService.checkEnvironment(request);
        return "enter";
    }


}