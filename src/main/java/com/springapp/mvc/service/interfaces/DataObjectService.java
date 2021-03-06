package com.springapp.mvc.service.interfaces;

import com.springapp.mvc.domain.DataObject;

import java.util.List;

/**
 * Created by Max on 13.06.2016.
 */
public interface DataObjectService {
    public List<DataObject> findAll();
    public DataObject findById(Integer objectId);
    public boolean addObject(DataObject object);
    public boolean editObject(DataObject object, Integer objectId);
    public boolean removeObject(Integer objectId);
}
