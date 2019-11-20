/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.controler;

import com.abc.abcsoftwarecompany.model.User;
import com.abc.abcsoftwarecompany.model.UserRole;
import com.abc.abcsoftwarecompany.repository.UserRepository;
import com.abc.abcsoftwarecompany.repository.UserRoleRepository;
import com.abc.abcsoftwarecompany.repository.repositoryimpl.UserRepositoryImpl;
import com.abc.abcsoftwarecompany.repository.repositoryimpl.UserRoleRepositoryImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thamira
 */
@WebServlet(name = "Singup", urlPatterns = {"/Singup"})
public class Singup extends HttpServlet {

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

            String userName = request.getParameter("formusername");
            String password = request.getParameter("formpassword");
            String email = request.getParameter("formemail");
            UserRepository user = new UserRepositoryImpl();
            User findUserByUserName = user.findUserByUserName(userName);
            if (findUserByUserName.getId() == null) {
                user.save(new User(email, userName, password));
                UserRoleRepository repository = new UserRoleRepositoryImpl();
                User fuserName = user.findUserByUserName(userName);
                repository.save(new UserRole(fuserName.getId(), new Long(1)));
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.html");
            dispatcher.forward(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Singup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Singup.class.getName()).log(Level.SEVERE, null, ex);
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
