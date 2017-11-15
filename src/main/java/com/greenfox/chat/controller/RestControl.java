package com.greenfox.chat.controller;

import com.greenfox.chat.model.Message;
import com.greenfox.chat.model.Response;
import com.greenfox.chat.model.Status;
import com.greenfox.chat.repository.ChatRepo;
import com.greenfox.chat.repository.UserRepo;
import com.greenfox.chat.serrvice.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestControl {

    @Autowired
    ChatRepo chatRepo;

    @Autowired
    UserRepo userRepo;

    @PostMapping("/api/message/receive")
    @ResponseBody
    public Status api( @RequestBody Response response) {

        if (response.getMessage() == null) {
                return new Status("Missing fields ", HttpStatus.BAD_REQUEST);
        } else {
            chatRepo.save(response.getMessage());
            return new Status(HttpStatus.OK);
        }
    }
}

