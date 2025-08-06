package com.bookstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import lombok.Data;

import java.io.Serializable;
import java.util.logging.Logger;

@Data
@Entity
public class Author implements Serializable {

    private static final Logger logger = Logger.getLogger(Author.class.getName());
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;
    private String name;
    private String genre;

    @PrePersist
    private void prePersist() {
        logger.info("@PrePersist callback ...");
    }

    @PreUpdate
    private void preUpdate() {
        logger.info("@PreUpdate callback ...");
    }

    @PreRemove
    private void preRemove() {
        logger.info("@PreRemove callback ...");
    }

    @PostLoad
    private void postLoad() {
        logger.info("@PostLoad callback ...");
    }

    @PostPersist
    private void postPersist() {
        logger.info("@PostPersist callback ...");
    }

    @PostUpdate
    private void postUpdate() {
        logger.info("@PostUpdate callback ...");
    }

    @PostRemove
    private void postRemove() {
        logger.info("@PostRemove callback ...");
    }
}
