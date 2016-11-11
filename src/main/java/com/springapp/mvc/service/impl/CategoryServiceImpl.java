package com.springapp.mvc.service.impl;

import com.springapp.mvc.dao.interfaces.CategoryDAO;
import com.springapp.mvc.domain.Category;
import com.springapp.mvc.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 8/5/2015.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService
{
     /*
     *  It will be wired with CategoryDaoImpl, because it has @Repository annotation
     *
     *
     */

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    @Transactional
    public List<Category> findAll()
    {
        return categoryDAO.findAll();
    }

    @Override
    @Transactional
    public Category findById(Integer categoryId)
    {
        return categoryDAO.findById(categoryId);
    }

    @Override
    @Transactional
    public void addCategory(Category category)
    {
        categoryDAO.addCategory(category);
    }

    @Override
    @Transactional
    public void editCategory(Category category, Integer categoryId)
    {
        categoryDAO.editCategory(category,categoryId);
    }

    @Override
    @Transactional
    public void removeCategory(Integer categoryId)
    {
        categoryDAO.removeCategory(categoryId);
    }

}
