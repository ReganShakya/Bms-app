/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bms.web.activities.repository;

import com.bms.web.activities.entity.EmployeeDailyActivities;
import com.bms.web.master.entity.Salary;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author regan
 */
public interface EmployeeDailyActivitiesRepository extends 
        JpaRepository<EmployeeDailyActivities, Integer>{
    
    List<EmployeeDailyActivities> findByEmployeeId(int employeeId);
    
//    SELECT u.employee_id, a.first_Name, SUM(u.amount) FROM tbl_employees_daily_activities u
//    inner join tbl_employees a on a.id=u.employee_id GROUP BY u.employee_id

    
    @Query("SELECT new com.bms.web.master.entity.Salary(u.employeeId, a.firstName, SUM(u.amount)) "
            + "FROM EmployeeDailyActivities u inner join Employee a on "
            + "a.id=u.employeeId GROUP BY u.employeeId")
    
//    @Query("SELECT new com.bms.web.master.entity.Salary(u.employeeId, SUM(u.amount)) "
//            + "FROM EmployeeDailyActivities u GROUP BY u.employeeId")
        List<Salary> getSalary();
}