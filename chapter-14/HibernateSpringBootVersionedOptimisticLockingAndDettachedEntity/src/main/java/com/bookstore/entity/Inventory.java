package com.bookstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Inventory implements Serializable {
 
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String title;
    private int quantity;

    @Version
    private Short version;
}
