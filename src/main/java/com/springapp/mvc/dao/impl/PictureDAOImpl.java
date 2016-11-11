package com.springapp.mvc.dao.impl;

import com.springapp.mvc.dao.interfaces.PictureDAO;
import com.springapp.mvc.domain.Picture;
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
public class PictureDAOImpl implements PictureDAO {

    @Autowired
    private SessionFactory sessionFactory; // session factory object

    public PictureDAOImpl() {
    }

    public PictureDAOImpl(SessionFactory sessionFactory)
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
    public List<Picture> findAll() {
        List list = getCurrentSession().createQuery("from Picture").list();
        return list;
    }

    @Override
    public Picture findById(Integer pictureId) {
        return (Picture) getCurrentSession().load(Picture.class, pictureId);
    }

    @Override
    public void addPicture(Picture picture)     {
        getCurrentSession().save(picture);
    }

}
