package com.app.entity;

import com.app.dto.CategoryDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SqlResultSetMapping(name = "CategoryDtoMapping",
        classes = {
            @ConstructorResult(
                    targetClass = CategoryDto.class,
                    columns = {
                        @ColumnResult(name = "namet"),
                        @ColumnResult(name = "namem"),
                        @ColumnResult(name = "nameb")
                    }
            )}
)
@Entity
@Table(name = "top_category")
public class TopCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "topCategory", orphanRemoval = true)
    private List<MiddleCategory> middleCategories = new ArrayList<>();

    // helper methods
    public void addMiddleCategory(MiddleCategory middleCategory) {
        middleCategories.add(middleCategory);
        middleCategory.setTopCategory(this);
    }

    public void removeMiddleCategory(MiddleCategory middleCategory) {
        middleCategory.setTopCategory(null);
        middleCategories.remove(middleCategory);
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

    public List<MiddleCategory> getMiddleCategories() {
        return middleCategories;
    }

    public void setMiddleCategories(List<MiddleCategory> middleCategories) {
        this.middleCategories = middleCategories;
    }

}
