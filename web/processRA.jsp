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
<jsp:useBean id="admin" class="carrental.Admin" scope="request"/>
<jsp:setProperty name="admin" property="aid" value='<%=request.getParameter("aid")%>'/>
<jsp:setProperty name="admin" property="apassword" value='<%=request.getParameter("apassword")%>'/>
<jsp:setProperty name="admin" property="aname" value='<%=request.getParameter("aname")%>'/>
<jsp:setProperty name="admin" property="acontact" value='<%=request.getParameter("acontact")%>'/>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process Register Admin</title>
    </head>
    <body>
         <%
            DBConnection database = new DBConnection();
            adminDAO adao = new adminDAO();
            int result = adao.addAdmin(admin);
            out.println("<p>"+result+"</p>");
            
             if (result > 0){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"Registration Successfully.\")");
                out.println("</script >");
                RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
                rd.include(request,response);
            }
            
            database.closeConnection();
         %>
         
    </body>
</html>
