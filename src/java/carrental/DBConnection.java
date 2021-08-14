/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
Kumpulan 3: Car Rental System

   Nama Ahli Kumpulan :

   1.Muhamad Nurfitri Bin Zaini        (S52188)
   2.Ahmad Irfan Naim Bin Amir Hamzah  (S52043)
   3.Muhammad Hanif Bin Mohd Nawawi    (S51914)
   4.Kamarul Khairi Bin Rosdi          (S51565)
   5.Muhammad Nur Syazreen Bin Affendy (S50880)
 */
public class DBConnection implements java.io.Serializable {

    public static Connection connection;

    public static Connection getConnection() {
        try {
            //Step 1: Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //Step 2: Establish a connection to mySql database
            String myUrl = "jdbc:mysql://localhost:3306/car_rental";
            connection = DriverManager.getConnection(myUrl, "root", "admin");
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
        }
        return connection;
    }

    public void closeConnection() {

        try {
            connection.close();
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}