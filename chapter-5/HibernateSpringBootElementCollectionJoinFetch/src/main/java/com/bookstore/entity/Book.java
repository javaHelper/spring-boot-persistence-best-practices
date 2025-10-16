package com.bookstore.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String isbn;
    private String genre;
    private int price;

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", isbn=" + isbn + ", genre=" + genre + ", price=" + price + '}';
    }
}
