/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.repository.repositoryimpl;

import com.abc.abcsoftwarecompany.dbconnection.DBConnection;
import com.abc.abcsoftwarecompany.model.Client;
import com.abc.abcsoftwarecompany.model.Project;
import com.abc.abcsoftwarecompany.repository.ClientRepository;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thamiraˆ
 */
public class ClientRepositoryImpl implements ClientRepository {

    @Override
    public Client save(Client client) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO `client`(`name`, `company_name`, `phone`, `email`) VALUES (?,?,?,?)");
        prepareStatement.setObject(1, client.getName());
        prepareStatement.setObject(2, client.getCompanyName());
        prepareStatement.setObject(3, client.getPhone());
        prepareStatement.setObject(4, client.getEmail());
        boolean saved = prepareStatement.executeUpdate() > 0;
        if (saved) {          
            return findClientByClientName(client.getName());
        }
        return new Client(new Long(0));
    }

    @Override
    public Boolean delete(Long Id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();

        Statement stm = connection.createStatement();
        String sql = "Delete From client where client_id=" + Id + "";
        return stm.executeUpdate(sql) > 0;
    }

    @Override
    public Client upadate(Client client, Long Id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();

        PreparedStatement prepareStatement = connection.prepareStatement(" UPDATE `client` SET `name`=?,`company_name`=?,`phone`=?,`email`=? WHERE `client_id`=?");
        prepareStatement.setObject(5, Id);
        prepareStatement.setObject(1, client.getName());
        prepareStatement.setObject(2, client.getCompanyName());
        prepareStatement.setObject(3, client.getPhone());
        prepareStatement.setObject(4, client.getEmail());

        boolean isUpdate = prepareStatement.executeUpdate() > 0;
        if (isUpdate) {
            return client;
        }
        return new Client();

    }

    @Override
    public List<Client> findAll() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * From client");
        ArrayList<Client> clientList = new ArrayList<>();
        while (rst.next()) {
            Client client = new Client(rst.getLong("client_id"), rst.getString("name"), rst.getString("company_name"), rst.getString("phone"), rst.getString("email"));
            clientList.add(client);
        }
        return clientList;

    }

    @Override
    public List<Project> findAllProjectByClientId(Long Id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client findClientByClientName(String id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * From client where name='" + id + "'");
        while (rst.next()) {
            Client client = new Client(rst.getLong("client_id"), rst.getString("name"), rst.getString("company_name"), rst.getString("phone"), rst.getString("email"));
            return client;
        }
        return new Client();
    }

    @Override
    public Client findClientByClientId(Long Id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * From client where client_id=" + Id + "");
        while (rst.next()) {
            Client client = new Client(rst.getLong("client_id"), rst.getString("name"), rst.getString("company_name"), rst.getString("phone"), rst.getString("email"));
            return client;
        }
        return new Client();
    }

    @Override
    public Boolean isexst(String id) throws ClassNotFoundException, SQLException {
                Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * From client where name='" + id + "'");
        while (rst.next()) {
            return true;
            
        }
        return false;
    }

}
