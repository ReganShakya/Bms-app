/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bms.web.master.entity;

/**
 *
 * @author regan
 */
public class Salary{
    private int employeeId;
    private String firstName;
    private long amount;

    public Salary() {
    }

    public Salary(int employeeId, long amount) {
        this.employeeId = employeeId;
        this.amount = amount;
    }

    public Salary(int employeeId, String firstName, long amount) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.amount = amount;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
    
        
}
