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
<%@page import="user.customer, user.customerDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="stylingFont.css">
        <link rel="stylesheet" type="text/css" href="homepage.css">
    </head>
    <body>
        <%
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String type = request.getParameter("type");
        String message="";
    if(request.getMethod().equalsIgnoreCase("POST")){
        
        
        customer user = customerDAO.signInCustomer(email, pass);
        String page1="adsList.jsp";
        
        if(user!=null){
           request.getSession().setAttribute("user", user);
           page1="adsList.jsp";
           message = "Login Successful!";
        }else{
            message="Invalid email/password";
        }
        out.println("<script type=\"text/javascript\">");
                    out.println("alert(\""+message+"\")");
                    out.println("</script>");
                    response.sendRedirect(page1);
        }  %>
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
                <form action="index.jsp" method="post">
                    <fieldset style="background-color: #ffffff; width: 400px; height:310px">
                        <legend><h1><b style="color:rgb(255, 166, 0);">Registration Form</b></h1></legend>
                        <label>Email: </label>
                        <input type="text" name="email" size="50"/><br/><br/>
                        <label>Password: </label>
                        <input type="password" name="password" size="50"/><br/><br/>


                        <input type="submit" id="btnSubmit" value="Login"/>
                        <a href="Register.jsp" style="font-size: 13px; text-decoration: none" id="btnSubmit">Sign Up</a>

                        <h3 style="text-align: center">Sila tekan "Sign Up" jika belum berdaftar</h3>



                    </fieldset>
                </form>
            </center>
        </div>

    </body>
</html>
