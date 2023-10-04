<%-- 
    Document   : demo_example
    Created on : 14-Sep-2023, 14:26:44
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
        <form action="LoginController" method="post"> 
            <table>
                <tr>
                    <td>
                        username <input name ="user" type="text">
                    </td>
                </tr>
                <tr>
                    <td>
                        password <input name ="pass" type="text">
                    </td>
                </tr>
            </table>
            <input id = "rm" name ="rm" type="checkbox">
            <label for ="rm"> Remember me</label> <br>
            <input type="submit" value="submit">
        </form>
        <p name = "invalid" style="color: red"></p>
    </body> 
</html>
<p style="color: red"></p>