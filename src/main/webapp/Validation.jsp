<%-- 
    Document   : Validation
    Created on : Jun 26, 2015, 2:20:17 AM
    Author     : r128
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen" href="bootstrap/css/bootstrap.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
    </head>
    <body>
        <ul class='unstyled alert-error'>
            <%
                String errorMsg = (String)request.getAttribute("errorMsg");
                if(errorMsg != null) {
                    out.println("<li>" + errorMsg + "</li>");
                }
            %>
        </ul>
        
        Press the button to send a validation code to your mobile phone
        <br>
        <button class='btn' name='sendButton'>Send Code</button>
        <br>
        <br>
        
        Please enter the 6-digit validation code that has been sent to your mobile
        <br>
        <form action='validation.do' method='POST'>
            <input type='text' name='code'>
            <br>
            <input type='submit' class='btn' value='Login'>
        </form>
    </body>
</html>
