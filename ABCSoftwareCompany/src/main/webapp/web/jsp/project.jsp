<%-- 
    Document   : project
    Created on : Aug 12, 2017, 7:31:09 PM
    Author     : thamira
--%>

<%@page import="com.abc.abcsoftwarecompany.model.Client"%>
<%@page import="java.util.List"%>
<%@page import="com.abc.abcsoftwarecompany.repository.repositoryimpl.ClientRepositoryImpl"%>
<%@page import="com.abc.abcsoftwarecompany.repository.ClientRepository"%>
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
        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/jquery-ui.css">
        <style>
            #project-form label.error {

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
   <div class="navbar-header">
            <button type="button" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar bar1"></span>
                <span class="icon-bar bar2"></span>
                <span class="icon-bar bar3"></span>
            </button>
            <a class="navbar-brand" href="/ABCSoftwareCompany/Login">Home</a>
        </div>
        <!-- Top content -->
        <div class="top-content">

            <div class="inner-bg" style="padding: 0px;">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1 style="color:black"><strong>ABC Company</strong> Project Information</h1>
                            <div class="description" style="color:black">
                                <p>
                                    Add Project Information.

                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>Project Information</h3>

                                </div>
                                <div class="form-top-right">
                                    <i class="fa fa-tasks"></i>
                                </div>
                            </div>
                            <div class="form-bottom">
                                <form role="form" action="addProject" method="post" class="project-form" id="project-form">
                                    <div class="form-group">
                                        <label class="sr-only" for="formname">Project Name</label>
                                        <input type="text" name="formname" placeholder="Project Name..." class="formname form-control" id="formname">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="formClientName">Client Name</label>
                                        <select name="formClientName" id="formClientName" class="formClientName form-control">
                                            <option value="">Please Select project Client Name</option>
                                            <%
                                                List<Client> findAll = (List<Client>) request.getAttribute("clientList");
                                                for (Client client : findAll) {
                                                    out.println("<option value=\'" + client.getClientId() + "\'>" + client.getName() + "</option>");
                                                }
                                            %>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="formLevel">Level</label>
                                        <select name="formLevel" id="formLevel" class="formLevel form-control">
                                            <option value="">Please Select project Level</option>
                                            <option value="Short">Short</option>
                                            <option value="Long">Long</option>
                            
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="formStatus">Status</label>
                                        <select name="formStatus" id="formStatus" class="formStatus form-control">
                                            <option value="">Please Select project Status</option>
                                            <option value="Finished">Finished</option>
                                            <option value="Ongoing">OnGoing</option>
                                            <option value="Rejected">Rejected</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="formStartDate">Start Day</label>
                                        <input type="text" name="formStartDate" placeholder="Project Start Date..." class="formStartDate form-control" id="formStartDate">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="formEndDate">End Day</label>
                                        <input type="text" name="formEndDate" placeholder="Project End Date..." class="formEndDate form-control" id="formEndDate">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="formdescription">Description</label>

                                        <input type="text"  name="formdescription" placeholder="Project Description..." class="formdescription form-control" id="formdescription">

                                    </div>

                                    <button type="submit" class="btn">Submit Project Information!</button>
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
        <script src="js/projectValidation.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="js/jquery.backstretch.min.js"></script>
        <script src="js/scripts.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#formStartDate").datepicker();
                $("#formEndDate").datepicker();
            });

            $(document).ready(function () {
                $(".formClientName").select2();
            });
        </script>
        <!--[if lt IE 10]>
                <script src="assets/js/placeholder.js"></script>
            <![endif]-->

        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js"></script>
    </body>

</html>
