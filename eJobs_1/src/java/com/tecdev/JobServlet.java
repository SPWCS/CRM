package com.tecdev;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class JobServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String op = "";
        PrintWriter out = response.getWriter();
        try {

            op = request.getParameter("op");

            if (op == null) {

                String button = request.getParameter("login");

                if (button != null) {  //When Login Pressed
                    op = "1";
                } else {            //When Register Pressed
                    op = "2";
                }
            }
            switch (op) //Java 7: String is allowed in switch
            {
                case "1": //Login Pressed
                    verifyUser(request, response); //UDF - Divert
                    break;
                case "2": //Register Pressed
                    registerUser(request, response); //UDF -Divert
                    break;
                case "3":
                    updateCustomerProfile(request, response);
                    break;
                case "7":
                    insertJobAppliedFor(request,response);
                    break;
               case "8":
                    logout(request,response);
                    break;
                }

        } catch (Exception e) {
             out.println(e.toString());
        }
    }

    private void verifyUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        
        String u = request.getParameter("userid");
        String p = request.getParameter("password");
        
       
        //Validation logic
        if (u == null || p == null) { //Objects not found
            response.sendRedirect("index.html");
            return;  //Terminate code
        }

        UserBean ub = new UserBean(u, p); //Abstraction-PC
     
           if (ub.exists()) //true - if found
        {
            Cookie c = new Cookie("userid", u);   //PC Key:val
            Cookie d = new Cookie("usertype", ub.getUsertype());
            c.setMaxAge(24 * 60 * 60); //1day
            d.setMaxAge(24 * 60 * 60); //1day
            response.addCookie(c);
            response.addCookie(d);
            //Using HttpSession Object=>Server itself
            HttpSession session = request.getSession(true); //Interview
            session.setAttribute("userid", u);
            session.setAttribute("usertype", ub.getUsertype());
            session.setAttribute("ub" ,ub);
            //getServletContext().setAttribute("userid", u);  
            getServletContext().getRequestDispatcher(
                    "/mainpage.jsp").forward(request, response);

        } else {
            response.sendRedirect("index.html");
            //new LoginFrame().setVisible(true);
        }

    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        out.println("I am inside Register User");
    }

    private void updateCustomerProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        boolean found = Boolean.parseBoolean(request.getParameter("found"));
        //Collect Other User Data From Form
        String userid = request.getParameter("userid");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String qualification = request.getParameter("qualification");
        int weightage = Integer.parseInt(request.getParameter("weightage"));

        CustomerBean cb = new CustomerBean(userid, name, dob, qualification, weightage); //PC
        //Pass value of boolean variable found to cb

        cb.setFound(found);
        int result = cb.executeUpdate(); //UDF
        String url="/mainpage.jsp?result="+result;
        getServletContext().getRequestDispatcher(url).forward(request,response);
        PrintWriter out = response.getWriter();
        if (result
                > 0) {
            out.println(
                    "Recored Saved");
        } else {
            out.println(
                    "Recored Failed to Saved");
        }
    }
     
    private void insertJobAppliedFor(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session= request.getSession(false);
         if(session==null)
         {response.sendRedirect("index.html");
         }
    
    PrintWriter out=response.getWriter();
    String jobids[]=request.getParameterValues("apply");
    if(jobids == null){
     out.println("sorry.No JobId Selected");
     return;
     
    }
    
    UserBean ub=(UserBean)session.getAttribute("ub");
    if(ub==null){
    out.println("sorry.No Session Selected.Login again");
    return;
    
    }
    String userid=ub.getUserid();
    if(userid==null){
    out.println("Sorry.Userid not found.Register Youself.");
    return;
    }
   AppliedBean ab=new AppliedBean(userid,jobids);
    int count=ab.executeUpdate();
    out.print(count+"Job saved successfully</br>");
}
     private void logout(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session= request.getSession(false);
        session.removeAttribute("ub");
        session.invalidate();
        response.sendRedirect("index.html");
     }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    private void searchJob(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String post=request.getParameter("post");
    String qualification=request.getParameter("qualification");
    String operator=request.getParameter("operator");
    String lower=request.getParameter("lower");
    String applied=request.getParameter("applied");
    String userid=request.getParameter("userid");
     SearchBean sb=new SearchBean(userid,post,qualification,operator,lower,applied);
     String sql=sb.executeQuery();
     HttpSession session=request.getSession(false);
     session.setAttribute("sql",sql);
     
     getServletContext().getRequestDispatcher("/searchresult.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
