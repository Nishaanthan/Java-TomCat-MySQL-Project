/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.controler;

import com.abc.abcsoftwarecompany.repository.ClientRepository;
import com.abc.abcsoftwarecompany.repository.repositoryimpl.ClientRepositoryImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.abc.abcsoftwarecompany.model.Client;
import com.abc.abcsoftwarecompany.model.Role;
import com.abc.abcsoftwarecompany.model.User;
import com.abc.abcsoftwarecompany.model.UserRole;
import com.abc.abcsoftwarecompany.repository.UserRepository;
import com.abc.abcsoftwarecompany.repository.UserRoleRepository;
import com.abc.abcsoftwarecompany.repository.repositoryimpl.UserRepositoryImpl;
import com.abc.abcsoftwarecompany.repository.repositoryimpl.UserRoleRepositoryImpl;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thamira
 */
@WebServlet(name = "AddClient", urlPatterns = {"/AddClient"})
public class AddClient extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            User logedUser = (User) session.getAttribute("logUser");
            if (logedUser != null) {
                List<Role> userRoleList = logedUser.getUserRoleList();
                for (Role role : userRoleList) {
                    if (role.getRole().equals("Admin")) {
                        String formclientName = request.getParameter("formclientName");
                        String[] split = formclientName.split("\\s+");
                        String formclientCompanyName = request.getParameter("formclientCompanyName");
                        String formclientPhone = request.getParameter("formclientPhone");
                        String formclientEmail = request.getParameter("formclientEmail");                       
                        ClientRepository clientRepository = new ClientRepositoryImpl();
                        if(!clientRepository.isexst(formclientName)){
                            Client client = clientRepository.save(new Client(formclientName, formclientCompanyName, formclientPhone, formclientEmail));
                        UserRepository user=new UserRepositoryImpl();
                        User us = user.saveByrefId(new User(formclientEmail, split[0].toLowerCase()+formclientPhone, formclientPhone,client.getClientId()));
                        UserRoleRepository repository=new UserRoleRepositoryImpl();  
                        repository.save(new UserRole(us.getId(), new Long(2)));
                        }
                               
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/clientlist");
                        dispatcher.forward(request, response);
                        
                        

                    }
                }
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/logout");
            dispatcher.forward(request, response);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
