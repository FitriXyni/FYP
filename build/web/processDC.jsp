<%-- 
    Kumpulan 3: Car Rental System

   Nama Ahli Kumpulan :

   1.Muhamad Nurfitri Bin Zaini        (S52188)
   2.Ahmad Irfan Naim Bin Amir Hamzah  (S52043)
   3.Muhammad Hanif Bin Mohd Nawawi    (S51914)
   4.Kamarul Khairi Bin Rosdi          (S51565)
   5.Muhammad Nur Syazreen Bin Affendy (S50880)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, carrental.DBConnection, carrental.adminDAO"%>
<%@page import="carrental.Admin"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Student</title>
    </head>
    <body>
        <%
            String flatno = request.getParameter("flatno");
            DBConnection database = new DBConnection();
            adminDAO aDao = new adminDAO();
            int result = aDao.deleteAdmin(flatno);
            database.closeConnection();
            if (result > 0){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"Success Remove the Vacancies\")");
                out.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("listAds.jsp");
                rd.include(request,response);
            }
            
            
        %>
    </body>
</html>
