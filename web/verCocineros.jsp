<%-- 
    Document   : verCocineros
    Created on : 20-mar-2018, 9:20:15
    Author     : mfontana
--%>

<%@page import="entities.Cocinero"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de cocineros</title>
    </head>
    <body>
         <%
            List<Cocinero> cocineros = (List<Cocinero>) request.getAttribute("cocineros");
            if (cocineros.isEmpty()) {
        %>
        <h2>No hay cocineros registrados</h2>
        <%
        } else {
        %>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Telefono</th>
                <th>Edad</th>
            </tr>
            <%
                    for (Cocinero c : cocineros) {
                        %>
                        <tr>
                            <td><%= c.getNombre() %></td>
                            <td><%= c.getTelefono() %></td>
                            <td><%= c.getEdad() %></td>
                        </tr>
                        <%
                             
                    }
                }
            %>
        </table>
    </body>
</html>
