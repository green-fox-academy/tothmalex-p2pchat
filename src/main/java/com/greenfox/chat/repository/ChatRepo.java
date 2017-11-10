package com.greenfox.chat.repository;

import com.greenfox.chat.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChatRepo extends CrudRepository<Post, Long> {
    List<Post> findAllByOrderByScoreDesc();
}