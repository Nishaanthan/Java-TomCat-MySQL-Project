/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.repository.repositoryimpl;

import com.abc.abcsoftwarecompany.dbconnection.DBConnection;
import com.abc.abcsoftwarecompany.model.Role;
import com.abc.abcsoftwarecompany.repository.RoleRepository;
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
public class RoleRepositoryImpl implements RoleRepository{

    @Override
    public Role save(Role role) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO `role`(`role`) VALUES (?)");
        prepareStatement.setObject(1, role.getRole());
        boolean saved = prepareStatement.executeUpdate() > 0;

        if (saved) {
            return role;
        }

        return new Role();
    }

    @Override
    public Boolean delete(Long Id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();

        Statement stm = connection.createStatement();
        String sql = "Delete From role where id=" + Id + "";
        return stm.executeUpdate(sql) > 0;
    }

    @Override
    public Role upadate(Role role, Long Id) throws ClassNotFoundException, SQLException {
       Connection connection = DBConnection.getConnection();

        PreparedStatement prepareStatement = connection.prepareStatement(" UPDATE `role` SET `role`=? WHERE id=?");
        prepareStatement.setObject(2, Id);
        prepareStatement.setObject(1, role.getRole());

        boolean isUpdate = prepareStatement.executeUpdate() > 0;
        if (isUpdate) {
            return role;
        }
        return new Role();
    }

    @Override
    public List<Role> getAllRole() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * From role");
        ArrayList<Role> roleList = new ArrayList<>();
        while (rst.next()) {
            Role role = new Role(rst.getLong("id"), rst.getString("role"));
            roleList.add(role);
        }
        return roleList;
    }

    @Override
    public Role findRoleByRoleName(String roleName) throws ClassNotFoundException, SQLException {
        
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * From role where role='"+roleName+"'");
        ArrayList<Role> userList = new ArrayList<>();
        while (rst.next()) {
            Role role = new Role(rst.getLong("id"), rst.getString("role"));
            return role;
        }
        return new Role();
    }
}
