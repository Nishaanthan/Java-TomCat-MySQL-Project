/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.repository;

import com.abc.abcsoftwarecompany.model.EmployeeProject;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thamira
 */
public interface ProjectEmployeeRepository {
    EmployeeProject save(EmployeeProject employeeProject) throws ClassNotFoundException, SQLException;

    Boolean deleteProject(Long Id,Long empId) throws ClassNotFoundException, SQLException;

    Boolean deleteEmployee(Long Id) throws ClassNotFoundException, SQLException;

    Boolean upadate(Long prohectId,Long EmployeeId ) throws ClassNotFoundException, SQLException;
    
    List<EmployeeProject> findAllEmployeeProjectById(Long id)throws ClassNotFoundException, SQLException;
    public boolean findAllEmployeeProjectById(Long id,Long empId) throws ClassNotFoundException, SQLException ;
}
