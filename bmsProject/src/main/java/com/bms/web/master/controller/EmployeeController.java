/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bms.web.master.controller;

import com.bms.web.core.controller.CRUDController;
import com.bms.web.master.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author regan
 */
@Controller
@RequestMapping(value="/employees")
public class EmployeeController extends CRUDController<Employee, Integer>{

    public EmployeeController() {
        super("Employee","master","employees");
        this.viewPath="employees";
    }
}
