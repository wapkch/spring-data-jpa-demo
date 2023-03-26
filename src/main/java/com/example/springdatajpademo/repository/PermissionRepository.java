package com.example.springdatajpademo.repository;

import com.example.springdatajpademo.entity.Permission;

import org.springframework.data.repository.ListCrudRepository;

public interface PermissionRepository extends ListCrudRepository<Permission, String> {
}
