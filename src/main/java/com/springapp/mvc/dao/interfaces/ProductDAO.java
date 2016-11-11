package com.springapp.mvc.dao.interfaces;

import com.springapp.mvc.domain.Product;

import java.util.List;

/**
 * Created by user on 8/4/2015.
 */
public interface ProductDAO
{
    public List<Product> findAll();
    public Product findById(Integer productId);
    public void addProduct(Product product);
    public void editProduct(Product product, Integer productId);
    public void removeProduct(Integer productId);
}
