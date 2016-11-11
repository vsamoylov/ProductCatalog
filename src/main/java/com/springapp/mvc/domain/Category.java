package com.springapp.mvc.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by user on 8/5/2015.
 */
@Entity
@Table(name="categories")
public class Category
{
    @Id
    @GeneratedValue
    @Column(name="category_id")
    private int categoryId;

    @Column(name = "name")
    private String categoryName;

    @Column(name = "description")
    private String categoryDescription;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Product> products;

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
