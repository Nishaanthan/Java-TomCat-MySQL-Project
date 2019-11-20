<%-- 
    Document   : dashbord
    Created on : Aug 13, 2017, 10:25:38 AM
    Author     : thamira
--%>

<%@page import="com.abc.abcsoftwarecompany.model.Employee"%>
<%@page import="com.abc.abcsoftwarecompany.model.Client"%>
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
        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css" rel="stylesheet" />

        <!--  Fonts and icons     -->
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
        <link href="assets/css/themify-icons.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.jqueryui.min.css">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <style type="text/css">
            .feed-element img.img-circle,
            .dropdown-messages-box img.img-circle {
                width: 38px;
                height: 38px;
            }
        </style>
    </head>
    <body>

        <div class="wrapper">
            <div class="sidebar" data-background-color="white" data-active-color="danger">


                <div class="sidebar-wrapper">
                    <div class="logo">
                        <a href="#">
                            ABC COMPANY
                        </a>
                    </div>

                    <ul class="nav">
                        <li class="active">
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
                        <li>
                            <a href="/ABCSoftwareCompany/employeelist">
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
                        <li>
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
                            <div class="col-lg-4 col-md-5">
                                <div class="card card-user">
                                    <div class="image">
                                        <img src="assets/img/background.jpg" alt="..." />
                                    </div>
                                    <%
                                        Client client = (Client) request.getAttribute("client");
                                    %>
                                    <%
                                        Project project = (Project) request.getAttribute("project");
                                    %>
                                    <div class="content">
                                        <div class="author">
                                            <img class="avatar border-white" src="assets/img/faces/face-1.jpg" alt="..." />
                                            <h4 class="title"><%=client.getName()%><br />
                                                <a href="#"><small><%=client.getEmail()%></small></a>
                                            </h4>
                                        </div>
                                        <div>

                                            <dl class="dl-horizontal">


                                                <dt>Phone</dt>
                                                <dd> <%=client.getPhone()%></dd>
                                                <dt>Company</dt>
                                                <dd><%=client.getCompanyName()%></dd>

                                            </dl>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="text-center">

                                    </div>
                                </div>
                                <div class="card">
                                    <div class="header">
                                        <h4 class="title">Team Members</h4>
                                    </div>
                                    <div class="content">
                                        <ul class="list-unstyled team-members">
                                            <%
                                                List<Employee> allEmployee = (List<Employee>) request.getAttribute("selectEmployee");
                                                for (Employee employee : allEmployee) {

                                                    out.println("<li>\n"
                                                            + "<div class=\"row\">\n"
                                                            + "<div class=\"col-xs-3\">\n"
                                                            + "<div class=\"avatar\">\n"
                                                            + "<img src=\"assets/img/faces/face-0.jpg\" alt=\"Circle Image\" class=\"img-circle img-no-padding img-responsive\">\n"
                                                            + "</div>\n"
                                                            + "</div>\n"
                                                            + "<div class=\"col-xs-6\">\n"
                                                            + employee.getFirstName() + " " + employee.getLastName()
                                                            + "<br />\n"
                                                            + "<span class=\"text-muted\"><small>" + employee.getPhone() + "</small></span>\n"
                                                            + "</div>\n"
                                                            + "<div class=\"col-xs-3 text-right\">\n");%>
                                            <form action="removeasignemployee" method="POST">
                                                <input type="hidden" name="empid" value="<%=employee.getEmpId()%>">
                                                <input type="hidden" name="projectid" value="<%=project.getProjectId()%>">
                                                <button class="btn btn-sm btn-danger btn-icon"><i class="fa fa-remove"></i></button>
                                            </form>
                                            <%out.println("</div>\n"
                                                            + "</div>\n"
                                                            + "</li>");
                                                }
                                            %>
                                        </ul>
                                    </div>
                                </div>


                            </div>
                            <div class="col-lg-8 col-md-7 ">
                                <div class="card">
                                    <div class="header">
                                        <h4 class="title">Project Profile</h4>
                                    </div>
                                    <div class="content">

                                        <div class="row">
                                            <div class="col-lg-12">
                                                <form action="addemployeetoproject" method="POST">
                                                    <input type="hidden" name="id" value="<%=project.getProjectId()%>"/>

                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="form-group">

                                                                <label>Add Employee</label>

                                                                <select name="formemployee" id="formClientName" class="formClientName form-control">
                                                                    <option value="hgf">Please Select project Client Name</option>
                                                                    <%
                                                                        List<Employee> findAll = (List<Employee>) request.getAttribute("employeelist");
                                                                        for (Employee emp : findAll) {
                                                                            out.println("<option value=\'" + emp.getEmpId() + "\'>" + emp.getFirstName() + " " + emp.getLastName() + "</option>");
                                                                        }
                                                                    %>
                                                                </select>

                                                            </div>
                                                            <div class="form-group">
                                                                <input type="submit" class="btn btn-success"/>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="card">
                                    <div class="header">
                                        <h4 class="title">Project Profile</h4>
                                    </div>

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
                                                    <dt>Completed:</dt>
                                                    <dd>
                                                        <div class="progress progress-striped active m-b-sm">
                                                            <div style="width: 60%;" class="progress-bar"></div>
                                                        </div>
                                                        <small><%=project.getDescription()%></small>
                                                    </dd>
                                                </dl>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
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
    <script src="js/jquery.validate.js"></script>
    <script src="js/projectValidation.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/jquery.backstretch.min.js"></script>
    <script src="js/scripts.js"></script>
    <script src="js/jquery-ui.js"></script>
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
                                $(document).ready(function () {
                                    $(".formClientName").select2();
                                });
    </script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js"></script>
</html>

