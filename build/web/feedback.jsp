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
<%@page import="carrental.carDAO,user.customer" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="stylingFont.css">
        <link rel="stylesheet" type="text/css" href="homepage.css">
    </head>
    <body>
          <%
        String feedback = request.getParameter("message");
        
        String message="";
    if(request.getMethod().equalsIgnoreCase("POST")){
        
        
        int user=carDAO.giveFeedback(feedback);
        String page1="mainPage.jsp";
        
        if(user>0){
           
           page1="adsList.jsp";
           message = "Feedback Succesufully Sent!";
        }else{
            message="Cannot Send!";
        }
        out.println("<script type=\"text/javascript\">");
                    out.println("alert(\""+message+"\")");
                    out.println("</script>");
                    response.sendRedirect(page1);
        }  %>
        <nav class="headerNav">
            <ul>

                <li><a href="feedback.jsp">Feed back</a></li>
                <li id="navDropdownMenu"><a href="index.html">Home</a></li>
            </ul>
        </nav>

        <div id="body">


            <div style="margin-top: 100px;">
                <h1 class="titleRent">Feed Back</h1>

                <center>
                    <form action="feedback.jsp" method="post">
                        <fieldset style="background-color: #ffffff; width: 400px; height:310px">
                            <legend>
                                <h1><b style="color:rgb(255, 166, 0);">Contact Us</b></h1>
                            </legend>
                            <br /><br />
                            <table>
                               
                                <tr>
                                    <td>FeedBack: </td>
                                    <td><input type="text" name="message"></td>
                                </tr>
                            </table><br /><br />

                            <input type="submit" value="Submit" id="btnSubmit">




                        </fieldset>
                    </form>
                </center>
            </div>
        </div>
    </body>
</html>
