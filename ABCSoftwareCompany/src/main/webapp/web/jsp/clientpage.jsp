<%-- 
    Document   : clientpage
    Created on : Aug 13, 2017, 10:49:58 PM
    Author     : thamira
--%>

<%@page import="com.abc.abcsoftwarecompany.model.Project"%>
<%@page import="com.abc.abcsoftwarecompany.repository.repositoryimpl.ProjectRepositoryImpl"%>
<%@page import="com.abc.abcsoftwarecompany.repository.ProjectRepository"%>
<%@page import="com.abc.abcsoftwarecompany.model.Client"%>
<%@page import="com.abc.abcsoftwarecompany.repository.repositoryimpl.ClientRepositoryImpl"%>
<%@page import="com.abc.abcsoftwarecompany.repository.ClientRepository"%>
<%@page import="com.abc.abcsoftwarecompany.model.User"%>
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
            ClientRepository cli = new ClientRepositoryImpl();
            Client cl = cli.findClientByClientId(logedUser.getRefid());
            ProjectRepository pr = new ProjectRepositoryImpl();
            Project project = (Project) pr.findProjectByClientId(cl.getClientId());
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
                    <h3><%=cl.getName()%></h3>
                    <h4><%=cl.getPhone()%></h4>
                    <h4><%=cl.getEmail()%></h4>
                    <h4><%=cl.getCompanyName()%></h4>
                </center>
            </div>
        </div>
        <div class="container">
            <div class="span3 well">
                <div class="card">
                    <center>
                        <div class="header">
                            <h2 class="title">Project Profile</h2>
                        </div>

                        <br>
                        <br>
                        <img src="https://www.instantassignmenthelp.com.au/images/data/page_upload/images/project-management_5727329b877ba.jpg?t=1462186659068">
                        <br>
                        <br>
                        <div class="content">
                            <div class="row">
                                <div class="col-lg-5">
                                    <dl class="dl-horizontal">

                                        <dt>Project name:</dt>
                                        <dd><%=project.getName()%></dd>

                                        <dt>Level:</dt>
                                        <dd><%=project.getLavel()%></dd>
                                        <dt>Status:</dt>
                                        <dd> <%=project.getStatus()%> </dd>
                                    </dl>
                                </div>
                                <div class="col-lg-7" id="cluster_info">
                                    <dl class="dl-horizontal">

                                        <dt>Start Date:</dt>
                                        <dd><%=project.getStartDate()%></dd>
                                        <dt>End Date:</dt>
                                        <dd> <%=project.getEndDate()%></dd>
                                        <dt>Employee:</dt>
                                    </dl>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <dl class="dl-horizontal">
                                        <dt>Description</dt>
                                        <dd>

                                            <small><%=project.getDescription()%></small>
                                        </dd>
                                    </dl>
                                </div>
                            </div>
                        </div>
                    </center>
                </div>
            </div>
        </div>
    </body>
</html>
