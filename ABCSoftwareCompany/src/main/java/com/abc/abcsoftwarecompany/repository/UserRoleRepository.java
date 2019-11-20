/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.repository;

import com.abc.abcsoftwarecompany.model.User;
import com.abc.abcsoftwarecompany.model.UserRole;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thamira
 */
public interface UserRoleRepository {

    UserRole save(UserRole user) throws ClassNotFoundException, SQLException;

    Boolean deleteUser(Long Id) throws ClassNotFoundException, SQLException;

    Boolean deleteRole(Long Id) throws ClassNotFoundException, SQLException;

    Boolean upadate(Long userId,Long RoleId ) throws ClassNotFoundException, SQLException;

}
