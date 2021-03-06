package com.springapp.mvc.controller;

import com.springapp.mvc.dao.interfaces.DataObjectDAO;
import com.springapp.mvc.domain.DataObject;
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
@RequestMapping("/objects")
public class ObjectController {

    @Autowired
    DataObjectDAO dataObjectDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        StringBuilder result = new StringBuilder();

        List<DataObject> all = dataObjectDAO.findAll();
        for (DataObject dataObject : all) {
            result.append(dataObject.getName() + " " + dataObject.getObjectType().getName());

            Picture picture = dataObject.getPicture();
            if(picture != null) {
                result.append(" <img src=" + picture.getUrl() + ">");
            }
        }

        model.addAttribute("message", result);
        return "objects";
    }
}
