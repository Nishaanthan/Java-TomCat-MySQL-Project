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
public class Client implements Serializable {

    public Client(Long clientId) {
        this.clientId = clientId;
    }
    
    

    public Client(Long clientId, String name, String companyName, String phone, String email) {
        this.clientId = clientId;
        this.name = name;
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
    }

    public Client() {
    }

    public Client(String name, String companyName, String phone, String email) {
        this.name = name;
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
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
     * @return the clientId
     */
    public Long getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the projectList
     */
    public List<Project> getProjectList() {
        return projectList;
    }

    /**
     * @param projectList the projectList to set
     */
    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
    
    

    private static long serialVersionUID = 1L;
    
    private Long clientId;
    
    private String name;
    
    private String companyName;
    
    private String phone;
    
    private String email;
    
    private List<Project> projectList;

   
    
}
