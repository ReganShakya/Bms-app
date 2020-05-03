/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bms.web.master.entity;

import com.bms.web.activities.entity.EmployeeDailyActivities;
import com.bms.web.core.entity.MasterEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author regan
 */
@Entity
@Table(name = "mst_tasks")
public class Task extends MasterEntity{
    @Column(name = "task_name")
    private String name;
    @Column(name = "rate")
    private int rate;
    
    @JsonIgnore
    @OneToMany(mappedBy = "task")
    private List<EmployeeDailyActivities> employeeDailyActivities;

    public Task() {
    }

    public Task(int id) {
        super(id);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public List<EmployeeDailyActivities> getEmployeeDailyActivities() {
        return employeeDailyActivities;
    }

    public void setEmployeeDailyActivities(List<EmployeeDailyActivities> employeeDailyActivities) {
        this.employeeDailyActivities = employeeDailyActivities;
    }
    
    
}
