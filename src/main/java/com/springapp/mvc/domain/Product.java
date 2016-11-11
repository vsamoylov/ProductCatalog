package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by user on 8/5/2015.
 */
@Entity
@Table(name="products")
public class Product
{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="product_id")
    private int productId;

    @Column(name="name")
    private String productName;

    @Column(name="stock")
    private int productStock;

    @Column(name="price")
    private double productPrice;

    @Column(name="description")
    private String productDescription;

    /**
     *    1. FetchType.LAZY -- LAZY means the data will be loaded if needed.
     *    2. Each product always have a 'category'. Hence, we use a property with type 'Category'.
     *    In Category.java, this properties is called by using : mappedBy = "category";
     *    3. @JoinColumn(name="categoryId") -- defines foreign key in the table.
     */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    public Product()
    {

    }

    public Product(String productName, int productStock, double productPrice,String productDescription)
    {
        this.productName = productName;
        this.productStock = productStock;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
