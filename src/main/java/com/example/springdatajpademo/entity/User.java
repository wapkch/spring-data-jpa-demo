package com.example.springdatajpademo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.TenantId;
import org.hibernate.annotations.Where;

@Setter
@Getter
@Entity
@Where(clause = "is_deleted = 0")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAssignment> roles = new ArrayList<>();

    @TenantId
    private String tenant;

    @Column(name = "is_deleted")
    private boolean deleted;

}
