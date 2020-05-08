/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bms.web.activities.entity;

import com.bms.web.core.entity.MasterEntity;
import com.bms.web.master.entity.Employee;
import com.bms.web.master.entity.Task;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author regan
 */
@Entity
@Table(name  ="tbl_employees_daily_activities")
public class EmployeeDailyActivities extends MasterEntity{
    @Column(name = "working_date",insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date workingDate;
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    @ManyToOne
    private Employee employee;
    
    @Column(name = "employee_id",insertable = false, updatable = false)
    private int employeeId;
    
    @JoinColumn(name="task_id", referencedColumnName = "id")
    @ManyToOne
    private Task task;
    
    @Column(name = "task_id", insertable = false, updatable = false)
    private int taskId;
    
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "amount")
    private int amount;

    public Date getWorkingDate() {
        return workingDate;
    }

    public void setWorkingDate(Date workingDate) {
        this.workingDate = workingDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    
    
}
