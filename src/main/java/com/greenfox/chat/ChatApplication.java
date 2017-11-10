package com.greenfox.chat;

import com.greenfox.chat.model.Message;
import com.greenfox.chat.repository.ChatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatApplication implements CommandLineRunner{

	@Autowired
	ChatRepo chatRepo;

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}

	@Override
	public void run( String... args ) throws Exception {
		Message mess = new Message("message");
		chatRepo.save(mess);
	}
}
