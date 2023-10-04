<%-- 
    Document   : create
    Created on : 03-Oct-2023, 19:37:33
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="create" action="/PT1/student/create" method="POST">
            Name:<input type="text" name="name" value="" /><br>
            Gender:<input type="radio" id="female" name="gender" value="F"> 
            <label for="female">Female</label> <input type="radio" id="male" name="gender" value="M"> <label for="male">Male</label><br>
            DOB: <input type="text" name="DOB" value="" /><br/>
            <input type="submit" value="Create" />
        </form>
    </body>
</html>
