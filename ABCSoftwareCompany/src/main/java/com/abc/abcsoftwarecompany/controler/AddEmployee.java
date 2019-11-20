/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.controler;

import com.abc.abcsoftwarecompany.model.Employee;
import com.abc.abcsoftwarecompany.model.Role;
import com.abc.abcsoftwarecompany.model.User;
import com.abc.abcsoftwarecompany.model.UserRole;
import com.abc.abcsoftwarecompany.repository.EmployeeRepository;
import com.abc.abcsoftwarecompany.repository.UserRepository;
import com.abc.abcsoftwarecompany.repository.UserRoleRepository;
import com.abc.abcsoftwarecompany.repository.repositoryimpl.EmployeeRepositoryImpl;
import com.abc.abcsoftwarecompany.repository.repositoryimpl.UserRepositoryImpl;
import com.abc.abcsoftwarecompany.repository.repositoryimpl.UserRoleRepositoryImpl;
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

/**
 *
 * @author thamira
 */
@WebServlet(name = "AddEmployee", urlPatterns = {"/addemployee"})
public class AddEmployee extends HttpServlet {

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
                        String formemployeefirstname = request.getParameter("formemployeefirstname");
                        String formemployeelastname = request.getParameter("formemployeelastname");
                        String formemployeephone = request.getParameter("formemployeephone");
                        String formemployeeaddress = request.getParameter("formemployeeaddress");
                        String employeepossition = request.getParameter("employeepossition");
                        String[] split = formemployeefirstname.split("\\s+");

                        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
                        if (!employeeRepository.isexist(formemployeefirstname, formemployeelastname)) {

                            Employee emp = employeeRepository.save(new com.abc.abcsoftwarecompany.model.Employee(employeepossition, formemployeephone, formemployeeaddress, formemployeefirstname, formemployeelastname));

                            UserRepository user = new UserRepositoryImpl();
                            User us = user.saveByrefId(new User(formemployeelastname + "@example.com", split[0].toLowerCase() + formemployeephone, formemployeephone, emp.getEmpId()));

                            UserRoleRepository repo = new UserRoleRepositoryImpl();
                            repo.save(new UserRole(us.getId(), new Long(3)));
                        }

                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/employeelist");
                        dispatcher.forward(request, response);

                    }
                }
            }

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/web/jsp/index.jsp");
            dispatcher.forward(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
