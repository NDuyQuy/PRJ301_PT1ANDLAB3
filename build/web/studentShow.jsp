<%-- 
    Document   : studentShow
    Created on : 21-Sep-2023, 13:57:49
    Author     : ASUS
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            ArrayList<Student> l = (ArrayList<Student>)request.getAttribute("sList");
            if(l!=null){%>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Gender</th>
                        <th>DOB</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>    
                

            <% for(Student s: l){%>
                <tr>
                    <td><%=s.getId()%></td>
                    <td><%=s.getName()%></td>
                    <td><%=s.getGender()%></td>
                    <td><%=s.format()%></td>
                    <td><a href="/PT1/student/update?ID=<%=s.getId()%>"/>Update | <a href="/PT1/delete?id=<%=s.getId()%>">Delete</a></td>
                </tr>
            <%}
        }
        %>
                </tbody>
            </table>
                <a href="/PT1/student/create"/>Create
    </body>
</html>
