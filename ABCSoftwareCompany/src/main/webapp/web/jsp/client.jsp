<%-- 
    Document   : client
    Created on : Aug 12, 2017, 5:45:33 PM
    Author     : thamira
--%>

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
            #client-form label.error {

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
                            <h1 style="color:black"><strong>Client</strong> Information</h1>
                            <div class="description" style="color:black">
                                <p>
                                    ABC Company Client Information.

                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>Client Details</h3>
                                </div>
                                <div class="form-top-right">
                                    <i class="fa fa-user"></i>
                                </div>
                            </div>
                            <div class="form-bottom">
                                <form role="form" action="AddClient" method="post" class="client-form" id="client-form">
                                    <div class="form-group">
                                        <label class="sr-only" for="formclientName">Name</label>
                                        <input type="text" name="formclientName" placeholder="Client Name.." class="formclientName form-control" id="formclientName">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="formclientCompanyName">Company Name</label>
                                        <input type="text" name="formclientCompanyName" placeholder="Company Name.." class="formclientCompanyName form-control" id="formclientCompanyName">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="formclientPhone">Phone Number</label>
                                        <input type="text" name="formclientPhone" placeholder="+9471556565.." class="formclientPhone form-control" id="formclientPhone">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="formclientEmail">Email</label>
                                        <input type="text" name="formclientEmail" placeholder="Test@gmail.com.." class="formclientEmail form-control" id="formclientEmail">
                                    </div>
                                    <button type="submit" class="btn">Submit Client Information</button>
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
        <script src="js/clientValidation.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="js/jquery.backstretch.min.js"></script>
        <script src="js/scripts.js"></script>

       

    </body>

</html>
