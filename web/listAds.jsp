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
<%@page import="java.util.List"%>
<%@page import="carrental.Car, carrental.DBConnection"%>
<jsp:useBean id="cDao" class="carrental.carDAO" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Vacancies</title>
        <style>
            h1 {
                font-family: "Helvetica Neue", Helvetica, Arial, sans-serif; font-size: 24px; font-style: normal; font-variant: normal; font-weight: 700; line-height: 26.4px; } 
            h3 { font-family: "Helvetica Neue", Helvetica, Arial, sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 700; line-height: 15.4px; } 
            p { font-family: "Helvetica Neue", Helvetica, Arial, sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 400; line-height: 20px; } 
            blockquote { font-family: "Helvetica Neue", Helvetica, Arial, sans-serif; font-size: 21px; font-style: normal; font-variant: normal; font-weight: 400; line-height: 30px; } 
            pre { font-family: "Helvetica Neue", Helvetica, Arial, sans-serif; font-size: 13px; font-style: normal; font-variant: normal; font-weight: 400; line-height: 18.5714px; }
            .center {

                display: block;
                margin-left: auto;
                margin-right: auto;
                margin-top: -100px;
                width: 20%;
            }

            .dropbtn {
                background-color: rgb(251, 255, 0);
                color: rgb(0, 0, 0);
                padding: 16px;
                padding-left: 50px;
                padding-right: 50px;
                font-size: 16px;
                border: none;
                border-radius: 10px;

            }

            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f1f1f1;
                min-width: 160px;
                border-radius: 10px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            .dropdown-content a {
                color: black;
                padding: 12px 76px;
                text-decoration: none;
                display: block;
            }

            .dropdown-content a:hover {background-color: #ddd;}

            .dropdown:hover .dropdown-content {display: block;}

            .dropdown:hover .dropbtn {background-color: #3e8e41;}

            html {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;

            }
            body{
                margin: 0;
            }

            .container {
                background-color: #efc4b3;
                padding: 1rem;
            }

            .header {
                background-color: #99dd1b;
            }

            .header h1 {
                margin: 0;
                padding: 3rem 0 1rem 0;
                text-align: center;
            }

            .header img {
                height: 6rem;
                float: right;
            }

            .headerNav {
                background-color: #9b500f;
                color: white;
                align-items: center;
                padding-top: 1rem;
                padding-bottom: 1rem;
                position: relative;

            }

            .headerNav * {
                display: inline;
            }

            .headerNav li {
                margin-right: 1rem;
                margin-left: 0;
            }

            .headerNav a {
                color: white;
                text-decoration: none;
            }

            .headerNav a:hover {
                text-decoration: none;
                color: #42240c;
            }

            .table{
                float: right;
            }
            legend{
                background-color: white;
                padding: 20;
                padding-left: 50px;
                padding-right: 50px;
                border-radius: 10em;
                border-color: #99dd1b;

            }
            fieldset{
                border: none;
                border-radius: 10px;
            }

            .titleRent{
                width: 40%;
                text-align: center;
                background-color: #f1f1b0;
                padding: 20px;
                border-radius: 20px;
                margin: auto;
                margin-top: 20px;
                margin-bottom: 20px;

            }


            #navDropdownMenuContent {
                display: none;
                position: absolute;
                top: 53px;
                min-width: 10rem;
                background-color: #ff6600;
                padding: 1rem;
            }

            #navDropdownMenuContent li {
                float: none;
                color: black;
                text-decoration: none;
                display: block;
                margin-top: 0.5rem;
            }

            #navDropdownMenu:hover{
                background-color: #42240c;
                padding: 15px;
            }
            /* Show the dropdown menu on hover */
            #navDropdownMenu:hover #navDropdownMenuContent {
                display: block;
            }

            #body {


                padding: 1rem 4rem 7rem 4rem;
                background-blend-mode: multiply;

            }
            body{
                background-image: url('redcar.jpg');
                height: 900px;
            }

            #body p {
                border: thick double;
            }

            #center {
                display: block;
                margin-left: auto;
                margin-right: auto;
                width: 20%;
            }

            #btnSubmit{
                padding: 5px 30px 5px 30px;
                background-color: #e1d6ff;
                color: rgb(0, 2, 3);
                border: none;
                border-radius: 10px;
            }

        </style>
    </head>
    <%
        

        List<Car> carAll = cDao.retrieveAllCar();
        DBConnection database = new DBConnection();
        database.closeConnection();
    %>
    <body>


        <nav class="headerNav">
            <ul>

                <li><a href="modulCompany.jsp">Back</a></li>
                <li id="navDropdownMenu"><a href="mainPage.jsp">Home</a></li>
            </ul>
        </nav>

        <div id="body">

            <img style="width: 200px; height: 200px; border-radius: 60%;" src="https://www.logopik.com/wp-content/uploads/edd/2018/06/Car-Rental-Logo.png" alt="Logo" id="center">

            <br/>
            <center><h2 style="color: white">Your Cars Information</h2></center>


            
            <table style="background-color: #ffe8df; width: 1000px" align="center">
                <tr>
                    <th>ADS</th>
                    <th>FLAT NUMBER</th>
                    <th>RENT/HOURS</th>
                    <th>CONTACT</th>
                    <th>CAR BRAND</th>
                    <th>CAR TYPE</th>
                    <th>STATUS</th>
                    <th>ACTION</th>
                </tr>

                <% for (int i = 0; i < carAll.size(); i++) {%>
                <tr>

                    <td><center><img width="200" height="200" src="/ProjectCarRental/imgCar/image.jsp?id='<%=carAll.get(i).getFlatno()%>'"></center></td>
                <td><center><%=carAll.get(i).getFlatno()%></center></td>
                <td><center><%=carAll.get(i).getPrice()%></center></td>
                <td><center><%=carAll.get(i).getContact()%></center></td>
                <td><center><%=carAll.get(i).getCarname()%></center></td>
                <td><center><%=carAll.get(i).getCartype() %></center></td>
                <td><center><%=carAll.get(i).getCstatus() %></center></td>
                <td style="width: 170px"><center><a href=deleteCarAds.jsp?id="<%=carAll.get(i).getFlatno()%>">Remove</a></center>

                </td>
                </tr>
                <%}%>
            </table>
        </div>
    </center>

</body>

</html>