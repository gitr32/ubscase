<%-- 
    Document   : Login
    Created on : Jun 25, 2015, 7:31:00 PM
    Author     : r128
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen" href="bootstrap/css/bootstrap.min.css">
        <title>Login</title>
    </head>
    <body>
        <ul>
                <%                    
                    ArrayList<String> list = (ArrayList<String>) request.getAttribute("errorList");
                    if (list != null && !list.isEmpty()) {
                        out.println("Please check that you have entered: ");
                    
                        for (String error : list) {
                            out.println("<li>" + error + "</li>");
                        }
                    }
                %>
            </ul>
        <form action='login.do' method='POST'>
            
            Username: <input type='text' name='username'>
            <br>
            Password: <input type='password' name='password'>
            <br>
            <input type='submit' class='btn' value='Login'>
        </form>
    </body>
</html>
