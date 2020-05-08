/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bms.web.master.controller;

import com.bms.web.activities.repository.EmployeeDailyActivitiesRepository;
import com.bms.web.core.controller.CRUDController;
import com.bms.web.master.entity.Employee;
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
public class EmployeeController extends CRUDController<Employee, Integer>{
    
    @Autowired
    private EmployeeDailyActivitiesRepository activitiesRepository;

    public EmployeeController() {
        super("Employee","master","employees");
        this.viewPath="employees";
    }
    
   @GetMapping(value = "activity/{id}")
    public String activity(@PathVariable("id") int id, Model model){
        model.addAttribute("dailyActivities", activitiesRepository.findByEmployeeId(id));
        return "employees/activity";
    }
}
