package com.springapp.mvc.service.interfaces;

import com.springapp.mvc.domain.ObjectType;

import java.util.List;

/**
 * Created by Max on 13.06.2016.
 */
public interface ObjectTypeService {
    public List<ObjectType> findAll();
    public ObjectType findById(Integer dataObjectId);
}
