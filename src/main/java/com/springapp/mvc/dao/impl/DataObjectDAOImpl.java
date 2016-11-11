package com.springapp.mvc.dao.impl;

import com.springapp.mvc.dao.interfaces.DataObjectDAO;
import com.springapp.mvc.domain.DataObject;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Max on 13.06.2016.
 */
@Repository
public class DataObjectDAOImpl implements DataObjectDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public DataObjectDAOImpl() {
    }

    public DataObjectDAOImpl(SessionFactory sessionFactory) {
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
    public List<DataObject> findAll() {
        List list = getCurrentSession().createQuery("from DataObject").list();
        return list;
    }

    @Override
    public DataObject findById(Integer objectId) {
        return (DataObject) getCurrentSession().load(DataObject.class, objectId);
    }

    @Override
    public boolean addObject(DataObject object) {
        try {
            getCurrentSession().save(object);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean editObject(DataObject object, Integer objectId) {
        DataObject dataObject = findById(objectId);

        if(dataObject != null) {
            dataObject.setName(object.getName());
            dataObject.setDescription(object.getDescription());
            dataObject.setObjectType(object.getObjectType());
            dataObject.setPicture(object.getPicture());

            return true;
        }

        return false;
    }

    @Override
    public boolean removeObject(Integer objectId) {
        DataObject object = findById(objectId);

        if(object != null) {
            try {
                getCurrentSession().delete(object);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }

        return false;
    }
}
