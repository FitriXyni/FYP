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
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%Blob image = null;

                Connection con = null;
                byte[] imgData = null;
                Statement stmt = null;
                ResultSet rs = null;
                String carId=request.getParameter("id");
                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental", "root", "admin");
                    stmt = con.createStatement();
                    rs = stmt.executeQuery("select car_image from car_type where car_id ='"+carId+"'");
                    if (rs.next()) {

                        image = rs.getBlob(1);
                        imgData = image.getBytes(1, (int) image.length());

                    } else {

                        out.println("Display Blob Example");
                        out.println("image not found for given id>");
                        return;

                    }

 // display the image 
                    response.setContentType("image/gif");
                    OutputStream o = response.getOutputStream();
                    o.write(imgData);
                    o.flush();
                    o.close();

                } catch (Exception e) {

                    out.println("Unable To Display image");
                    out.println("Image Display Error=" + e.getMessage());
                    return;

                } finally {

                    try {

                        
                        stmt.close();
                        con.close();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
               }%>
    </body>
</html>