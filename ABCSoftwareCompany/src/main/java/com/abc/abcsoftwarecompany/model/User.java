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
public class User implements Serializable {

    public User(Long id, String email, String userName, String password, Long refid) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.refid = refid;
    }
    

    public User(Long id, String email, String userName, String password) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }



    private static long serialVersionUID = 1L;

    private Long id;

    private String email;

    private String userName;

    private String password;
    
    private Long refid;

    public Long getRefid() {
        return refid;
    }

    public void setRefid(Long refid) {
        this.refid = refid;
    }

    private List<Role> userRoleList;

    public User(String email, String userName, String password, Long refid) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.refid = refid;
    }
    
    

    public User(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public User() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        User.serialVersionUID = serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<Role> userRoleList) {
        this.userRoleList = userRoleList;
    }

    

}
