<%-- 
    Document   : error.jsp
    Created on : 16 Jul, 2019, 11:07:15 PM
    Author     : devnani
--%>

<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>eJob Error Page</title>
        
    </head>
    <body>
         <h1>Exception is </h1>
        <%=exception.toString()%>
    </body>
</html>
