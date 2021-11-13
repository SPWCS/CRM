<%-- 
    Document   : searchjob.jsp
    Created on : 17 Jul, 2019, 10:45:14 PM
    Author     : devnani
--%>

<%@page contentType="text/html" errorPage="error.jsp" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="top.txt"/>
        <jsp:useBean id="ub" class="com.tecdev.UserBean" scope="session"/>
        <title>Welcome${ub.userid}in ejob Portal</title>
    </head>
    <body>
        <h1><center>Search Job</center></h1>
        <div>
            <form method="post" action="JobServlet?op=6">
                Post:
                <select size="1" name="post">
                    <option value="-" selected>-</option>
                    <option value="Developer" selected>Developer</option>
                    <option value="Designer" selected>Designer</option>
                    <option value="Manager" selected>Manager</option>
                    <option value="VP" selected>VP</option>
                    <option value="President" selected>President</option>
                    <option value="CEO" selected>CEO</option>
                    <option value="CMO" selected>CMO</option>
                    <option value="Others" selected>Others</option>
                    
                </select><br/> Operator:
                <select size="1" name="operator">
                    <option value="OR">OR</option>
                      <option value="AND">AND</option>
                </select><br/>
                Qualification:
                <select name="qualification" size="1">
                    <option value="-" selected>-</option>
                     <option value="10th" selected>10th</option>
                     <option value="12th" selected>12th</option>
                     <option value="UG" selected>UG</option>
                     <option value="BE" selected>BE</option>
                     <option value="MCA" selected>MCA</option>
                     <option value="M.Tech" selected>M.Tech</option>
                     <option value="Ph.D" selected>Ph.D</option>
                </select><br/>
                <input type="checkbox" name="lower" value="true"/>Consider Lower Qualification <br/>
                <input type="checkbox" name="applied" value="true"/>Show Already Applied <br/>
                <input type="hidden" name="userid" value="${ub.userid}"/>
                <input type="submit" value="search"/>
            </form>
        </div>
                <%@include file="bottom.txt" %>
    </body>
</html>
