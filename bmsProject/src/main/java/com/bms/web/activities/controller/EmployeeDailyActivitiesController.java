/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bms.web.activities.controller;

import com.bms.web.activities.entity.EmployeeDailyActivities;
import com.bms.web.activities.repository.EmployeeDailyActivitiesRepository;
import com.bms.web.auth.repository.UserRepository;
import com.bms.web.core.controller.CRUDController;
//import com.bms.web.master.repository.SalaryRepository;
//import com.bms.web.master.repository.EmployeeRepository;
import com.bms.web.master.repository.TaskRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author regan
 */
@Controller
@RequestMapping(value = "/employee-daily-activities")
public class EmployeeDailyActivitiesController
        extends CRUDController<EmployeeDailyActivities, Integer> {

//    @Autowired
//    private EmployeeRepository empRepository;
    
//    @Autowired
//    private SalaryRepository salaryRepository;

    @Autowired
    private TaskRepository tskRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EmployeeDailyActivitiesRepository activitiesRepository;

    public EmployeeDailyActivitiesController() {
        super("Employee Daily Activities", "activity", "employee-daily-activities");
        this.viewPath = "employee_daily_activities";
    }
    
    @Override
    @GetMapping
    public String index(Model model){
        String username= "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
          username = ((UserDetails)principal).getUsername();
        } else {
          username = principal.toString();
        }
        model.addAttribute("records", activitiesRepository.findAll());       
        model.addAttribute("activities", activitiesRepository.getActivityByUserName(username));
        return viewPath+"/index";
    }

    @Override
    public String create(Model model) {
        String username= "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
          username = ((UserDetails)principal).getUsername();
        } else {
          username = principal.toString();
        }
        model.addAttribute("user", userRepository.findByUserName(username));
        model.addAttribute("emps", userRepository.findAll());
        model.addAttribute("tsks", tskRepository.findAll());
        return super.create(model); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("emps", userRepository.findAll());
        model.addAttribute("tsks", tskRepository.findAll());
        return super.edit(id, model); //To change body of generated methods, choose Tools | Templates.
    }
    
//    @PostMapping
//    @Transactional
//    public String save(EmployeeDailyActivities activities){
//        activitiesRepository.save(activities);
//        salaryRepository.deleteAll();
////        salaryRepository.updateSalary();
//        return "redirect:/employee-daily-activities?success";
//    }

}