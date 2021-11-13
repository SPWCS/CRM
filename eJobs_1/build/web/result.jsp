<%-- 
    Document   : result.jsp
    Created on : 16 Jul, 2019, 11:07:36 PM
    Author     : devnani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page</title>
    </head>
    <body>
         <jsp:useBean id="ub" class="com.tecdev.UserBean" scope="session" />
        <h1>College Name ${ub.userid}</h1>
        <br/>
        Predicated Admissions: ${ub.usertype}>
    </body>
</html>


