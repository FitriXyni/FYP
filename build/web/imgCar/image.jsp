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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>my image</title>
    </head>
    <body>
         <%@ page import="java.sql.*"%>
         <%@ page import="java.io.*"%>
            <%
                String flatno = request.getParameter("id");
                
                Blob photo = null;
                Connection con = null;
                byte[] imgData = null;
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental","root","admin");
                    stmt = con.createStatement();
                    rs = stmt.executeQuery("select photo from car where flatno=" + flatno);
                    if (rs.next()) {
                        photo = rs.getBlob(1);
                        imgData = photo.getBytes(1, (int) photo.length());
                    } else {
                        out.println("Display Blob Example");
                        out.println("image not found for given id>");
                        return;
                    }
            // display the image
                    response.setContentType("image/jpg");
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
                        rs.close();
                        stmt.close();
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            %>
    </body>
</html>
