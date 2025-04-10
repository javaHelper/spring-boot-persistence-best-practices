package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "bottom_category")
public class BottomCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "middle_category_id")
    private MiddleCategory middleCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MiddleCategory getMiddleCategory() {
        return middleCategory;
    }

    public void setMiddleCategory(MiddleCategory middleCategory) {
        this.middleCategory = middleCategory;
    }

    @Override
    public int hashCode() {
        return 2018;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BottomCategory)) {
            return false;
        }

        return id != null && id.equals(((BottomCategory) obj).id);
    }
}
