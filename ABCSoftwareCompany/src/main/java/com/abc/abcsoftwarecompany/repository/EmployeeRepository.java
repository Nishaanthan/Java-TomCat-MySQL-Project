/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.repository;

import com.abc.abcsoftwarecompany.model.Employee;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thamira
 */
public interface EmployeeRepository {
    Employee save(Employee employee) throws ClassNotFoundException, SQLException;

    Boolean delete(Long Id) throws ClassNotFoundException, SQLException;

    Employee upadate(Employee employee,Long id) throws ClassNotFoundException, SQLException;

    List<Employee> getAllEmployee() throws ClassNotFoundException, SQLException;

    Employee findEmployeeById(Long id) throws ClassNotFoundException, SQLException;
    
    Employee findEmployeeByname(String name) throws ClassNotFoundException, SQLException;
    boolean isexist(String firstName,String lastName) throws ClassNotFoundException, SQLException;
    
    List<Employee> findEmployeeByEmployeeByfirstName(String name) throws ClassNotFoundException, SQLException;
    
}
