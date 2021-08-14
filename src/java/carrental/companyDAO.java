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
public class companyDAO {

    private final Connection connection;
    private int result;

    public companyDAO() {
        connection = DBConnection.getConnection();
    }
    
    public int addCompany(Company company) {
        try {
            String mySqlQuery = "insert into company"
                    + "(compid,cpass,compname,compcontact,companylink,location)"
                    + "values (?,?,?,?,?,?)";
            PreparedStatement myPs = connection.prepareStatement(mySqlQuery);
            myPs.setString(1, company.getCompid());
            myPs.setString(2, company.getCpass());
            myPs.setString(3, company.getCompname());
            myPs.setString(4, company.getCompcontact());
            myPs.setString(5, company.getCompanylink());
            myPs.setString(6, company.getLocation());
            
            

            result = myPs.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }
        return result;
    }
    
    public static Company signinCompany(String comid, String compass) {
        Company company = null;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from company where compid=? and cpass=?");

            ps.setString(1, comid);
            ps.setString(2, compass);

            ResultSet result = ps.executeQuery();

            if (result.next()) {

                company = new Company();
                company.setCompid(result.getString("compid"));
                company.setCpass(result.getString("cpass"));
                company.setCompname(result.getString("compname"));
                company.setCompcontact(result.getString("compcontact"));
                company.setCompanylink(result.getString("companylink"));
                company.setLocation(result.getString("location"));
         

            }
            con.close();

        } catch (SQLException ex) {
        }
        return company;
    }
}
