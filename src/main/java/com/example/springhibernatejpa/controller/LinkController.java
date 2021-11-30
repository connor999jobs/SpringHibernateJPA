package com.example.springhibernatejpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {

    @RequestMapping(value = "/")
    public ModelAndView mainPage(){
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/index")
    public ModelAndView indexpage(){
        return new ModelAndView("home");
    }
}
