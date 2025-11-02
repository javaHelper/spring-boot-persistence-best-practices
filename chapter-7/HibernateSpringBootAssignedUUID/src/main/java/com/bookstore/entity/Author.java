package com.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private int age;
    private String name;
    private String genre;

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", age=" + age + ", name=" + name + ", genre=" + genre + '}';
    }
}
