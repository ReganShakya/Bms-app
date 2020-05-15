/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bms.web.master.controller;

import com.bms.web.activities.repository.EmployeeDailyActivitiesRepository;
import com.bms.web.auth.entity.User;
import com.bms.web.auth.repository.UserRepository;
import com.bms.web.core.controller.CRUDController;
//import com.bms.web.master.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author regan
 */
@Controller
@RequestMapping(value="/employees")
public class EmployeeController extends CRUDController<User, Integer>{
    
    @Autowired
    private EmployeeDailyActivitiesRepository activitiesRepository;
    
    @Autowired
    private UserRepository userRepository;

    public EmployeeController() {
        super("Employee","master","employees");
        this.viewPath="employees";
    }
    
    @Override
    @GetMapping
    public String index(Model model){
        model.addAttribute("records", userRepository.findByRoleId(2));
        return viewPath+"/index";
    }
    
    @GetMapping(value = "activity/{id}")
    public String activity(@PathVariable("id") int id, Model model){
        model.addAttribute("dailyActivities", activitiesRepository.findByUserId(id));
        return "employees/activity";
    }
}
