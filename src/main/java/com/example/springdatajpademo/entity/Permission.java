package com.example.springdatajpademo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Where;

@Setter
@Getter
@Entity
@Where(clause = "is_deleted = 0")
@DynamicInsert
public class Permission extends AuditableEntity {

    @Id
    private String id;

    @OneToMany(mappedBy = "permission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PermissionAssignment> roles = new ArrayList<>();

    @OneToMany(mappedBy = "permission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChannelPermission> channels = new ArrayList<>();

}
