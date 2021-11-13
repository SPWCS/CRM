<%-- 
    Document   : customerprofile.jsp
    Created on : 16 Jul, 2019, 11:06:38 PM
    Author     : devnani
--%>

<%@page contentType="text/html" import="com.tecdev.*" errorPage="error.jsp"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        0        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Profile Page</title>
        <jsp:include page="top.txt"/>
    </head>
    <body>
        <jsp:useBean id="ub" class="com.tecdev.UserBean" scope="session" />



        <jsp:useBean id="cb" class="com.tecdev.CustomerBean" scope="page" />
        <%! boolean found = false;%>



        <%
            cb.setUserid(ub.getUserid());
            found = cb.exists(); //make it true
%>


        <div id="formdiv">
            <form method="post" action="JobServlet?op=3&found=${cb.found}">
                Userid:
                <input type="text" name="userid" value="${cb.userid}" readonly="true"/>Read Only<br>
                Name:
                <input type="text" name="name" value="${cb.name}" /><br/>
                Birth Date:
               <%-- <input type="text" name="dob" value='<jsp:getProperty name="cb" property="dob"/>'/><br/>--%>
               
               <input type="text" name="dob" value='${cb.dob}'/><br/>
                Qualification:
                <!--
                 <input type="text" name="qualification" value="${cb.qualification}"/> <br/>
                -->

                <select name="qualification" size="1">
                    <option value="10th" ${cb.qualification eq "10th" ? 'Selected':''} >10th</option>
                    <option value="12th" ${cb.qualification eq "12th" ? 'Selected':''}>12th</option>
                    <option value="UG" ${cb.qualification eq "UG" ? 'Selected':''}> UG</option>
                    <option value="BE" ${cb.qualification eq "BE" ? 'Selected':''} >BE</option>
                    <option value="MCA" ${cb.qualification eq "MCA" ? 'Selected':''}>MCA</option>
                    <option value="M.Tech" ${cb.qualification eq "M.Tech" ? 'Selected':''} > M.Tech</option>
                    <option value="Ph.D" ${cb.qualification eq "Ph.D" ? 'Selected':''} >Ph.D</option>


                </select>
                Weightage:
                <input type="text" name="weightage" value="${cb.weightage}"/> <br/>
                <input type="button" value="Edit" onclick=""/>
                <input type="submit" value="save" />
            </form>
        </div>
        
        <jsp:include page="bottom.txt"/>
    </body>
</html>

