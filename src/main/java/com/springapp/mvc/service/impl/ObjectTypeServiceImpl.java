package com.springapp.mvc.service.impl;

import com.springapp.mvc.dao.interfaces.ObjectTypeDAO;
import com.springapp.mvc.domain.ObjectType;
import com.springapp.mvc.service.interfaces.ObjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Max on 13.06.2016.
 */
@Service
@Transactional
public class ObjectTypeServiceImpl implements ObjectTypeService {

    @Autowired
    private ObjectTypeDAO objectTypeDAO;

    @Override
    @Transactional
    public List<ObjectType> findAll() {
        return objectTypeDAO.findAll();
    }

    @Override
    @Transactional
    public ObjectType findById(Integer objectTypeId) {
        return objectTypeDAO.findById(objectTypeId);
    }
}
