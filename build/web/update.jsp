<%-- 
    Document   : update
    Created on : 03-Oct-2023, 21:48:26
    Author     : ASUS
--%>

<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Student s = (Student)request.getAttribute("Student");
        %>
        <form action="/PT1/student/update" method="POST">
            Id:<input type="text" name="id" value="<%=s.getId()%>" /><br>
            Name:<input type="text" name="name" value="<%=s.getName()%>" /><br>
            Gender:<input type="radio" id="female" name="gender" value="F"> 
            <label for="female">Female</label> <input type="radio" id="male" name="gender" value="M"> <label for="male">Male</label><br>
            DOB: <input type="text" name="DOB" value="<%=s.format()%>" /><br/>
            <input type="submit" value="Update"/>
        </form>
    </body>
</html>
