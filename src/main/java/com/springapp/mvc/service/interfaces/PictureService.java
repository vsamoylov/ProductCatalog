package com.springapp.mvc.service.interfaces;

import com.springapp.mvc.domain.Picture;

import java.util.List;

/**
 * Created by Max on 13.06.2016.
 */
public interface PictureService {
    public List<Picture> findAll();
    public Picture findById(Integer pictureId);
    public void addPicture(Picture picture);
}
