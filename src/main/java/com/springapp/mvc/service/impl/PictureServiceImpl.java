package com.springapp.mvc.service.impl;

import com.springapp.mvc.dao.interfaces.PictureDAO;
import com.springapp.mvc.domain.Picture;
import com.springapp.mvc.service.interfaces.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Max on 13.06.2016.
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDAO pictureDAO;

    @Override
    @Transactional
    public List<Picture> findAll() {
        return pictureDAO.findAll();
    }

    @Override
    @Transactional
    public Picture findById(Integer pictureId) {
        return pictureDAO.findById(pictureId);
    }

    @Override
    public void addPicture(Picture picture) {
        pictureDAO.addPicture(picture);
    }
}
