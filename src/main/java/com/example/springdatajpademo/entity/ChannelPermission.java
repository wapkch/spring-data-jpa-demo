package com.example.springdatajpademo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Where;

@Setter
@Getter
@Entity
@Where(clause = "is_deleted = 0")
@DynamicInsert
public class ChannelPermission extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Channel channel;

    @ManyToOne
    private Permission permission;

}
