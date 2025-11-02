package com.bookstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;
import org.hibernate.annotations.Formula;

import java.io.Serializable;

@Data
@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String title;
    private String isbn;
    private double price;

    @Formula("price - price * 0.25")
    private double discounted;

    @Transient
    public double getDiscounted() {
        return discounted;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", isbn=" + isbn + ", price=" + price + ", discounted=" + discounted + '}';
    }
}
