/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author thamira
 */
public class Project implements Serializable {

    public Project() {
    }

    public Project(String lavel, String status, Date startDate, Date endDate, String description, String name, Long client_id) {
        this.lavel = lavel;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.name = name;
        this.client_id = client_id;
    }

    public Project(Long projectId, String lavel, String status, Date startDate, Date endDate, String description, String name, Long client_id) {
        this.projectId = projectId;
        this.lavel = lavel;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.name = name;
        this.client_id = client_id;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
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
     * @return the projectId
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * @return the lavel
     */
    public String getLavel() {
        return lavel;
    }

    /**
     * @param lavel the lavel to set
     */
    public void setLavel(String lavel) {
        this.lavel = lavel;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @return the employeeProjectList
     */
    public List<EmployeeProject> getEmployeeProjectList() {
        return employeeProjectList;
    }

    /**
     * @param employeeProjectList the employeeProjectList to set
     */
    public void setEmployeeProjectList(List<EmployeeProject> employeeProjectList) {
        this.employeeProjectList = employeeProjectList;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    private static long serialVersionUID = 1L;

    private Long projectId;

    private String lavel;

    private String status;

    private Date startDate;

    private Date endDate;

    private String description;

    private String name;

    private List<EmployeeProject> employeeProjectList;

    private Client client;
    
    private Long client_id;

}
