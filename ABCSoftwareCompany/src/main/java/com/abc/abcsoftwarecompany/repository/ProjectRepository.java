/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.repository;

import com.abc.abcsoftwarecompany.model.Client;
import com.abc.abcsoftwarecompany.model.Employee;
import com.abc.abcsoftwarecompany.model.Project;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thamira
 */
public interface ProjectRepository {
    
    Project save(Project project) throws ClassNotFoundException, SQLException;

    Boolean delete(Long Id) throws ClassNotFoundException, SQLException;

    Project upadate(Project project,Long Id) throws ClassNotFoundException, SQLException;

    List<Project> getAllProject() throws ClassNotFoundException, SQLException;

    Project findProjectByProjectName(String projectName) throws ClassNotFoundException, SQLException;
    
    Project findProjectByProjectId(Long id) throws ClassNotFoundException, SQLException;
    
    Client findClientByProjId(Long id) throws ClassNotFoundException, SQLException;
    
    List<Employee> findEmployeeByProjectId(Long id) throws ClassNotFoundException, SQLException;
    
    Project findProjectByClientId(Long id) throws ClassNotFoundException, SQLException;
} 