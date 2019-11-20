/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.repository;

import com.abc.abcsoftwarecompany.model.Role;
import com.abc.abcsoftwarecompany.model.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thamira
 */
public interface UserRepository {

    User save(User user) throws ClassNotFoundException, SQLException;
    User saveByrefId(User user) throws ClassNotFoundException, SQLException;

    Boolean delete(Long Id) throws ClassNotFoundException, SQLException;

    User upadate(User user,Long id) throws ClassNotFoundException, SQLException;

    List<User> getAllUsers() throws ClassNotFoundException, SQLException;

    User findUserByUserId(Long id) throws ClassNotFoundException, SQLException;
    
    User findUserByUserName(String name) throws ClassNotFoundException, SQLException;
    
    List<Role> getUserRoles(Long id) throws ClassNotFoundException, SQLException;
}
