package com.greenfox.chat.controller;

import com.greenfox.chat.model.Message;
import com.greenfox.chat.repository.ChatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chat")
public class MainController {

    @Autowired
    ChatRepo chatRepo;

    @GetMapping({"/"})
    public String openingMain(  ) {
        return "index";
    }

   /* @GetMapping("/message")
    public Message list( @RequestParam("messag") String message){
        Message mess = new Message(message);
        chatRepo.save(mess);
        return mess;
    }
*/
    /*@PostMapping({"/","list"})
    public String save(@ModelAttribute Post post){
        postRepo.save(post);
        return "redirect:/posts";
    }*/
}