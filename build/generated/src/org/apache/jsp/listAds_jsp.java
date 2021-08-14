package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import carrental.Car;
import carrental.DBConnection;

public final class listAds_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      carrental.carDAO cDao = null;
      synchronized (request) {
        cDao = (carrental.carDAO) _jspx_page_context.getAttribute("cDao", PageContext.REQUEST_SCOPE);
        if (cDao == null){
          cDao = new carrental.carDAO();
          _jspx_page_context.setAttribute("cDao", cDao, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>List of Vacancies</title>\n");
      out.write("        <style>\n");
      out.write("            h1 {\n");
      out.write("                font-family: \"Helvetica Neue\", Helvetica, Arial, sans-serif; font-size: 24px; font-style: normal; font-variant: normal; font-weight: 700; line-height: 26.4px; } \n");
      out.write("            h3 { font-family: \"Helvetica Neue\", Helvetica, Arial, sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 700; line-height: 15.4px; } \n");
      out.write("            p { font-family: \"Helvetica Neue\", Helvetica, Arial, sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 400; line-height: 20px; } \n");
      out.write("            blockquote { font-family: \"Helvetica Neue\", Helvetica, Arial, sans-serif; font-size: 21px; font-style: normal; font-variant: normal; font-weight: 400; line-height: 30px; } \n");
      out.write("            pre { font-family: \"Helvetica Neue\", Helvetica, Arial, sans-serif; font-size: 13px; font-style: normal; font-variant: normal; font-weight: 400; line-height: 18.5714px; }\n");
      out.write("            .center {\n");
      out.write("\n");
      out.write("                display: block;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("                margin-top: -100px;\n");
      out.write("                width: 20%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropbtn {\n");
      out.write("                background-color: rgb(251, 255, 0);\n");
      out.write("                color: rgb(0, 0, 0);\n");
      out.write("                padding: 16px;\n");
      out.write("                padding-left: 50px;\n");
      out.write("                padding-right: 50px;\n");
      out.write("                font-size: 16px;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 10px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown {\n");
      out.write("                position: relative;\n");
      out.write("                display: inline-block;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content {\n");
      out.write("                display: none;\n");
      out.write("                position: absolute;\n");
      out.write("                background-color: #f1f1f1;\n");
      out.write("                min-width: 160px;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\n");
      out.write("                z-index: 1;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content a {\n");
      out.write("                color: black;\n");
      out.write("                padding: 12px 76px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content a:hover {background-color: #ddd;}\n");
      out.write("\n");
      out.write("            .dropdown:hover .dropdown-content {display: block;}\n");
      out.write("\n");
      out.write("            .dropdown:hover .dropbtn {background-color: #3e8e41;}\n");
      out.write("\n");
      out.write("            html {\n");
      out.write("                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("                margin: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .container {\n");
      out.write("                background-color: #efc4b3;\n");
      out.write("                padding: 1rem;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .header {\n");
      out.write("                background-color: #99dd1b;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .header h1 {\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 3rem 0 1rem 0;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .header img {\n");
      out.write("                height: 6rem;\n");
      out.write("                float: right;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .headerNav {\n");
      out.write("                background-color: #9b500f;\n");
      out.write("                color: white;\n");
      out.write("                align-items: center;\n");
      out.write("                padding-top: 1rem;\n");
      out.write("                padding-bottom: 1rem;\n");
      out.write("                position: relative;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .headerNav * {\n");
      out.write("                display: inline;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .headerNav li {\n");
      out.write("                margin-right: 1rem;\n");
      out.write("                margin-left: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .headerNav a {\n");
      out.write("                color: white;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .headerNav a:hover {\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: #42240c;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .table{\n");
      out.write("                float: right;\n");
      out.write("            }\n");
      out.write("            legend{\n");
      out.write("                background-color: white;\n");
      out.write("                padding: 20;\n");
      out.write("                padding-left: 50px;\n");
      out.write("                padding-right: 50px;\n");
      out.write("                border-radius: 10em;\n");
      out.write("                border-color: #99dd1b;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            fieldset{\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .titleRent{\n");
      out.write("                width: 40%;\n");
      out.write("                text-align: center;\n");
      out.write("                background-color: #f1f1b0;\n");
      out.write("                padding: 20px;\n");
      out.write("                border-radius: 20px;\n");
      out.write("                margin: auto;\n");
      out.write("                margin-top: 20px;\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            #navDropdownMenuContent {\n");
      out.write("                display: none;\n");
      out.write("                position: absolute;\n");
      out.write("                top: 53px;\n");
      out.write("                min-width: 10rem;\n");
      out.write("                background-color: #ff6600;\n");
      out.write("                padding: 1rem;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #navDropdownMenuContent li {\n");
      out.write("                float: none;\n");
      out.write("                color: black;\n");
      out.write("                text-decoration: none;\n");
      out.write("                display: block;\n");
      out.write("                margin-top: 0.5rem;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #navDropdownMenu:hover{\n");
      out.write("                background-color: #42240c;\n");
      out.write("                padding: 15px;\n");
      out.write("            }\n");
      out.write("            /* Show the dropdown menu on hover */\n");
      out.write("            #navDropdownMenu:hover #navDropdownMenuContent {\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #body {\n");
      out.write("\n");
      out.write("\n");
      out.write("                padding: 1rem 4rem 7rem 4rem;\n");
      out.write("                background-blend-mode: multiply;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("                background-image: url('redcar.jpg');\n");
      out.write("                height: 900px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #body p {\n");
      out.write("                border: thick double;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #center {\n");
      out.write("                display: block;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("                width: 20%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #btnSubmit{\n");
      out.write("                padding: 5px 30px 5px 30px;\n");
      out.write("                background-color: #e1d6ff;\n");
      out.write("                color: rgb(0, 2, 3);\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    ");

        

        List<Car> carAll = cDao.retrieveAllCar();
        DBConnection database = new DBConnection();
        database.closeConnection();
    
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <nav class=\"headerNav\">\n");
      out.write("            <ul>\n");
      out.write("\n");
      out.write("                <li><a href=\"modulCompany.jsp\">Back</a></li>\n");
      out.write("                <li id=\"navDropdownMenu\"><a href=\"mainPage.jsp\">Home</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div id=\"body\">\n");
      out.write("\n");
      out.write("            <img style=\"width: 200px; height: 200px; border-radius: 60%;\" src=\"https://www.logopik.com/wp-content/uploads/edd/2018/06/Car-Rental-Logo.png\" alt=\"Logo\" id=\"center\">\n");
      out.write("\n");
      out.write("            <br/>\n");
      out.write("            <center><h2 style=\"color: white\">Your Cars Information</h2></center>\n");
      out.write("\n");
      out.write("\n");
      out.write("            \n");
      out.write("            <table style=\"background-color: #ffe8df; width: 1000px\" align=\"center\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>ADS</th>\n");
      out.write("                    <th>FLAT NUMBER</th>\n");
      out.write("                    <th>RENT/HOURS</th>\n");
      out.write("                    <th>CONTACT</th>\n");
      out.write("                    <th>CAR BRAND</th>\n");
      out.write("                    <th>CAR TYPE</th>\n");
      out.write("                    <th>STATUS</th>\n");
      out.write("                    <th>ACTION</th>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                ");
 for (int i = 0; i < carAll.size(); i++) {
      out.write("\n");
      out.write("                <tr>\n");
      out.write("\n");
      out.write("                    <td><center><img width=\"200\" height=\"200\" src=\"/ProjectCarRental/imgCar/image.jsp?id='");
      out.print(carAll.get(i).getFlatno());
      out.write("'\"></center></td>\n");
      out.write("                <td><center>");
      out.print(carAll.get(i).getFlatno());
      out.write("</center></td>\n");
      out.write("                <td><center>");
      out.print(carAll.get(i).getPrice());
      out.write("</center></td>\n");
      out.write("                <td><center>");
      out.print(carAll.get(i).getContact());
      out.write("</center></td>\n");
      out.write("                <td><center>");
      out.print(carAll.get(i).getCarname());
      out.write("</center></td>\n");
      out.write("                <td><center>");
      out.print(carAll.get(i).getCartype() );
      out.write("</center></td>\n");
      out.write("                <td><center>");
      out.print(carAll.get(i).getCstatus() );
      out.write("</center></td>\n");
      out.write("                <td style=\"width: 170px\"><center><a href=deleteCarAds.jsp?id=\"");
      out.print(carAll.get(i).getFlatno());
      out.write("\">Remove</a></center>\n");
      out.write("\n");
      out.write("                </td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </center>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
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
