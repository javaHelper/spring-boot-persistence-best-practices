package com.app.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "middle_category")
public class MiddleCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "middleCategory", orphanRemoval = true)
    private List<BottomCategory> bottomCategories = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "top_category_id")
    private TopCategory topCategory;

    // helper methods
    public void addBottomCategory(BottomCategory bottomCategory) {
        bottomCategories.add(bottomCategory);
        bottomCategory.setMiddleCategory(this);
    }

    public void removeBottomCategory(BottomCategory bottomCategory) {
        bottomCategory.setMiddleCategory(null);
        bottomCategories.remove(bottomCategory);
    }

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

    public List<BottomCategory> getBottomCategories() {
        return bottomCategories;
    }

    public void setBottomCategories(List<BottomCategory> bottomCategories) {
        this.bottomCategories = bottomCategories;
    }

    public TopCategory getTopCategory() {
        return topCategory;
    }

    public void setTopCategory(TopCategory topCategory) {
        this.topCategory = topCategory;
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

        if (!(obj instanceof MiddleCategory)) {
            return false;
        }

        return id != null && id.equals(((MiddleCategory) obj).id);
    }

}
