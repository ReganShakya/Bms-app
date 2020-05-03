/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bms.web.controller;

import com.bms.web.activities.repository.EmployeeDailyActivitiesRepository;
import com.bms.web.core.controller.SiteController;
import com.bms.web.master.repository.EmployeeRepository;
import com.bms.web.master.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author regan
 */
@Controller
@RequestMapping(value = "/")
public class HomeController extends SiteController{

    public HomeController() {
        super("Dashboard","dashboard");
    }
    
    @Autowired
    private EmployeeDailyActivitiesRepository activityRepository;
    
    @Autowired
    private EmployeeRepository empRepository;
    
    @Autowired
    private TaskRepository tskRepository;
    
    @GetMapping
    public String index(){
        return "index";
    }
    
    @GetMapping(value = "/about")
    public String about(){
        return "index";
    }
    
    @GetMapping(value = "/board")
    public String board(Model model){
        model.addAttribute("activities", activityRepository.findAll());
        model.addAttribute("employees", empRepository.findAll());
        model.addAttribute("tsks", tskRepository.findAll());
        return "board";
    }
    
}