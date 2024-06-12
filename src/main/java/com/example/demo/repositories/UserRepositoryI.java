package com.example.demo.repositories;

import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryI extends CrudRepository<User, Long> {

}
