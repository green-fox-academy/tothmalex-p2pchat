package com.greenfox.chat.repository;

import com.greenfox.chat.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChatRepo extends CrudRepository<Message, Long> {
}