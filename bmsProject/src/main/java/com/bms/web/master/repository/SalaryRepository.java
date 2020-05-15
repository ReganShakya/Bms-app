///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.bms.web.master.repository;
//
//import com.bms.web.master.entity.Salary;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
///**
// *
// * @author regan
// */
//public interface SalaryRepository extends 
//        JpaRepository<Salary, Integer>{
//    
//    @Query("insert into Salary(userId,username,amount) SELECT u.userId, a.username, SUM(u.amount) FROM EmployeeDailyActivities u inner join Users a on a.id=u.userId GROUP BY u.userId")
//    Salary updateSalary();
//}
