package com.greenfox.chat.controller;

import com.greenfox.chat.serrvice.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RestControl {

    @Autowired
    LogService logService;

    @GetMapping("/alex")
    public void log( HttpServletRequest request, Exception exception) {
        logService.checkEnvironment(request, exception);
    }
}