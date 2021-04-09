package com.example.userservice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = {"id"})
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "create_timestamp")
    protected LocalDateTime createTimestamp;

    @Column(name = "update_timestamp")
    protected LocalDateTime updateTimestamp;

    @PrePersist
    public void prePersist() {
        createTimestamp = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateTimestamp = LocalDateTime.now();
    }
}