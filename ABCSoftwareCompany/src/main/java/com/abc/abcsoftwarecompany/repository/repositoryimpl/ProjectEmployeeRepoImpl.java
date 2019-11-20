/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.repository.repositoryimpl;

import com.abc.abcsoftwarecompany.dbconnection.DBConnection;
import com.abc.abcsoftwarecompany.model.Employee;
import com.abc.abcsoftwarecompany.model.EmployeeProject;
import com.abc.abcsoftwarecompany.repository.ProjectEmployeeRepository;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thamira
 */
public class ProjectEmployeeRepoImpl implements ProjectEmployeeRepository{

    @Override
    public EmployeeProject save(EmployeeProject employeeProject) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO `employee_project`(`employee_id`, `project_id`) VALUES (?,?)");
        prepareStatement.setObject(1, employeeProject.getEmployeeId());
        prepareStatement.setObject(2, employeeProject.getProjectId());
        boolean saved = prepareStatement.executeUpdate() > 0;

        if (saved) {
            return employeeProject;
        }

        return new EmployeeProject();
    }

    @Override
    public Boolean deleteProject(Long Id,Long empId) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();

        Statement stm = connection.createStatement();
        String sql = "DELETE FROM `employee_project` WHERE project_id=" + Id + " and employee_id="+empId+"";
        return stm.executeUpdate(sql) > 0;
    }

    @Override
    public Boolean deleteEmployee(Long Id) throws ClassNotFoundException, SQLException {
         Connection connection = DBConnection.getConnection();

        Statement stm = connection.createStatement();
        String sql = "DELETE FROM `employee_project` WHERE employee_id=" + Id + "";
        return stm.executeUpdate(sql) > 0;
    }

    @Override
    public Boolean upadate(Long prohectId, Long EmployeeId) throws ClassNotFoundException, SQLException {
         Connection connection = DBConnection.getConnection();

        PreparedStatement prepareStatement = connection.prepareStatement(" UPDATE `employee_project` SET `employee_id`=?,`project_id`=? WHERE project_id=?");
        prepareStatement.setObject(1, EmployeeId);
        prepareStatement.setObject(2, prohectId);
        prepareStatement.setObject(4, EmployeeId);

        boolean isUpdate = prepareStatement.executeUpdate() > 0;
        if (isUpdate) {
            return true;
        }
        return false;
    }

    @Override
    public List<EmployeeProject> findAllEmployeeProjectById(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM `employee_project` where project_id="+id+" ");
        ArrayList<EmployeeProject> emptList = new ArrayList<>();
        while (rst.next()) {
            EmployeeProject employee=new EmployeeProject(rst.getLong("employee_id"), rst.getLong("project_id"));
            emptList.add(employee);
        }
        return emptList;
    }
    @Override
    public boolean findAllEmployeeProjectById(Long id,Long empId) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM `employee_project` where project_id="+id+" and employee_id="+empId+"  ");
        ArrayList<EmployeeProject> emptList = new ArrayList<>();
        while (rst.next()) {
            return true;
        }
        return false;
    }
    
}
