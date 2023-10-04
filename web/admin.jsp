<%-- 
    Document   : admin
    Created on : 02-Oct-2023, 16:48:58
    Author     : ASUS
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome: 
        <% User u = (User)session.getAttribute("User");
            if(u!=null){
                out.println(u.getUserName());
            }
        %>
        </h1>
        <form action="search" method="POST">
            <input type="text" name="search" value="" />
            <input type="submit" value="Search" name="butt" />
        </form>
        
                <% ArrayList<User> users = (ArrayList<User>)request.getAttribute("uList");
                    if(users!=null){%>
        <table border="1">
            <thead>
                <tr>
                    <th>UserId</th>
                    <th>UserName</th>
                    <th>User</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    for (User user : users) {%>
                        <tr>
                            <td><%=user.getId()%></td>
                            <td><%=user.getUserName()%></td>
                            <td><%=user.getRole()%></td>
                        </tr>
                        <%}
                    }
                %>
            </tbody>
        </table>
            <a href="/PT1/student/list"/>studentlist
    </body>
</html>
