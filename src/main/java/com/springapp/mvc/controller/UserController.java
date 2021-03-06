package com.springapp.mvc.controller;

import com.springapp.mvc.domain.User;
import com.springapp.mvc.service.interfaces.UserService;
import com.springapp.mvc.validator.UserFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Max on 08.11.2016.
 */

@Controller
@RequestMapping("/users")
public class UserController {

//    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserFormValidator userFormValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userFormValidator);
    }

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String index(Model model) {
//        logger.debug("index()");
        return "redirect:/users";
    }

     //list page
    @RequestMapping(/*value = "/users",*/method = RequestMethod.GET)
    public String showAllUsers(Model model) {
//        logger.debug("showAllUsers()");
        model.addAttribute("users", userService.findAll());
        return "users/list";

    }

    // save or update user
    @RequestMapping(/*value = "/users",*/method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated User user,
                                   BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
//        logger.debug("saveOrUpdateUser() : {}", user);
        if (result.hasErrors()) {
            populateDefaultModel(model);
            return "users/userform";
        } else {
            redirectAttributes.addFlashAttribute("css", "success");
            if(user.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "User added successfully!");
            } else {
                redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
            }

            userService.saveOrUpdate(user);

            // POST/REDIRECT/GET
            return "redirect:/users/" + user.getId();
        }

    }

//     show add user form /users/add
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddUserForm(Model model) {
//        logger.debug("showAddUserForm()");
        User user = new User();

        // set default value
        user.setName("name");
        user.setEmail("mail@gmail.com");
        user.setAddress("NY, USA");
        user.setSex("M");
        user.setGrants(new ArrayList<String>(Arrays.asList("R")));

        model.addAttribute("userForm", user);

        populateDefaultModel(model);

        return "users/userform";
    }

//     show update form /users/{id}/update
    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateUserForm(@PathVariable("id") int id, Model model) {
//        logger.debug("showUpdateUserForm() : {}", id);
        User user = userService.findById(id);
        model.addAttribute("userForm", user);

        populateDefaultModel(model);

        return "users/userform";

    }

//     delete user /users/{id}/delete
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String deleteUser(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
//        logger.debug("deleteUser() : {}", id);
        userService.remove(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "User is deleted!");

        return "redirect:/users";

    }

    // show user /users/{id}
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") int id, Model model) {
//        logger.debug("showUser() id: {}", id);
        User user = userService.findById(id);
        if (user == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("user", user);

        return "users/show";

    }

    //todo make configurable
    private void populateDefaultModel(Model model) {
        Map<String, String> grants = new LinkedHashMap<String, String>();
        grants.put("R", "R");
        grants.put("W", "W");
        grants.put("G", "G");
        model.addAttribute("grants", grants);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView handleEmptyData(HttpServletRequest req, Exception ex) {
//        logger.debug("handleEmptyData()");
//        logger.error("Request: {}, error ", req.getRequestURL(), ex);
        ModelAndView model = new ModelAndView();
        model.setViewName("user/show");
        model.addObject("msg", "user not found");

        return model;

    }

}
