package com.springapp.mvc.dao.impl;

import com.springapp.mvc.dao.interfaces.ProductDAO;
import com.springapp.mvc.domain.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

/**
 * Created by user on 8/4/2015.
 */
@Repository
@EnableTransactionManagement
public class ProductsDaoImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory; // session factory object

    public ProductsDaoImpl() {
    }

    public ProductsDaoImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession()
    {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        return session;
    }


    @Override
    public List<Product> findAll() {
        List list = getCurrentSession().createQuery("from Product").list();
        return list;
    }

    @Override
    public Product findById(Integer productId) {
        return (Product) getCurrentSession().get(Product.class, productId);
    }

    @Override
    public void addProduct(Product product) {
        getCurrentSession().save(product);
    }

    @Override
    public void editProduct(Product product, Integer productId) {
        Product productToEdit = findById(productId);

        if(productToEdit != null) {
            productToEdit.setProductName(product.getProductName());
            productToEdit.setProductPrice(product.getProductPrice());
            productToEdit.setProductStock(product.getProductId());
            productToEdit.setProductDescription(product.getProductDescription());
            productToEdit.setCategory(product.getCategory());

            getCurrentSession().update(productToEdit);
        }
    }

    @Override
    public void removeProduct(Integer productId) {
        Product productToRemove = findById(productId);

        if(productToRemove != null) {
            getCurrentSession().delete(productToRemove);
        }
    }


}
