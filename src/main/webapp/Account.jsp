<%-- 
    Document   : Account
    Created on : Jun 26, 2015, 8:23:27 PM
    Author     : r128
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="com.ubscase.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" media="screen" href="bootstrap/css/bootstrap.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="bootstrap/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <title>Account</title>
    </head>
    <body>
        <%
            String username = (String) session.getAttribute("username");
            if (username == null) {
                RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                rd.forward(request, response);
            }
        %>

        <ul class='nav nav-pills'>
            <li class="dropdown">
                <a class="dropdown-toggle"
                   data-toggle="dropdown"
                   href="#">
                    Menu
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href='Account.jsp'>Accounts</a></li>
                    <li><a href='MainView.jsp'>Investing</a></li>
                    <li><a href='FundsTransfer.jsp'>Funds Transfer</a></li>
                    <li><a href='Transaction.jsp'>Transaction History</a></li>
                    <li><a href='Login.jsp'>Logout</a></li>
                </ul>
            </li>

        </ul>

        <%
            
            AccountList accounts = new AccountList(username);
            ArrayList<Account> accountList = accounts.retrieveAccounts();
        %>
        <form action='select_account.do' method='POST'>
            <table class='table table-hover'>
                <tr>
                    <th>
                    </th>
                    <th>
                        Account No
                    </th>
                    <th>
                        Balance
                    </th>
                    <%
                        int i = 0;
                        DecimalFormat df = new DecimalFormat("###,###.00");
                        for (Account a : accountList) {
                            out.println("<tr>");
                            out.println("<td><input name='selected' type='radio' value='" + i + "'/>");
                            out.println("<td>");
                            out.println(a.getAccountNo());
                            out.println("</td>");
                            out.println("<td>");
                            out.println(df.format(a.getBalance()));
                            out.println("</td>");
                            out.println("</tr>");
                            i++;
                        }
                    %>

            </table>
            <br>
            <input class='btn' type='submit' value='Select Account'>
        </form>
    </body>
</html>
