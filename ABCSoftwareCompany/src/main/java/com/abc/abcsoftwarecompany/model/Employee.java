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
public class Employee implements Serializable {

    public Employee() {
    }

    public Employee(String position, String phone, String address, String firstName, String lastName) {
        this.position = position;
        this.phone = phone;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(Long empId, String position, String phone, String address, String firstName, String lastName, List<EmployeeProject> employeeProjectList) {
        this.empId = empId;
        this.position = position;
        this.phone = phone;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeProjectList = employeeProjectList;
    }

    public Employee(Long empId, String position, String phone, String address, String firstName, String lastName) {
        this.empId = empId;
        this.position = position;
        this.phone = phone;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
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
     * @return the empId
     */
    public Long getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    private static long serialVersionUID = 1L;

    private Long empId;

    private String position;

    private String phone;

    private String address;

    private String firstName;

    private String lastName;

    private List<EmployeeProject> employeeProjectList;

}
