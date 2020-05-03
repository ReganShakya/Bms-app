/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bms.web.master.controller;

import com.bms.web.core.controller.CRUDController;
import com.bms.web.master.entity.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author regan
 */
@Controller
@RequestMapping(value="/tasks")
public class TaskController extends CRUDController<Task, Integer>{

    public TaskController() {
        super("Task","master","tasks");
        this.viewPath="tasks";
    }
}
