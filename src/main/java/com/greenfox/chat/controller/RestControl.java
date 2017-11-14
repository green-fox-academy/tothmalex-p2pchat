package com.greenfox.chat.controller;

import com.greenfox.chat.model.ChatUser;
import com.greenfox.chat.model.ErrorMessage;
import com.greenfox.chat.model.Message;
import com.greenfox.chat.model.Status;
import com.greenfox.chat.repository.ChatRepo;
import com.greenfox.chat.serrvice.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControl {

    @Autowired
    ChatRepo chatRepo;


    @GetMapping("/api/message/receive")
    public Object api(@RequestBody Message message ) {

        if (message == null) {
            Status errorStatus = new Status("error");
            Message mess = new Message("Missing items:");
            return errorStatus;

        } else {
            chatRepo.save(message);
            Status status = new Status("ok");

            return status;
        }
    }
}

        /*@GetMapping("/greeter")
        public Object greeter( @RequestParam(required = false) String name, @RequestParam(required = false) String title ) {

            if (name == null && title == null) {
                return new ErrorMessage("Please provide a name and a title!");
            } else if (title == null) {
                return new ErrorMessage("Please provide a title!");
            } else if (name == null) {
                return new ErrorMessage("Please provide a name!");
            } else if (name != null && name != null) {
                Greeter g = new Greeter(name, title);
                return g;
            }
            return null;
        }

        @GetMapping("/appenda/{appendable}")
        public Object appending( @PathVariable(required = false) String appendable ) {

            if (appendable == null) {
                return new ErrorMessage("404");
            } else {
                Appender a = new Appender(appendable);
                return a;
            }
        }

        @PostMapping(value = "/dountil/{what}")
        public Object dountil( @PathVariable(value = "what", required = false ) String operation, @RequestBody Until until ) {

            if (until.getUntil() == 0) {
                return new ErrorMessage("Please provide a number!");
            } else {
                DoUntil dountil = new DoUntil(until.getUntil(), operation);
                return dountil;
            }
        }
    }
*/
 /*   @PostMapping("/arrays")
    public Object arrayHandler(@RequestBody ArrayRequest arrayHandler) {

        if (arrayHandler.getWhat().equals("sum")|| arrayHandler.getWhat().equals("multiply")) {
            ArrayResponseInt intResponse = new ArrayResponseInt(arrayHandler.getWhat(), arrayHandler.getNumbers());
            logRepo.save(new Log( "/arrays", intResponse.toString()));
            return intResponse;
        } else if (arrayHandler.getWhat().equals("double")) {
            ArrayResponseArr arrResponse = new ArrayResponseArr(arrayHandler.getNumbers());
            logRepo.save(new Log( "/arrays", arrResponse.toString()));
            return arrResponse;
        } else {
            return new ErrorMessage("Please provide input!");
        }
    }*/
/*

    @GetMapping("/log")
    public LogList log() {
        LogList entries = new LogList();
        for(Log l : logRepo.findAll()) {
            entries.addEntry(l);
        }
        entries.setEntryCount(entries.getEntries().size());
        return entries;
    }