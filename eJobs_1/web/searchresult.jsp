<%-- 
    Document   : searchresult.jsp
    Created on : 19 Jul, 2019, 10:58:18 PM
    Author     : devnani
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" errorPage="error.jsp" pageEncoding="UTF-8"%>
<@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result</title>
        <jsp:include page="top.txt"/>
     </head>
    <body>
        <jsp:useBean id="ub" scope="session" class="com.tecdev.UserBean"/>
        <h1>Search Job Result</h1>
        Userid:<b>${ub.userid}</b><br/>
        Name:<b><jsp:getProperty name="cb" property="name"/></b><br/>
        <c:set value='<%=session.getAttribute("sql")%>' var="sql"/>
            <sql:setDataSource data source="jdbc/myora" var="db"/>
            <sql:query dataSource="${db}" var="rs" >
             ${sql}
            </sql:query>
            <form action="JobServlet?op=7" method="post">
                <table border="1" width="100%">
                    <thead><td>Apply</td><td>JobId</td><td>CompanyId</td>
                    <td>Dated</td><td>Post</td><td>Qualification</td><td>Weightage</td>
                </thead> 
                        <c:forEach var="i" items="${rs.rows}">
                            <tr><td>
                                <input type="checkbox" name="apply" value="${i.jobid}"/>
                                
                               </td>
                               <td> <c:out value="${i.jobid}"/> </td>
                                <td> <c:out value="${i.userid}"/> </td>
                                 <td> <c:out value="${i.dated}"/> </td>
                                  <td> <c:out value="${i.post}"/> </td>
                                   <td> <c:out value="${i.qualification}"/> </td>
                                    <td> <c:out value="${i.weigtage}"/> </td>
                                
                            </tr>
                        </c:forEach>
                </table>
                    <input type="submit" value="Apply Now"/>
            </form>
                <jsp:include page="bottom.txt"/>
    </body>
</html>
