package com.example.springdatajpademo.entity;

import jakarta.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.TenantId;

@Setter
@Getter
@MappedSuperclass
public class ChannelBaseEntity extends AuditableEntity {

    @TenantId
    private String channelCode;

}
