package com.example.agencybooking.utils;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "doe", updatable = false)
    private LocalDateTime dateOfEntry;

    @CreatedBy
    @Column(name = "uoe", updatable = false)
    private String userOfEntry;

    @LastModifiedDate
    @Column(name = "dlu")
    private LocalDateTime dateOfLastUpdate;

    @LastModifiedBy
    @Column(name = "ulu")
    private String userOfLastUpdate;
}
