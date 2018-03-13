<%-- 
    Document   : final
    Created on : 13-mar-2018, 10:49:50
    Author     : mfontana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant</title>
    </head>
    <body>
        <%
            // Recogemos la variable status que nos han pasado
            String status = (String) request.getAttribute("status");
            // Por si llaman al jsp sin pasar por el servlet
            if (status != null) {
                // Mostramos el msg por pantalla
        %>
        <h1><%= status %></h1>
        <%
            }
        %>
    </body>
</html>
