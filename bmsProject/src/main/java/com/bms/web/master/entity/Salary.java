
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
    private int userId;
    private String userName;
    private long amount;

    public Salary() {
    }

    public Salary(int userId, String userName, long amount) {
        this.userId = userId;
        this.userName = userName;
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }        
}

