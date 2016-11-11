package com.springapp.mvc.dao.interfaces;

import com.springapp.mvc.domain.ObjectType;

import java.util.List;

/**
 * Created by Max on 13.06.2016.
 */
public interface ObjectTypeDAO {
    public List<ObjectType> findAll();
    public ObjectType findById(Integer dataObjectId);
}
