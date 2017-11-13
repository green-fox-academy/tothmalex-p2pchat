package com.greenfox.chat.repository;

import com.greenfox.chat.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {}
