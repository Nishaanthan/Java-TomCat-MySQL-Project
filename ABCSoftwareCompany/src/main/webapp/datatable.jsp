<%-- 
    Document   : datatable
    Created on : Aug 12, 2017, 9:13:47 PM
    Author     : thamira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.jqueryui.min.css">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    </head>
    <body>
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Hover Data Table</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example2" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Nic Number</th>
                                        <th>Full Name</th>
                                        <th>Mobile Number</th>
                                        <th>Address</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>jahdsa</td>
                                        <td>dasdasd</td>
                                        <td>dsadsd</td>
                                        <td>asdsad</td>
                                    </tr>
                                    <tr>
                                        <td>jahdsa</td>
                                        <td>dasdasd</td>
                                        <td>dsadsd</td>
                                        <td>asdsad</td>
                                    </tr>
                                    <tr>
                                        <td>jahdsa</td>
                                        <td>dasdasd</td>
                                        <td>dsadsd</td>
                                        <td>asdsad</td>
                                    </tr>
                                    <tr>
                                        <td>jahdsa</td>
                                        <td>dasdasd</td>
                                        <td>dsadsd</td>
                                        <td>asdsad</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>



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

    </body>
</html>
