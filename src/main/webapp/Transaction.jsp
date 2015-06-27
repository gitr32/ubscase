<%-- 
    Document   : Transaction
    Created on : Jun 26, 2015, 7:29:49 PM
    Author     : r128
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" media="screen" href="bootstrap/css/bootstrap.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="bootstrap/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <title>Funds Transfer</title>
    </head>
    <body>
        <ul class='nav nav-pills'>
            <li class="dropdown">
                <a class="dropdown-toggle"
                   data-toggle="dropdown"
                   href="#">
                    Menu
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href='MainView.jsp'>Investing</a></li>
                    <li><a href='FundsTransfer.jsp'>Funds Transfer</a></li>
                    <li><a href='Transaction.jsp'>Transaction History</a></li>
                    <li><a href='Login.jsp'>Logout</a></li>
                </ul>
            </li>
        </ul>
        <h5>Transaction History</h5>
        <table class='table table-bordered'>
            <tr>
                <th>
                    Date
                </th>
                <th>
                    Amount
                </th>
                <th>
                    Purpose
                </th>
            </tr>
            <tr>
                 <td>
                    26/5/2015 20:49
                </td>
                <td>
                    2000.00
                </td>
                <td>
                    Funds Transfer
                </td>   
            </tr>
            <tr>
                <td>
                    26/5/2015 20:48
                </td>
                <td>
                    558,300.00
                </td>
                <td>
                    Investment
                </td>
            </tr>
        </table>
    </body>
</html>
