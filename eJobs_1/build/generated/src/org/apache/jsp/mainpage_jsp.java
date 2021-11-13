package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.tecdev.*;

public final class mainpage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/bottom.txt");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>eJobs Portal</title>\n");
      out.write("         ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "top.txt", out, false);
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      ");
      out.write("\n");
      out.write("        <h1>eJobs Main Page</h1>\n");
      out.write("        ");
      com.tecdev.UserBean ub = null;
      synchronized (session) {
        ub = (com.tecdev.UserBean) _jspx_page_context.getAttribute("ub", PageContext.SESSION_SCOPE);
        if (ub == null){
          ub = new com.tecdev.UserBean();
          _jspx_page_context.setAttribute("ub", ub, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("     \n");
      out.write("        <b>Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ub.userid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" in eJobs Portal <br/>\n");
      out.write("              ");
      out.write("\n");
      out.write("        </b>\n");
      out.write("        ");

            if (ub.getUsertype().equalsIgnoreCase("Customer")) {
                out.println("<a href=customerprofile.jsp>Customer Profile</a><br/>");
                out.println("<a href=searchjob.jsp>Search Job</a>");
            } else {
                out.println("<a href=companyprofile.jsp>Company Profile</a><br/>");
                out.println("<a href=postjob.jsp>Post Job</a>");
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("       ");
      out.write("<input type=\"button\" value=\"Back\" onClick=\"history.back()\"/>\n");
      out.write("<a href=\"JobServlet?op=8\">Logout</a>\n");
      out.write("<hr/>\n");
      out.write("<center>&copy; TecDev</center>\n");
      out.write(" \n");
      out.write("       ");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
