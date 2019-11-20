/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.controler;

import com.abc.abcsoftwarecompany.model.Role;
import com.abc.abcsoftwarecompany.model.User;
import com.abc.abcsoftwarecompany.repository.UserRepository;
import com.abc.abcsoftwarecompany.repository.repositoryimpl.UserRepositoryImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author thamira
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
          
            if (logedUser == null) {
                  
                if (request.getParameter("formusername") == null && request.getParameter("formpassword") == null) {
                    
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/web/jsp/index.jsp");
                    dispatcher.forward(request, response);
                }
                String userName = request.getParameter("formusername");
                String password = request.getParameter("formpassword");
                String encode = new BCryptPasswordEncoder().encode(password);
                
                
                UserRepository user = new UserRepositoryImpl();
                User logUser = user.findUserByUserName(userName);
                List<Role> userRoles = user.getUserRoles(logUser.getId());
                logUser.setUserRoleList(userRoles);
                boolean equal=new BCryptPasswordEncoder().matches(password,logUser.getPassword());
                if (!equal && !userName.equals(logUser.getUserName())) {
                    
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/web/jsp/index.jsp");
                    dispatcher.forward(request, response);
                } else {
                    
                    for (Role userRole : userRoles) {
                        System.out.println("adjaskdksad"+userRole.getRole()+equal);
                        if (userRole.getRole().equals("Admin") && equal && userName.equals(logUser.getUserName())) {
                            System.out.println(password+" jjj "+logUser.getPassword());
                            session.setAttribute("logUser", logUser);
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/projectlist");
                            dispatcher.forward(request, response);
                        }
                    }
                    for (Role userRole : userRoles) {

                        if (userRole.getRole().equals("Client") && equal && userName.equals(logUser.getUserName())) {
                            session.setAttribute("logUser", logUser);
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/clientpage");
                            dispatcher.forward(request, response);
                        }
                    }
                    for (Role userRole : userRoles) {

                        if (userRole.getRole().equals("Employee") && equal && userName.equals(logUser.getUserName())) {
                            session.setAttribute("logUser", logUser);
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/employeepage");
                            dispatcher.forward(request, response);
                        }
                    }

                }

            } else {
                User logUser = logedUser;
                List<Role> userRoles = logedUser.getUserRoleList();
                for (Role userRole : userRoles) {

                    if (userRole.getRole().equals("Admin")) {
                        session.setAttribute("logUser", logUser);
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/projectlist");
                        dispatcher.forward(request, response);
                    }
                }
                for (Role userRole : userRoles) {

                    if (userRole.getRole().equals("Client")) {
                        session.setAttribute("logUser", logUser);
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/clientpage");
                        dispatcher.forward(request, response);
                    }
                }
                for (Role userRole : userRoles) {

                    if (userRole.getRole().equals("Employee")) {
                        session.setAttribute("logUser", logUser);
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/employeepage");
                        dispatcher.forward(request, response);
                    }
                }
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/web/jsp/index.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
