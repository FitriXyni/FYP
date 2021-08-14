/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental;
import java.sql.*;
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
public class adminDAO {

    private final Connection connection;
    private int result;

    public adminDAO() {
        connection = DBConnection.getConnection();
    }    
    
    public int addAdmin(Admin admin) {
        try {
            String mySqlQuery = "insert into admin"
                    + "(adminID,adminPassword,adminName,adminContact)"
                    + "values (?,?,?,?)";
            PreparedStatement myPs = connection.prepareStatement(mySqlQuery);
            myPs.setString(1, admin.getAid());
            myPs.setString(2, admin.getApassword());
            myPs.setString(3, admin.getAname());
            myPs.setString(4, admin.getAcontact());
      
            
            

            result = myPs.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }
        return result;
    }
    
    public static Admin signinAdmin(String adminID, String adminPassword) {
        Admin admin = null;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from admin where adminID=? and adminPassword=?");

            ps.setString(1, adminID);
            ps.setString(2, adminPassword);

            ResultSet result = ps.executeQuery();

            if (result.next()) {

                admin = new Admin();
                admin.setAid(result.getString("adminID"));
                admin.setApassword(result.getString("adminPassword"));
                admin.setAname(result.getString("adminName"));
                admin.setAcontact(result.getString("adminContact"));
               
         

            }
            con.close();

        } catch (SQLException ex) {
        }
        return admin;
    }
    
    public int deleteAdmin(String flatno) {
        try {

            String mySqlQuery = "delete from car where flatno=?";
            PreparedStatement myPs = connection.prepareStatement(mySqlQuery);
            myPs.setString(1, flatno);

            result = myPs.executeUpdate();
        } catch (Exception e) {
            System.out.println("Excepetion is ;" + e);
        }
        return result;
    }
      public static List<Admin> retrieveFeedback() {
        List<Admin> carAll = new ArrayList<Admin>();
        Admin feedback;

        try {
             Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from feedback");
             ResultSet myRs = ps.executeQuery();
            while (myRs.next()) {
                feedback = new Admin();
                feedback.setFeedid(myRs.getString(1));
                feedback.setAfeedback(myRs.getString(2));
               
                carAll.add(feedback);
            }

        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }

        return carAll;
    } 
}
