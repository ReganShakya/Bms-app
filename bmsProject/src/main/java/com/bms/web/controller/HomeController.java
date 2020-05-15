/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bms.web.controller;

import com.bms.web.activities.repository.EmployeeDailyActivitiesRepository;
import com.bms.web.auth.repository.UserRepository;
import com.bms.web.core.controller.SiteController;
//import com.bms.web.master.repository.EmployeeRepository;
import com.bms.web.master.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    
//    @Autowired
//    private EmployeeRepository empRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TaskRepository tskRepository;
    
    @GetMapping(value = {"/","index"})
    public String index(Model model){
        model.addAttribute("employees",userRepository.findAll());
        model.addAttribute("dailyActivities", activityRepository.findAll());
        return "dash/index";
    }
    
    @GetMapping(value = "/about")
    public String about(){
        return "dash/index";
    }
    
//    @GetMapping(value = "/create")
//    public String create(Model model){
//        model.addAttribute("user",userRepository.findById(Integer.SIZE))
//        return "employee_daily_activities/create";
//    }
    
//    @GetMapping(value = "/calendar")
//    public String calendar(){
//        return "calendar";
//    }
    
    @GetMapping(value = "/board")
    public String board(Model model){
        model.addAttribute("activities", activityRepository.findAll());
        model.addAttribute("employees", userRepository.findAll());
        model.addAttribute("tsks", tskRepository.findAll());
        return "board";
    }
    
    @RequestMapping(value = "/salary")
    public String salary(Model model){        
        String username= "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
          username = ((UserDetails)principal).getUsername();
        } else {
          username = principal.toString();
        }
        model.addAttribute("salaries",activityRepository.getSalary());
        model.addAttribute("userSalaries",activityRepository.getSalary());
//        model.addAttribute("userSalaries",activityRepository.getSalaryByUser(username));        
        return "salaries/index";
    }
    
}
