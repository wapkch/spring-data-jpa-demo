package com.example.springdatajpademo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.TenantId;
import org.hibernate.annotations.Where;

@Setter
@Getter
@Entity
@Table(name = "user_role")
@Where(clause = "is_deleted = 0")
@DynamicUpdate
public class UserAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @TenantId
    private String tenant;

    @Column(name = "is_deleted")
    private boolean deleted;

}
