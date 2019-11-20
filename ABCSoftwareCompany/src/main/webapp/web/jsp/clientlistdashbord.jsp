<%-- 
    Document   : employeedashbord
    Created on : Aug 13, 2017, 12:24:22 PM
    Author     : thamira
--%>

<%@page import="com.abc.abcsoftwarecompany.model.Client"%>
<%@page import="com.abc.abcsoftwarecompany.model.Employee"%>
<%-- 
    Document   : dashbord
    Created on : Aug 13, 2017, 10:25:38 AM
    Author     : thamira
--%>

<%@page import="com.abc.abcsoftwarecompany.model.Project"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>Paper Dashboard by Creative Tim</title>

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />


        <!-- Bootstrap core CSS     -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

        <!-- Animation library for notifications   -->
        <link href="assets/css/animate.min.css" rel="stylesheet"/>

        <!--  Paper Dashboard core CSS    -->
        <link href="assets/css/paper-dashboard.css" rel="stylesheet"/>


        <!--  CSS for Demo Purpose, don't include it in your project     -->
        <link href="assets/css/demo.css" rel="stylesheet" />


        <!--  Fonts and icons     -->
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
        <link href="assets/css/themify-icons.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.jqueryui.min.css">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

    </head>
    <body>

        <div class="wrapper">
            <div class="sidebar" data-background-color="white" data-active-color="danger">

                <!--
                            Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
                            Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
                -->

                <div class="sidebar-wrapper">
                    <div class="logo">
                        <a href="#">
                            ABC COMPANY
                        </a>
                    </div>

                    <ul class="nav">
                        <li >
                            <a href="/ABCSoftwareCompany/Login">
                                <i class="ti-panel"></i>
                                <p>Project</p>
                            </a>
                        </li>
                        <li>
                            <a href="/ABCSoftwareCompany/Project">
                                <i class="ti-map"></i>
                                <p>Add Project</p>
                            </a>
                        </li>
                        <li>
                            <a href="/ABCSoftwareCompany/employee">
                                <i class="ti-user"></i>
                                <p>Add Employee</p>
                            </a>
                        </li>
                        <li >
                            <a href="#">
                                <i class="ti-view-list-alt"></i>
                                <p>Employee List</p>
                            </a>
                        </li>
                           <li>
                            <a href="/ABCSoftwareCompany/Client">
                                <i class="ti-user"></i>
                                <p>Add Client</p>
                            </a>
                        </li>
                         <li class="active">
                            <a href="/ABCSoftwareCompany/clientlist">
                                <i class="ti-view-list-alt"></i>
                                <p>Client List</p>
                            </a>
                        </li>
                         <li>
                            <a href="/ABCSoftwareCompany/SignUp.html">
                                <i class="glyphicon glyphicon-user"></i>
                                <p>Add Admin User</p>
                            </a>
                        </li>
                         <li>
                             <a href="/ABCSoftwareCompany/requestpasword">
                                <i class="glyphicon glyphicon-cog"></i>
                                <p>Change password</p>
                            </a>
                        </li>
                         <li>
                            <a href="/ABCSoftwareCompany/logout">
                                <i class="glyphicon glyphicon-off"></i>
                                <p>Log Out</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="main-panel">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar bar1"></span>
                                <span class="icon-bar bar2"></span>
                                <span class="icon-bar bar3"></span>
                            </button>
                            <a class="navbar-brand" href="#">Dashboard</a>
                        </div>

                    </div>
                </nav>


                <div class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <section class="content">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="box">
                                            <div class="box-header">
                                                <h3 class="box-title">Client List</h3>
                                            </div>
                                            <!-- /.box-header -->
                                            <div class="box-body">
                                                <table id="example2" class="table table-bordered table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th>Client Name</th>                                                        
                                                            <th>Company</th>
                                                            <th>Phone</th>
                                                            <th>Email</th>                                                          
                                                            <th>Edit</th>
                                                            <th>Delete</th>

                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <%

                                                            List<Client> findAll = (List<Client>) request.getAttribute("clientList");
                                                            for (Client client : findAll) {

                                                                out.println("<tr>\n"
                                                                        + " <td>" + client.getName()+ "</td>\n"
                                                                        + " <td>" + client.getCompanyName()+ "</td>\n"
                                                                        + " <td>" + client.getPhone() + "</td>\n"
                                                                        + " <td>" + client.getEmail()+ "</td>\n"                                     
                                                                        + "<td>\n"
                                                                        + "<form role=\"form\" action=\"EditClient\" method=\"post\" class=\"login-form\" id=\"login-form\">\n"
                                                                        + "<input type=\"hidden\" name=\"id\" value=\'" + client.getClientId()+ "\'>\n"
                                                                        + "\n"
                                                                        + "<p data-placement=\"top\" data-toggle=\"tooltip\" title=\"Edit\">\n"
                                                                        + "<button type=\"submit\" class=\"btn btn-primary btn-xs\" data-title=\"Edit\" data-toggle=\"modal\"  >\n"
                                                                        + "<span class=\"glyphicon glyphicon-pencil\"></span>\n"
                                                                        + "</button>\n"
                                                                        + "</p>\n"
                                                                        + "</form>\n"
                                                                        + " </td>"
                                                                        + "<td>\n"
                                                                        + "<form role=\"form\" action=\"deleteclient\" method=\"post\" class=\"login-form\" id=\"login-form\">\n"
                                                                        + "<input type=\"hidden\" name=\"id\" value=\'" + client.getClientId()+ "\'>\n"
                                                                        + "\n"
                                                                        + "<p data-placement=\"top\" data-toggle=\"tooltip\" title=\"Delete\">\n"
                                                                        + "<button type=\"submit\" class=\"btn btn-danger btn-xs\" data-title=\"Delete\" data-toggle=\"modal\"  >\n"
                                                                        + "<span class=\"glyphicon glyphicon-trash\"></span>\n"
                                                                        + "</button>\n"
                                                                        + "</p>\n"
                                                                        + "</form>\n"
                                                                        + " </td>"
                                                                        + "</tr>");

                                                            }

                                                        %>

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </div>

                    </div>
                </div>


                <footer class="footer">
                    <div class="container-fluid">
                        <nav class="pull-left">
                            <ul>

                                <li>
                                    <a href="http://www.creative-tim.com">
                                        Creative Tim
                                    </a>
                                </li>
                                <li>
                                    <a href="http://blog.creative-tim.com">
                                        Blog
                                    </a>
                                </li>
                                <li>
                                    <a href="http://www.creative-tim.com/license">
                                        Licenses
                                    </a>
                                </li>
                            </ul>
                        </nav>
                        <div class="copyright pull-right">
                            &copy; <script>document.write(new Date().getFullYear())</script>, made with <i class="fa fa-heart heart"></i> by <a href="http://www.creative-tim.com">Creative Tim</a>
                        </div>
                    </div>
                </footer>

            </div>
        </div>


    </body>

    <!--   Core JS Files   -->
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

    <!--  Checkbox, Radio & Switch Plugins -->
    <script src="assets/js/bootstrap-checkbox-radio.js"></script>

    <!--  Charts Plugin -->
    <script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
    <script src="assets/js/paper-dashboard.js"></script>

    <!-- Paper Dashboard DEMO methods, don't include it in your project! -->
    <script src="assets/js/demo.js"></script>

    <script type="text/javascript">
                                $(document).ready(function () {

                                    demo.initChartist();

                                    $.notify({
                                        icon: 'ti-gift',
                                        message: "Welcome to <b>Paper Dashboard</b> - a beautiful Bootstrap freebie for your next project."

                                    }, {
                                        type: 'success',
                                        timer: 4000
                                    });

                                });
    </script>

    <!-- Javascript -->
    <script src="js/jquery-1.11.1.min.js"></script>

    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/jquery.backstretch.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/dataTables.jqueryui.min.js"></script>

    <script>

                                $(document).ready(function () {
                                    $('#example2').DataTable();
                                });
    </script>
</html>



