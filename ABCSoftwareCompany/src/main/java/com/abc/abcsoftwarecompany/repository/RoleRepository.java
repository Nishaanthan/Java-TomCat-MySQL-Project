/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.repository;

import com.abc.abcsoftwarecompany.model.Role;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thamira
 */
public interface RoleRepository {

    Role save(Role role) throws ClassNotFoundException, SQLException;

    Boolean delete(Long Id) throws ClassNotFoundException, SQLException;

    Role upadate(Role role,Long Id) throws ClassNotFoundException, SQLException;

    List<Role> getAllRole() throws ClassNotFoundException, SQLException;

    Role findRoleByRoleName(String roleName) throws ClassNotFoundException, SQLException;

}
