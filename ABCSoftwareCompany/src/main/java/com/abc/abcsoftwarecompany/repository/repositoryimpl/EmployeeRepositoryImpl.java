/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.repository.repositoryimpl;

import com.abc.abcsoftwarecompany.dbconnection.DBConnection;
import com.abc.abcsoftwarecompany.model.Employee;
import com.abc.abcsoftwarecompany.repository.EmployeeRepository;
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
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public Employee save(Employee employee) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO `Employee`(`position`, `phone`, `address`, `first_name`, `last_name`) VALUES (?,?,?,?,?)");
        prepareStatement.setObject(1, employee.getPosition());
        prepareStatement.setObject(2, employee.getPhone());
        prepareStatement.setObject(3, employee.getAddress());
        prepareStatement.setObject(4, employee.getFirstName());
        prepareStatement.setObject(5, employee.getLastName());
        boolean saved = prepareStatement.executeUpdate() > 0;
        if (saved) {
            return findEmployeeByname(employee.getFirstName());
        }
        return new Employee();
    }

    @Override
    public Boolean delete(Long Id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();

        Statement stm = connection.createStatement();
        String sql = "Delete From Employee where emp_id=" + Id + "";
        return stm.executeUpdate(sql) > 0;
    }

    @Override
    public Employee upadate(Employee employee, Long id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();

        PreparedStatement prepareStatement = connection.prepareStatement("UPDATE `Employee` SET `position`=?,`phone`=?,`address`=?,`first_name`=?,`last_name`=? WHERE `emp_id`=?");
        prepareStatement.setObject(6, id);
        prepareStatement.setObject(1, employee.getPosition() );
        prepareStatement.setObject(2, employee.getPhone());
        prepareStatement.setObject(3, employee.getAddress());
        prepareStatement.setObject(4, employee.getFirstName());
        prepareStatement.setObject(5, employee.getLastName());
        

        boolean isUpdate = prepareStatement.executeUpdate() > 0;
        if (isUpdate) {
            return employee;
        }
        return new Employee();
    }

    @Override
    public List<Employee> getAllEmployee() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * From Employee");
        ArrayList<Employee> emptList = new ArrayList<>();
        while (rst.next()) {
            Employee employee=new Employee(rst.getLong("emp_id"), rst.getString("position"), rst.getString("phone"), rst.getString("address"), rst.getString("first_name"), rst.getString("last_name"));
            emptList.add(employee);
        }
        return emptList;
    }

    @Override
    public Employee findEmployeeById(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * From Employee where emp_id='"+id+"'");
        while (rst.next()) {
            Employee employee=new Employee(rst.getLong("emp_id"), rst.getString("position"), rst.getString("phone"), rst.getString("address"), rst.getString("first_name"), rst.getString("last_name"));
            return employee;
        }
        return new Employee();
    }

    @Override
    public List<Employee> findEmployeeByEmployeeByfirstName(String name) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * From Employee where first_name='"+name+"'");
        ArrayList<Employee> emptList = new ArrayList<>();
        while (rst.next()) {
            Employee employee=new Employee(rst.getLong("emp_id"), rst.getString("position"), rst.getString("phone"), rst.getString("address"), rst.getString("first_name"), rst.getString("last_name"));
            emptList.add(employee);
        }
        return emptList;
    }

    @Override
    public Employee findEmployeeByname(String name) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * From Employee where first_name='"+name+"'");
        ArrayList<Employee> emptList = new ArrayList<>();
        while (rst.next()) {
            Employee employee=new Employee(rst.getLong("emp_id"), rst.getString("position"), rst.getString("phone"), rst.getString("address"), rst.getString("first_name"), rst.getString("last_name"));
            return employee;
        }
        return new Employee();

    }

    @Override
    public boolean isexist(String firstName, String lastName) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * From Employee where first_name='"+firstName+"' and last_name='"+lastName+"' ");
        ArrayList<Employee> emptList = new ArrayList<>();
        while (rst.next()) {
            return true;
        }
        return false;
    }

}
