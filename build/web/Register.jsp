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
<%@page import="user.customer, user.customerDAO, java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylingFont.css">
        <link rel="stylesheet" type="text/css" href="homepage.css">
        <title>JSP Page</title>
    </head>
    <body>
         <%
        int status = 0;
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String error = "";

        Connection con = customerDAO.getConnenction();
        Statement st = con.createStatement();
        if (request.getMethod().equalsIgnoreCase("POST")) {
            try {
                String strQuery = "SELECT COUNT(*) FROM customer where email='" + email + "'";
                ResultSet rs = st.executeQuery(strQuery);
                rs.next();
                String Countrow = rs.getString(1);
                out.println(Countrow);
                if (Countrow.equals("0")) {
                    customer customer = new customer();

                    customer.setName(name);
                    customer.setEmail(email);
                    customer.setPassword(password);

                    status = customerDAO.registerCustomer(customer);
                    if(status>0){
                       response.sendRedirect("index.jsp");
                    }
                } else {
                    error = "Email Already Exist";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            con.close();
        }


    %>
         <nav class="headerNav">
            <ul>

                <li><a href="feedback.jsp">Feed back</a></li>
                <li id="navDropdownMenu"><a href="index.jsp">Home</a></li>
            </ul>
        </nav>

        <div id="body">

            <img style="width: 200px; height: 200px; border-radius: 60%;" src="https://www.logopik.com/wp-content/uploads/edd/2018/06/Car-Rental-Logo.png" alt="Logo" id="center">

            <h1 class="titleRent">Rent A Car!</h1>

            <center>
                <form action="Register.jsp" method="post">
                    <fieldset style="background-color: #ffffff; width: 400px; height:310px">
                        <legend><h1><b style="color:rgb(255, 166, 0);">Registration Form</b></h1></legend>
                        <label>Name </label>
                        <input type="text" name="name" size="50"/><br/><br/>
                        <label>Email: </label>
                        <input type="text" name="email" size="50"/><br/><br/>
                        <label>Password: </label>
                        <input type="text" name="password" size="50"/><br/><br/>
                        <input type="submit" id="btnSubmit" value="Login"/>
                        <a href="index.jsp" style="font-size: 13px; text-decoration: none" id="btnSubmit">I already have an account</a>

                       
                    </fieldset>
                </form>
            </center>
        </div>

    </body>
</html>
