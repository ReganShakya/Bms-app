/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bms.web.master.repository;

import com.bms.web.master.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author regan
 */
public interface EmployeeRepository extends 
        JpaRepository<Employee, Integer>{
    
}
