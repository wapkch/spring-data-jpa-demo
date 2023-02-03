package com.example.springdatajpademo.repository;

import com.example.springdatajpademo.entity.User;

import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> {
}
