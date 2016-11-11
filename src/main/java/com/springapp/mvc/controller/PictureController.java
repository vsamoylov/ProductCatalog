package com.springapp.mvc.controller;

import com.springapp.mvc.dao.interfaces.PictureDAO;
import com.springapp.mvc.domain.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Max on 13.06.2016.
 */
@Controller
@RequestMapping("/pictures")
public class PictureController {
    @Autowired
    PictureDAO pictureDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        StringBuilder result = new StringBuilder();

        List<Picture> all = pictureDAO.findAll();
        for (Picture picture : all) {
            result.append("<img src=" + picture.getUrl() + " />");
        }

        model.addAttribute("message", result);
        return "pictures";
    }
}
