package com.teacher.teacherscheduler.controllers;

import com.teacher.teacherscheduler.data.UserDao;
import com.teacher.teacherscheduler.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserDao userDao; // Data Access Object  --we will send the data from database by creating Autowired.



    @RequestMapping(value ="")
    public String index(Model model) {
        //model.addAttribute("title", "Create Student");
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("title", "Create User");
        return "user/index";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title", "Register");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid User user,
                      Model model,
                      Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            model.addAttribute("users", userDao.findAll());
            return "user/add";
        }
        userDao.save(user);
        return "redirect:";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(Model model) {

        return "user/logout";

    }
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(@ModelAttribute User user, Model model) {

        return "user/login";
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user,
                        Model model,
                        Errors errors) {
        if (user.getUsername().contains("test")) {
            model.addAttribute("users", userDao.findAll());
            return "user/index";
        }
        return "user/login";

    }

}