/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bms.web.activities.repository;

import com.bms.web.activities.entity.EmployeeDailyActivities;
import com.bms.web.master.entity.Salary;
import java.util.List;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author regan
 */
public interface EmployeeDailyActivitiesRepository extends 
        JpaRepository<EmployeeDailyActivities, Integer>{
    
//    List<EmployeeDailyActivities> findByEmployeeId(int employeeId);
    List<EmployeeDailyActivities> findByUserId(int userId);
    
        
    @Query("SELECT e from EmployeeDailyActivities e INNER JOIN User a ON a.id=e.userId WHERE a.userName=?1")
    List<EmployeeDailyActivities> getActivityByUserName(String userName);
    
//    @Query("SELECT new com.bms.web.master.entity.Salary(u.employeeId, SUM(u.amount)) "
//            + "FROM EmployeeDailyActivities u GROUP BY u.employeeId")
    
    @Query("SELECT new com.bms.web.master.entity.Salary(u.userId, a.userName, SUM(u.amount)) "
            + "FROM EmployeeDailyActivities u inner join User a on "
            + "a.id=u.userId GROUP BY u.userId")
        List<Salary> getSalary();
        
//    @Query("SELECT new com.bms.web.master.entity.Salary(e.userId, e.userName, e.amount) "
//            + "FROM(SELECT u.userId, a.userName, "
//            + "SUM(u.amount) AS amount FROM EmployeeDailyActivities u "
//            + "INNER JOIN User a ON a.id=u.userId GROUP BY u.userId ) e WHERE e.userName=?1")
        
//    @Query(value = "SELECT u.userId, u.username, u.amount FROM " +
//        "(SELECT u.user_id as userId, a.username, SUM(u.amount) as amount FROM " +
//        "tbl_employees_daily_activities u inner join tbl_users a on a.id=u.user_id GROUP BY u.user_id)" +
//        "u where u.username=?1", nativeQuery = true)    
//        Salary getSalaryByUser(String username);
    
   
  }