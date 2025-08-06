package com.bookstore.entity;

import com.bookstore.converter.GenreTypeConverter;
import com.bookstore.enums.GenreType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;
    private String name;

    @Convert(converter = GenreTypeConverter.class)
    @Column(columnDefinition = "TINYINT")
    private GenreType genre;
}
