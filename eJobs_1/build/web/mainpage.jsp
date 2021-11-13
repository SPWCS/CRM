<%@page contentType="text/html" import="com.tecdev.*" errorPage="error.jsp" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eJobs Portal</title>
         <jsp:include page="top.txt"/>
    </head>
    <body>
      <%!String result="0";%>
        <% result=request.getParameter("result");
        if(result!=null){ int r=Integer.parseInt(result);
        if(r>0)
            out.print("<div class='successdiv'>Record Saved</div>");
        else
            out.print("<div class='failurediv'>Record NOT Saved</div>");
        
        } %>   
        <h1>eJobs Main Page</h1>
        <jsp:useBean id="ub" scope="session" class="com.tecdev.UserBean"/>
     
        <b>Welcome ${ub.userid} in eJobs Portal <br/>
              <%--    
                    Old way
            <jsp:getProperty name="ub" property="userid" />
              --%>
        </b>
        <%
            if (ub.getUsertype().equalsIgnoreCase("Customer")) {
                out.println("<a href=customerprofile.jsp>Customer Profile</a><br/>");
                out.println("<a href=searchjob.jsp>Search Job</a>");
            } else {
                out.println("<a href=companyprofile.jsp>Company Profile</a><br/>");
                out.println("<a href=postjob.jsp>Post Job</a>");
            }
        %>
        
       <%@include  file="bottom.txt" %> 
       <%-- <jsp:include page="bottom.txt"/> --%>
    </body>
</html>
