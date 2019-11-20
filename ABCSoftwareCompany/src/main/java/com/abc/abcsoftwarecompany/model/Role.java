/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.model;

import java.io.Serializable;
import java.util.List;


/**
 *
 * @author thamira
 */

public class Role implements Serializable {

    public Role() {
    }

    public Role( String role) {
        this.role = role;
    }

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the userRoleList
     */
    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    /**
     * @param userRoleList the userRoleList to set
     */
    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    private static long serialVersionUID = 1L;
    
    private Long id;
   
    private String role;
    
    private List<UserRole> userRoleList;

    
    
}
