package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import carrental.carDAO;
import user.customer;

public final class feedback_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"stylingFont.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"homepage.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("          ");

        String feedback = request.getParameter("message");
        
        String message="";
    if(request.getMethod().equalsIgnoreCase("POST")){
        
        
        int user=carDAO.giveFeedback(feedback);
        String page1="carOffer.jsp";
        
        if(user>0){
           
           page1="adsList.jsp";
           message = "Feedback Succesufully Sent!";
        }else{
            message="Cannot Send!";
        }
        out.println("<script type=\"text/javascript\">");
                    out.println("alert(\""+message+"\")");
                    out.println("</script>");
                    response.sendRedirect(page1);
        }  
      out.write("\n");
      out.write("        <nav class=\"headerNav\">\n");
      out.write("            <ul>\n");
      out.write("\n");
      out.write("                <li><a href=\"feedback.jsp\">Feed back</a></li>\n");
      out.write("                <li id=\"navDropdownMenu\"><a href=\"index.html\">Home</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div id=\"body\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div style=\"margin-top: 100px;\">\n");
      out.write("                <h1 class=\"titleRent\">Feed Back</h1>\n");
      out.write("\n");
      out.write("                <center>\n");
      out.write("                    <form action=\"feedback.jsp\" method=\"post\">\n");
      out.write("                        <fieldset style=\"background-color: #ffffff; width: 400px; height:310px\">\n");
      out.write("                            <legend>\n");
      out.write("                                <h1><b style=\"color:rgb(255, 166, 0);\">Contact Us</b></h1>\n");
      out.write("                            </legend>\n");
      out.write("                            <br /><br />\n");
      out.write("                            <table>\n");
      out.write("                               \n");
      out.write("                                <tr>\n");
      out.write("                                    <td>FeedBack: </td>\n");
      out.write("                                    <td><input type=\"text\" name=\"message\"></td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table><br /><br />\n");
      out.write("\n");
      out.write("                            <input type=\"submit\" value=\"Submit\" id=\"btnSubmit\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </fieldset>\n");
      out.write("                    </form>\n");
      out.write("                </center>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
