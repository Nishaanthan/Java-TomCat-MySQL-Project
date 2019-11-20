<%-- 
    Document   : employeepage
    Created on : Aug 13, 2017, 10:57:42 PM
    Author     : thamira
--%>

<%@page import="com.abc.abcsoftwarecompany.model.Employee"%>
<%@page import="com.abc.abcsoftwarecompany.model.User"%>
<%@page import="com.abc.abcsoftwarecompany.repository.repositoryimpl.EmployeeRepositoryImpl"%>
<%@page import="com.abc.abcsoftwarecompany.repository.EmployeeRepository"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    </head>
    <body>
        <%
            User logedUser = (User) session.getAttribute("logUser");
            EmployeeRepository er = new EmployeeRepositoryImpl();
            Employee cl = er.findEmployeeById(logedUser.getRefid());
        %>
        <div class="container">
            <div class="span3 well">


                <div>
                    <a class="btn btn-fill span3 well"href="logout">
                        <i class="glyphicon glyphicon-off"></i>
                        <p>logout</p>
                    </a>
                    <a class="btn btn-fill span3 well"href="requestpasword">
                        <i class="glyphicon glyphicon-user"></i>
                        <p>change password</p>
                    </a>
                </div>


            </div>

            <div class="span3 well">
                <center>
                    <a href="#aboutModal" data-toggle="modal" data-target="#myModal"><img src="assets/img/faces/face-1.jpg" name="aboutme" width="140" height="140" class="img-circle"></a>
                    <h3><%=cl.getFirstName()%></h3>
                    <em><%=cl.getPhone()%></em>
                </center>
            </div>
            <div class="span3 well">

                <table class="table table-hover">
                    <tr>

                        <td>
                    <center>Full name:</center> </td>
                    <td>
                        <%=cl.getFirstName()%> <%=cl.getLastName()%>
                    </td>

                    </tr>
                    <tr>

                        <td>
                    <center>Position:</center> </td>
                    <td>
                        <%=cl.getPosition()%>
                    </td>

                    </tr>
                </table>

            </div>
        </div>
    </body>
</html>