package com.miko.demo.mongo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello Spring 4 MongoDB Demo!");
		return "hello";
	}

    @RequestMapping(value = "entityA", method = RequestMethod.GET)
    public ModelAndView getEntityAMain(ModelAndView model){
        model.addObject("message", "Hello Spring 4 MongoDB Demo and AngularJS!");
        model.setViewName("hello");
        return model;
    }

    @RequestMapping(value = "template/entityAList", method = RequestMethod.GET)
    public ModelAndView getTemplateEntityAList(ModelAndView model){
        model.setViewName("entityAList");
        return model;
    }

}