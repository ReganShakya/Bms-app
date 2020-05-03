/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bms.web.activities.controller;

import com.bms.web.activities.entity.EmployeeDailyActivities;
import com.bms.web.core.controller.CRUDController;
import com.bms.web.master.repository.EmployeeRepository;
import com.bms.web.master.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author regan
 */
@Controller
@RequestMapping(value = "/employee-daily-activities")
public class EmployeeDailyActivitiesController
        extends CRUDController<EmployeeDailyActivities, Integer> {

    @Autowired
    private EmployeeRepository empRepository;

    @Autowired
    private TaskRepository tskRepository;

    public EmployeeDailyActivitiesController() {
        super("Employee Daily Activities", "activity", "employee-daily-activities");
        this.viewPath = "employee_daily_activities";
    }

    @Override
    public String create(Model model) {

        model.addAttribute("emps", empRepository.findAll());
        model.addAttribute("tsks", tskRepository.findAll());
        return super.create(model); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("emps", empRepository.findAll());
        model.addAttribute("tsks", tskRepository.findAll());
        return super.edit(id, model); //To change body of generated methods, choose Tools | Templates.
    }

}
