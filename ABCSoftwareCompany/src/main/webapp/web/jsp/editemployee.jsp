<%-- 
    Document   : editemployee
    Created on : Aug 13, 2017, 8:47:01 AM
    Author     : thamira
--%>

<%@page import="com.abc.abcsoftwarecompany.model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap Login Form Template</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/form-elements.css">
        <link rel="stylesheet" href="css/style.css">
        <style>
            #Employee-form label.error {

                display: inline;
            }

        </style>               
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>
        <%
        Employee findEmployeeById=(Employee)request.getAttribute("editemployee");
        %>
        <!-- Top content -->
           <div class="navbar-header">
            <button type="button" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar bar1"></span>
                <span class="icon-bar bar2"></span>
                <span class="icon-bar bar3"></span>
            </button>
            <a class="navbar-brand" href="/ABCSoftwareCompany/Login">Home</a>
        </div>
        <div class="top-content">

            <div class="inner-bg" style="padding: 0px;">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1 style="color:black"><strong>Employee</strong>Information</h1>
                            <div class="description" style="color:black">
                                <p>
                                    Employee in Information. 

                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box" >
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>Employee Details</h3>

                                </div>
                                <div class="form-top-right">
                                    <i class="fa fa-lock"></i>
                                </div>
                            </div>
                            <div class="form-bottom">
                                <form role="form" action="submiteditemployee" method="post" class="Employee-form" id="Employee-form">
                                    <input value="<%=findEmployeeById.getEmpId()%>"type="hidden" name="id">
                                    <div class="form-group">
                                        <label class="sr-only" for="formemployeefirstname">Employee First Name</label>
                                        <input value="<%=findEmployeeById.getFirstName()%>"type="text" name="formemployeefirstname" placeholder="Employee First Name..." class="formemployeefirstname form-control" id="formemployeefirstname">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="formemployeelastname">Employee Last Name</label>
                                        <input value="<%=findEmployeeById.getLastName()%>" type="text" name="formemployeelastname" placeholder="Employee Last Name..." class="formemployeelastname form-control" id="formemployeelastname">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="sr-only" for="formemployeephone">Phone</label>
                                        <input type="text" value="<%=findEmployeeById.getPhone()%>" name="formemployeephone" placeholder="Employee phone..." class="formemployeephone form-control" id="formemployeephone">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="formemployeeaddress">Address</label>
                                        <input value="<%=findEmployeeById.getAddress()%>" type="text" name="formemployeeaddress" placeholder="Employee Address..." class="formemployeeaddress form-control" id="formemployeeaddress">
                                    </div>
                    
                                     <div class="form-group">
                                        <label class="sr-only" for="formStatus">Status</label>
                                        <select name="employeepossition" id="formStatus" class="formStatus form-control">
                                            <option value="<%=findEmployeeById.getPosition()%>"><%=findEmployeeById.getPosition()%></option>
                                            <option value="programmer">Programmer</option>
                                            <option value="programmeranalyst">Programmer Analyst</option>
                                            <option value="securityspecialist">Security Specialist</option>
                                            <option value="seniorapplicationsengineer">Senior Applications Engineer</option>
                                            <option value="senioraatabaseadministrator">Senior Database Administrator</option>
                                            <option value="seniornetworkarchitect">Senior Network Architect</option>
                                            <option value="seniornetworkengineer">Senior Network Engineer</option>
                                        </select>
                                    </div>

                                    <button type="submit" class="btn">Submit Employee Information</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>


        <!-- Javascript -->
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/jquery.validate.js"></script>
        <script src="js/employeeValidation.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="js/jquery.backstretch.min.js"></script>
        <script src="js/scripts.js"></script>

        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>

