<%-- 
    Document   : FundsTransfer
    Created on : Jun 26, 2015, 7:30:44 PM
    Author     : r128
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="com.ubscase.model.*"%>
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
        <%
            String username = (String) session.getAttribute("username");
            if(username == null) {
                RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                rd.forward(request,response);
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
            <%
                DecimalFormat df = new DecimalFormat("###,###.00");
                Account curAccount = (Account) session.getAttribute("account");
                AccountList accounts = new AccountList(username);
                ArrayList<Account> accountList = accounts.retrieveAccounts();
                for (Account a : accountList) {
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(a.getAccountNo());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(df.format(a.getBalance()));
                    out.println("</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <br>

        <form action='transfer.do' method='POST'>



            <table class='table'>
                <tr>
                    <td>
                        Current Account:
                    </td>
                    <td>
                        <%=curAccount.getAccountNo()%>
                    </td> 
                </tr>
                <tr>
                    <td>
                        Select an account to make a transfer to:
                        <br>
                        <select class='Dropdown' name='trfAccount'>
                            <%
                                for (Account a : accountList) {
                                    if (!a.getAccountNo().equals(curAccount.getAccountNo())) {
                                        out.println("<option value='" + a.getAccountNo() + "'>" + a.getAccountNo() + "</option>");
                                    }
                                }
                            %> 
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
                        <input class='btn' name='transferbtn' type='submit'>
                    </td>
                </tr>
            </table>

        </form>
    </body>
</html>
