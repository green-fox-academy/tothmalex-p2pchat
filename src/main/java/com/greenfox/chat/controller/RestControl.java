package com.greenfox.chat.controller;

import com.greenfox.chat.model.Message;
import com.greenfox.chat.model.Status;
import com.greenfox.chat.repository.ChatRepo;
import com.greenfox.chat.serrvice.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestControl {

    @Autowired
    ChatRepo chatRepo;

    @PostMapping("/api/message/receive")
    public Object api(@RequestBody Message message ) {

        if (message == null) {
            return new Status("error", "Missing items: ..");

        } else {
            chatRepo.save(message);
            return new Status("ok", "200");
        }
    }
}

