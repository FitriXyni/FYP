/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
Kumpulan 3: Car Rental System

   Nama Ahli Kumpulan :

   1.Muhamad Nurfitri Bin Zaini        (S52188)
   2.Ahmad Irfan Naim Bin Amir Hamzah  (S52043)
   3.Muhammad Hanif Bin Mohd Nawawi    (S51914)
   4.Kamarul Khairi Bin Rosdi          (S51565)
   5.Muhammad Nur Syazreen Bin Affendy (S50880)
 */
public class customerDAO {
     public static Connection getConnenction() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental", "root", "admin");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return con;
    }
     
     public static int registerCustomer(customer customer) {
        int status = 0;
        try {
            Connection con = customerDAO.getConnenction();
            PreparedStatement ps = con.prepareStatement("insert into customer (name,password,email) values (?,?,?)");
            
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPassword());
            

            status = ps.executeUpdate();
            
            
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }
     
     public static customer signInCustomer (String email, String password){
         customer customer1 = null;
         try {
            Connection con = customerDAO.getConnenction();
            PreparedStatement ps = con.prepareStatement("select * from customer where email=? and password=?");

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet result = ps.executeQuery();

            if (result.next()) {

                customer1 = new customer();
               
                customer1.setEmail(result.getString("email"));
                customer1.setId(result.getString("id"));
                customer1.setName(result.getString("name"));
                customer1.setPassword(result.getString("password"));
               

            }
            con.close();

        } catch (SQLException ex) {
        }
        return customer1;
     }
     
     
    
}
