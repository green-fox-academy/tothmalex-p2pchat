package com.greenfox.chat.controller;

import com.greenfox.chat.model.ChatUser;
import com.greenfox.chat.repository.UserRepo;
import com.greenfox.chat.serrvice.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class MainController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    LogService logService;

    @GetMapping("/index")
    public String index( HttpServletRequest request, Exception exception) {
        logService.checkEnvironment(request);
        return "index";
    }

    @GetMapping("/enter")
    public String enter(HttpServletRequest request, Exception exception) {
        logService.checkEnvironment(request);
        return "enter";
    }

    @PostMapping("/registeruser")
    public String enterUser(HttpServletRequest request, Exception exception, @RequestParam String userName) {
        logService.checkEnvironment(request);
        userRepo.save(new ChatUser(userName));
        return "redirect:/index";
    }
}