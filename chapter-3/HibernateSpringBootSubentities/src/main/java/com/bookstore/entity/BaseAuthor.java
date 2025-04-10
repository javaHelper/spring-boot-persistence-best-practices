package com.bookstore.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serializable;

@Data
@MappedSuperclass
public class BaseAuthor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private int age;
    private String name;
    private String genre;

    @Override
    public String toString() {
        return "Author{" + "name=" + name + "}";
    }
}
