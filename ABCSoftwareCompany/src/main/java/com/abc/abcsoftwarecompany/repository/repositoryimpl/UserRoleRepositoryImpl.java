/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.repository.repositoryimpl;

import com.abc.abcsoftwarecompany.dbconnection.DBConnection;
import com.abc.abcsoftwarecompany.model.UserRole;
import com.abc.abcsoftwarecompany.repository.UserRoleRepository;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author thamira
 */
public class UserRoleRepositoryImpl implements UserRoleRepository {

    @Override
    public UserRole save(UserRole user) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO `user_role`(`user_id`, `role_id`) VALUES (?,?)");
        prepareStatement.setObject(1, user.getUserId());
        prepareStatement.setObject(2, user.getRoleId());
        boolean saved = prepareStatement.executeUpdate() > 0;

        if (saved) {
            return user;
        }

        return new UserRole();
    }

    @Override
    public Boolean deleteUser(Long Id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();

        Statement stm = connection.createStatement();
        String sql = "Delete From user_role where user_id=" + Id + "";
        return stm.executeUpdate(sql) > 0;
    }

    @Override
    public Boolean deleteRole(Long Id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();

        Statement stm = connection.createStatement();
        String sql = "Delete From user_role where role_id=" + Id + "";
        return stm.executeUpdate(sql) > 0;
    }

    @Override
    public Boolean upadate(Long userId, Long RoleId) throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getConnection();

        PreparedStatement prepareStatement = connection.prepareStatement(" UPDATE `user_role` SET `role_id`=? WHERE `user_id`=?");
        prepareStatement.setObject(2, userId);
        prepareStatement.setObject(1, RoleId);

        boolean isUpdate = prepareStatement.executeUpdate() > 0;
        if (isUpdate) {
            return true;
        }
        return false;

    }

}
