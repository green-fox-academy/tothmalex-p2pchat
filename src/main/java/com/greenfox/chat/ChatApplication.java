package com.greenfox.chat;

import com.greenfox.chat.repository.ChatRepo;
import com.greenfox.chat.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatApplication implements CommandLineRunner{

	@Autowired
	UserRepo userRepo;

	@Autowired
	ChatRepo chatRepo;

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}