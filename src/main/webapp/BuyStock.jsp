<%-- 
    Document   : BuyStock
    Created on : Jun 26, 2015, 12:44:52 PM
    Author     : r128
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen" href="bootstrap/css/bootstrap.min.css">

        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username = (String) session.getAttribute("username");
            if (username == null) {
                RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                rd.forward(request, response);
            }

        %>
        <br>
        <form action='trade.do' method='POST'>
            <%                ArrayList<String> symbols = new ArrayList<String>();
                symbols.add("AAPL");
                symbols.add("S&P");
                symbols.add("GOOG");
                String stockSymbol = request.getParameter("stockSymbol");
            %>

            <select name="symbol">
                <%
                    for (String s : symbols) {
                        if (!s.equals(stockSymbol)) {
                            out.println("<option value='" + s + "'>" + s + "</option>");
                        } else {
                            out.println("<option value='" + s + "' selected>" + s + "</option>");
                        }
                    }
                %>
            </select>
            <table>
                <tr>
                    <td>
                        Price:
                    </td>
                    <td>
                        <input class='input-small' name="price" value='558.30'readonly>
                    </td>

                </tr>
                <tr>
                    <td>
                        Volume: 
                    </td>
                    <td>
                        <input class='input-small' name="volume">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input class='btn' type='submit' value='Trade'>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
