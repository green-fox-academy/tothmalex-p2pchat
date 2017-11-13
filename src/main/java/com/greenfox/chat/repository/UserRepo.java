package com.greenfox.chat.repository;

import com.greenfox.chat.model.ChatUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<ChatUser, Long> {}
