package com.example.springdatajpademo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@ToString
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class AuditableEntity {

    @CreatedDate
    @Column(name = "gmt_created")
    private Date createdTime;

    @LastModifiedDate
    @Column(name = "gmt_modified")
    private Date modifiedTime;

    @CreatedBy
    @Column(name = "creator")
    private String createdBy;

    @LastModifiedBy
    @Column(name = "modifier")
    private String modifiedBy;

    @Column(name = "is_deleted")
    private boolean deleted;

    public void delete() {
        this.deleted = true;
    }

}
