<%-- 
   Kumpulan 3: Car Rental System

   Nama Ahli Kumpulan :

   1.Muhamad Nurfitri Bin Zaini        (S52188)
   2.Ahmad Irfan Naim Bin Amir Hamzah  (S52043)
   3.Muhammad Hanif Bin Mohd Nawawi    (S51914)
   4.Kamarul Khairi Bin Rosdi          (S51565)
   5.Muhammad Nur Syazreen Bin Affendy (S50880)
--%>
<%@page import="carrental.companyDAO"%> 
<%@page import="carrental.Company"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process LC</title>
    </head>
    <body>
        <%
          String comid = request.getParameter("cid");
          String compass = request.getParameter("password");

        Company company = companyDAO.signinCompany(comid, compass);

        if (company != null) {
            session.setAttribute("company", company);
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"Login Successfully!!!\")");
            out.println("</script >");
            RequestDispatcher rd = request.getRequestDispatcher("modulCompany.jsp");
            rd.include(request, response);
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"Incorrect Id or Password!!!\")");
            out.println("</script >");
            RequestDispatcher rd = request.getRequestDispatcher("company.jsp");
            rd.include(request, response);

        }  


        %>
    </body>
</html>
