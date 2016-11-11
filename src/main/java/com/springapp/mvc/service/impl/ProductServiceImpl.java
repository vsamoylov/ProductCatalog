package com.springapp.mvc.service.impl;

import com.springapp.mvc.dao.interfaces.ProductDAO;
import com.springapp.mvc.domain.Product;
import com.springapp.mvc.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 8/4/2015.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductDAO productDAO;

    @Override
    @Transactional
    public List<Product> findAll()
    {
        return productDAO.findAll();
    }

    @Override
    @Transactional
    public Product findById(Integer productId)
    {
        return productDAO.findById(productId);
    }

    @Override
    @Transactional
    public void addProduct(Product product)
    {
        productDAO.addProduct(product);
    }

    @Override
    @Transactional
    public void editProduct(Product product, Integer productId)
    {
        productDAO.editProduct(product,productId);
    }

    @Override
    @Transactional
    public void removeProduct(Integer productId)
    {
        productDAO.removeProduct(productId);
    }
}
