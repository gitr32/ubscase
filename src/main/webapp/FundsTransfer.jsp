<%-- 
    Document   : FundsTransfer
    Created on : Jun 26, 2015, 7:30:44 PM
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
        <h5>Funds Transfer</h5>
        <table id='newTable' class='table table-bordered'>
            <tr>
                <th>
                    Account
                </th>
                <th>
                    Balance
                </th>
            </tr>
            <tr>
                <td>
                    1
                </td>
                <td id='acc1'>
                    1,000,000.00
                </td>
            </tr>
            <tr>
                <td>
                    2
                </td>
                <td id='acc2'>
                    500,000.00
                </td>
            </tr>
            <tr>
                <td>
                    3
                </td>
                <td>
                    200,000.00
                </td>
            </tr>
        </table>
        <br>


            <table class='table'>
                <tr>
                    <td>
                        Current Account:
                    </td>
                    <td>
                        Account 1
                    </td> 
                </tr>
                <tr>
                    <td>
                        Select an account to make a transfer to:
                        <br>
                        <select class='Dropdown'>
                            <option value='2'>Account2</option>
                            <option value='3'>Account3</option>
                        </select>
                    </td>
                    <td>
                        Amount
                        <br>
                        <input type='text' class='input-mini' name='amount'>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input class='btn' name='transferbtn' type='submit' value='Transfer'>
                    </td>
                </tr>
            </table>

        <script>
            $('[name="transferbtn"]').click(function () {
                document.getElementById('acc1').innerHTML = '998,000.00';
                document.getElementById('acc2').innerHTML = '502,000.00';
            });


        </script>
    </body>
</html>
