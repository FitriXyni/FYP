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
<%@page import="java.sql.*, user.customerDAO,user.customer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="carOffer.css">
    </head>
    <body style="background-image: url('redcar.jpg');">


        <div class="topnav">
            <a class="active" href="index.html">Home</a>
            <a href="#about">About</a>
            <a href="#contact">Contact</a>
            <div class="search-container">
                <form action="/action_page.php">
                    <input type="text" placeholder="Search.." name="search">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
        </div> 
    <center><h2>Choose Your Car!</h2></center>

    <br>
 <%
                    try {
                        Connection connection = customerDAO.getConnenction();
                        String myQuery = "select * from car_type";
                        Statement myStatement = connection.createStatement();
                        ResultSet myRs = myStatement.executeQuery(myQuery);
                        while (myRs.next()) {
                %>
    <div class="row">
        <div class="column">
            <div class="card">
               
                <img src="image_Car.jsp?id=<%=myRs.getString("car_id")%>" alt="j1" style="width:489px; height: 290px">
                <div class="container">
                    <h2><%=myRs.getString("car_type")%></h2>
                    <p class="title"><%=myRs.getString("car_name")%></p>
                   

                    <p><a href="carPlace.html"><button class="button">BOOK</button></a></p>
                </div>
            </div> 
        </div>
<%
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    %>

    </div>

</body>
</html>
