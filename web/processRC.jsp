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
<%@page import="java.sql.*, carrental.DBConnection, carrental.companyDAO"%>
<jsp:useBean id="company" class="carrental.Company" scope="request"/>
<jsp:setProperty name="company" property="compid" value='<%=request.getParameter("cid")%>'/>
<jsp:setProperty name="company" property="cpass" value='<%=request.getParameter("password")%>'/>
<jsp:setProperty name="company" property="compname" value='<%=request.getParameter("name")%>'/>
<jsp:setProperty name="company" property="compcontact" value='<%=request.getParameter("contact")%>'/>
<jsp:setProperty name="company" property="companylink" value='<%=request.getParameter("link")%>'/>
<jsp:setProperty name="company" property="location" value='<%=request.getParameter("location")%>'/>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process Register Company</title>
    </head>
    <body>
         <%
            DBConnection database = new DBConnection();
            companyDAO compdao = new companyDAO();
            int result = compdao.addCompany(company);
            out.println("<p>"+result+"</p>");
            
             if (result > 0){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"Registration Successfully.\")");
                out.println("</script >");
                RequestDispatcher rd = request.getRequestDispatcher("company.jsp");
                rd.include(request,response);
            }
            
            database.closeConnection();
         %>
         
    </body>
</html>

