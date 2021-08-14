<%-- 
    Kumpulan 3: Car Rental System

   Nama Ahli Kumpulan :

   1.Muhamad Nurfitri Bin Zaini        (S52188)
   2.Ahmad Irfan Naim Bin Amir Hamzah  (S52043)
   3.Muhammad Hanif Bin Mohd Nawawi    (S51914)
   4.Kamarul Khairi Bin Rosdi          (S51565)
   5.Muhammad Nur Syazreen Bin Affendy (S50880)
--%>

<%@page import="carrental.adminDAO"%> 
<%@page import="carrental.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process LC</title>
    </head>
    <body>
        <%
          String adminID = request.getParameter("cid");
          String adminPassword = request.getParameter("password");

        Admin admin = adminDAO.signinAdmin(adminID, adminPassword);

        if (admin != null) {
            session.setAttribute("admin", admin);
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"Login Successfully!!!\")");
            out.println("</script >");
            RequestDispatcher rd = request.getRequestDispatcher("modulAdmin.jsp");
            rd.include(request, response);
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"Incorrect Id or Password!!!\")");
            out.println("</script >");
            RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
            rd.include(request, response);

        }  


        %>
    </body>
</html>
