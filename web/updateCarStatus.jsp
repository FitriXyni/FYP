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
<%@page import="java.sql.*, carrental.DBConnection, carrental.carDAO"%>
<%@page import="carrental.Car"%>
<jsp:useBean id="car" class="carrental.Car" scope="request"/>
<jsp:setProperty name="car" property="cstatus" value='<%=request.getParameter("status")%>'/>
<jsp:setProperty name="car" property="flatno" value='<%=request.getParameter("flatno")%>'/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Status</title>
    </head>
    <body style="font-family: century gothic">
        <%
            DBConnection database = new DBConnection();
            carDAO cDao = new carDAO();
            int result = cDao.statusCar(car);
            if (result > 0){
                out.println("<script type=\"text/javascript\">");
                out.println("alert(\"Update Successfully.\")");
                out.println("</script >");
                RequestDispatcher rd = request.getRequestDispatcher("modulCompany.jsp");
                rd.include(request,response);
                
            }
            database.closeConnection();
        %>
        
    </body>
</html>
