/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.abcsoftwarecompany.controler;

import com.abc.abcsoftwarecompany.repository.ProjectRepository;
import com.abc.abcsoftwarecompany.repository.repositoryimpl.ProjectRepositoryImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
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
@WebServlet(name = "SubmitEditProject", urlPatterns = {"/SubmitEditProject"})
public class SubmitEditProject extends HttpServlet {

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
            String id=request.getParameter("id");
            String formname = request.getParameter("formname");
            String formClientName = request.getParameter("formClientName");
            String formLevel = request.getParameter("formLevel");
            String formStatus = request.getParameter("formStatus");
            String formStartDate = request.getParameter("formStartDate");
            String formEndDate = request.getParameter("formEndDate");
            String formdescription = request.getParameter("formdescription");
            Date startDate = new Date(formStartDate);
            Date endDate = new Date(formEndDate);
            ProjectRepository repository = new ProjectRepositoryImpl();
            repository.upadate(new com.abc.abcsoftwarecompany.model.Project(new Long(id),formLevel, formStatus, startDate, endDate, formdescription, formname, new Long(formClientName)),new Long(id));
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SubmitEditProject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SubmitEditProject.class.getName()).log(Level.SEVERE, null, ex);
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
