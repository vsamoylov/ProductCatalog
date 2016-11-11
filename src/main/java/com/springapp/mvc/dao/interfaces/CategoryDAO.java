package com.springapp.mvc.dao.interfaces;

import com.springapp.mvc.domain.Category;

import java.util.List;

/**
 * Created by user on 8/5/2015.
 */
public interface CategoryDAO {
    public List<Category> findAll();
    public Category findById(Integer categoryId);
    public void addCategory(Category category);
    public void editCategory(Category category, Integer categoryId);
    public void removeCategory(Integer categoryId);
}
