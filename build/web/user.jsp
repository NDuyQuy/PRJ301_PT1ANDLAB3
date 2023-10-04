<%-- 
    Document   : welcome
    Created on : 28-Sep-2023, 14:30:59
    Author     : ASUS
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome 
        <% User role = (User)session.getAttribute("User");
            if(role!=null){
                out.println(role.getUserName());
            }
        %>
        </h1>
        <table border="1">
            <thead>
                <tr>
                    <th>UserId</th>
                    <th>UserName</th>
                    <th>Password</th>
                    <th>Role</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%=role.getId()%></td>
                    <td><%=role.getUserName()%></td>
                    <td><%=role.getPassword()%></td>
                    <td><%=role.getRole()%></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
