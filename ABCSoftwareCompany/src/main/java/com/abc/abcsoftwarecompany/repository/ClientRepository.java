/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.repository;

import com.abc.abcsoftwarecompany.model.Client;
import com.abc.abcsoftwarecompany.model.Project;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thamira
 */
public interface ClientRepository {

    Client save(Client client) throws ClassNotFoundException, SQLException;

    Boolean delete(Long Id) throws ClassNotFoundException, SQLException;

    Client upadate(Client client, Long Id) throws ClassNotFoundException, SQLException;

    List<Client> findAll() throws ClassNotFoundException, SQLException;

    List<Project> findAllProjectByClientId(Long Id) throws ClassNotFoundException, SQLException;
    
    Client findClientByClientName(String id) throws ClassNotFoundException, SQLException;

    Client findClientByClientId(Long Id) throws ClassNotFoundException, SQLException;
    Boolean isexst(String id) throws ClassNotFoundException, SQLException;

}
