/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.repository.repositoryimpl;

import com.abc.abcsoftwarecompany.dbconnection.DBConnection;
import com.abc.abcsoftwarecompany.model.Role;
import com.abc.abcsoftwarecompany.model.User;
import com.abc.abcsoftwarecompany.repository.UserRepository;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author thamira
 */
public class UserRepositoryImpl implements UserRepository {

    @Override
    public User save(User user) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO `user`(`email`, `user_name`, `password`) VALUES (?,?,?)");
        prepareStatement.setObject(1, user.getEmail());
        prepareStatement.setObject(2, user.getUserName());
        String encode = new BCryptPasswordEncoder().encode(user.getPassword());
        prepareStatement.setObject(3,encode );
        boolean saved = prepareStatement.executeUpdate() > 0;

        if (saved) {
            User findUserByUserName = findUserByUserName(user.getUserName());
            return findUserByUserName;
        }

        return new User();
    }

    @Override
    public Boolean delete(Long Id) throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getConnection();

        Statement stm = connection.createStatement();
        String sql = "Delete From user where id=" + Id + "";
        return stm.executeUpdate(sql) > 0;

    }

    @Override
    public User upadate(User user,Long id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();

        PreparedStatement prepareStatement = connection.prepareStatement("UPDATE `user` SET `email`=?,`user_name`=?,`password`=? WHERE id=?");
        prepareStatement.setObject(4, id);
        prepareStatement.setObject(1, user.getEmail());
        prepareStatement.setObject(2, user.getUserName());
        prepareStatement.setObject(3, user.getPassword());
        boolean isUpdate = prepareStatement.executeUpdate() > 0;
        System.out.println(isUpdate);
        if (isUpdate) {
            return user;
        }
        return new User();
    }

    @Override
    public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * From user");
        ArrayList<User> userList = new ArrayList<>();
        while (rst.next()) {
            User user = new User(rst.getLong("id"), rst.getString("email"), rst.getString("user_name"), rst.getString("password"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public User findUserByUserId(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * From user where id="+id+"");
        while (rst.next()) {
            User user = new User(rst.getLong("id"), rst.getString("email"), rst.getString("user_name"), rst.getString("password"),rst.getLong("refid"));
            return user;
        }
        return new User();
    }

    @Override
    public User findUserByUserName(String name) throws ClassNotFoundException, SQLException {
       Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * From user where user_name = '"+name+"'");
        
        while (rst.next()) {
            User user = new User(rst.getLong("id"), rst.getString("email"), rst.getString("user_name"), rst.getString("password"),rst.getLong("refid"));
            return user;
        }
        return new User(); 
    }

    @Override
    public List<Role> getUserRoles(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM role INNER JOIN user_role ON role.id=user_role.role_id WHERE user_role.user_id="+id+"");
        ArrayList<Role> roleList = new ArrayList<>();
        while (rst.next()) {
            Role role = new Role(rst.getLong("id"), rst.getString("role"));
            roleList.add(role);
        }
        return roleList;
    }

    @Override
    public User saveByrefId(User user) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO `user`(`email`, `user_name`, `password`,refid) VALUES (?,?,?,?)");
        prepareStatement.setObject(1, user.getEmail());
        prepareStatement.setObject(2, user.getUserName());
//        prepareStatement.setObject(3, user.getPassword());
        prepareStatement.setObject(4, user.getRefid());
        
        String encode = new BCryptPasswordEncoder().encode(user.getPassword());
        
        prepareStatement.setObject(3,encode);
        boolean saved = prepareStatement.executeUpdate() > 0;

        if (saved) {
            User findUserByUserName = findUserByUserName(user.getUserName());
            return findUserByUserName;
        }

        return new User();
    }

}
