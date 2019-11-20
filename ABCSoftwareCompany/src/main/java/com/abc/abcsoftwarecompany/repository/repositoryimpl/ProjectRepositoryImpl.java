/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.repository.repositoryimpl;

import com.abc.abcsoftwarecompany.dbconnection.DBConnection;
import com.abc.abcsoftwarecompany.model.Client;
import com.abc.abcsoftwarecompany.model.Employee;
import com.abc.abcsoftwarecompany.model.Project;
import com.abc.abcsoftwarecompany.repository.ProjectRepository;
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
public class ProjectRepositoryImpl implements ProjectRepository {

    @Override
    public Project save(Project project) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO `project`(`client_id`, `lavel`, `status`, `start_date`, `end_date`, `description`, `name`) VALUES (?,?,?,?,?,?,?)");
        prepareStatement.setObject(1, project.getClient_id());
        prepareStatement.setObject(2, project.getLavel());
        prepareStatement.setObject(3, project.getStatus());
        prepareStatement.setObject(4, project.getStartDate());
        prepareStatement.setObject(5, project.getEndDate());
        prepareStatement.setObject(6, project.getDescription());
        prepareStatement.setObject(7, project.getName());

        boolean saved = prepareStatement.executeUpdate() > 0;
        if (saved) {
            return project;
        }
        return new Project();
    }

    @Override
    public Boolean delete(Long Id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        String sql = "Delete From project where project_id=" + Id + "";
        return stm.executeUpdate(sql) > 0;
    }

    @Override
    public Project upadate(Project project, Long Id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();

        PreparedStatement prepareStatement = connection.prepareStatement("UPDATE `project` SET `client_id`=?,`lavel`=?,`status`=?,`start_date`=?,`end_date`=?,`description`=?,`name`=? where project_id=?");
        prepareStatement.setObject(1, project.getClient_id());
        prepareStatement.setObject(2, project.getLavel());
        prepareStatement.setObject(3, project.getStatus());
        prepareStatement.setObject(4, project.getStartDate());
        prepareStatement.setObject(5, project.getEndDate());
        prepareStatement.setObject(6, project.getDescription());
        prepareStatement.setObject(7, project.getName());
        prepareStatement.setObject(8, Id);

        boolean isUpdate = prepareStatement.executeUpdate() > 0;
        if (isUpdate) {
            return project;
        }
        return new Project();
    }

    @Override
    public List<Project> getAllProject() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM `project`");
        ArrayList<Project> projectList = new ArrayList<>();
        while (rst.next()) {
            Project project = new Project(rst.getLong("project_id"),
                    rst.getString("lavel"),
                    rst.getString("status"),
                    rst.getDate("start_date"),
                    rst.getDate("end_date"),
                    rst.getString("description"),
                    rst.getString("name"),
                    rst.getLong("client_id")
            );
            projectList.add(project);

        }
        return projectList;
    }

    @Override
    public Project findProjectByProjectName(String projectName) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM `project` where name='" + projectName + "'");

        while (rst.next()) {
            Project project = new Project(rst.getLong("project_id"),
                    rst.getString("lavel"),
                    rst.getString("status"),
                    rst.getDate("start_date"),
                    rst.getDate("end_date"),
                    rst.getString("description"),
                    rst.getString("name"),
                    rst.getLong("client_id")
            );

            return project;
        }
        return new Project();
    }

    @Override
    public Project findProjectByProjectId(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM `project` where project_id=" + id + "");

        while (rst.next()) {
            Project project = new Project(rst.getLong("project_id"),
                    rst.getString("lavel"),
                    rst.getString("status"),
                    rst.getDate("start_date"),
                    rst.getDate("end_date"),
                    rst.getString("description"),
                    rst.getString("name"),
                    rst.getLong("client_id")
            );

            return project;
        }
        return new Project();
    }

    @Override
    public Client findClientByProjId(Long id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> findEmployeeByProjectId(Long id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT *\n"
                + "FROM Employee \n"
                + "INNER JOIN employee_project\n"
                + "ON Employee.emp_id=employee_project.employee_id where employee_project.project_id="+id+" ";
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Employee> emptList = new ArrayList<>();
        while (rst.next()) {
            Employee employee=new Employee(rst.getLong("emp_id"), rst.getString("position"), rst.getString("phone"), rst.getString("address"), rst.getString("first_name"), rst.getString("last_name"));
            emptList.add(employee);
        }
        return emptList;
        
    }

    @Override
    public Project findProjectByClientId(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM `project` where client_id=" + id + "");

        while (rst.next()) {
            Project project = new Project(rst.getLong("project_id"),
                    rst.getString("lavel"),
                    rst.getString("status"),
                    rst.getDate("start_date"),
                    rst.getDate("end_date"),
                    rst.getString("description"),
                    rst.getString("name"),
                    rst.getLong("client_id")
            );

            return project;
        }
        return new Project();
    }

}
