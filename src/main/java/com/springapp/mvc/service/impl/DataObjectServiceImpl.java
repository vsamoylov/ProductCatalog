package com.springapp.mvc.service.impl;

import com.springapp.mvc.dao.interfaces.DataObjectDAO;
import com.springapp.mvc.domain.DataObject;
import com.springapp.mvc.service.interfaces.DataObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Max on 13.06.2016.
 */
@Service
@Transactional
public class DataObjectServiceImpl implements DataObjectService {

    @Autowired
    private DataObjectDAO dataObjectDAO;

    @Override
    @Transactional
    public List<DataObject> findAll() {
        return dataObjectDAO.findAll();
    }

    @Override
    @Transactional
    public DataObject findById(Integer dataObjectId) {
        return dataObjectDAO.findById(dataObjectId);
    }

    @Override
    public boolean addObject(DataObject object) {
        return dataObjectDAO.addObject(object);
    }

    @Override
    public boolean editObject(DataObject object, Integer objectId) {
        return dataObjectDAO.editObject(object, objectId);
    }

    @Override
    public boolean removeObject(Integer objectId) {
        return dataObjectDAO.removeObject(objectId);
    }
}
