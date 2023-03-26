package com.example.springdatajpademo.repository;

import com.example.springdatajpademo.entity.Role;

import org.springframework.data.repository.ListCrudRepository;

public interface RoleRepository extends ListCrudRepository<Role, Long> {
}
