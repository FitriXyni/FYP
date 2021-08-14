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
public class carDAO {

    private final Connection connection;
    private int result;

    public carDAO() {
        connection = DBConnection.getConnection();
    }
    
    public List<Car> retrieveAllCar(String compid) {
        List<Car> carAll = new ArrayList<Car>();
        Car car;

        try {
            Statement myStatement = connection.createStatement();
            String myQuery = "select * from car where compid="+compid;
            ResultSet myRs = myStatement.executeQuery(myQuery);
            while (myRs.next()) {
                car = new Car();
                car.setFlatno(myRs.getString(1));
                car.setPrice(myRs.getString(2));
                car.setContact(myRs.getString(3));
                car.setCarname(myRs.getString(4));
                car.setCartype(myRs.getString(5));
                car.setCid(myRs.getString(6));
                car.setCstatus(myRs.getString(7));
                car.setPhoto(myRs.getString(8));
                
                carAll.add(car);
            }

        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }

        return carAll;
    }
    
    public List<Car> retrieveAllAds() {
        List<Car> adsAll = new ArrayList<Car>();
        Car car;

        try {
            Statement myStatement = connection.createStatement();
            String myQuery = "SELECT * FROM car INNER JOIN company ON car.compid = company.compid where car.carStatus='Available'";
            ResultSet myRs = myStatement.executeQuery(myQuery);
            while (myRs.next()) {
                car = new Car();
                car.setFlatno(myRs.getString(1));
                car.setPrice(myRs.getString(2));
                car.setContact(myRs.getString(3));
                car.setCarname(myRs.getString(4));
                car.setCartype(myRs.getString(5));
                car.setCid(myRs.getString(6));
                car.setCstatus(myRs.getString(7));
                car.setPhoto(myRs.getString(8));
                car.setCpass(myRs.getString(10));
                car.setCompname(myRs.getString(11));
                car.setCompcontact(myRs.getString(12));
                car.setCompanylink(myRs.getString(13));
                car.setLocation(myRs.getString(14));
                
                adsAll.add(car);
            }

        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }

        return adsAll;
    }
    
     public List<Car> retrieveAllAdsSearch(String carType) {
        List<Car> adsAll = new ArrayList<Car>();
        Car car;

        try {
            Statement myStatement = connection.createStatement();
            String myQuery = "SELECT * FROM car INNER JOIN company ON car.compid = company.compid where car.cartype='"+carType+"' and car.carStatus='Available'";
            ResultSet myRs = myStatement.executeQuery(myQuery);
            while (myRs.next()) {
                car = new Car();
                car.setFlatno(myRs.getString(1));
                car.setPrice(myRs.getString(2));
                car.setContact(myRs.getString(3));
                car.setCarname(myRs.getString(4));
                car.setCartype(myRs.getString(5));
                car.setCid(myRs.getString(6));
                car.setCstatus(myRs.getString(7));
                car.setPhoto(myRs.getString(8));
                car.setCpass(myRs.getString(10));
                car.setCompname(myRs.getString(11));
                car.setCompcontact(myRs.getString(12));
                car.setCompanylink(myRs.getString(13));
                car.setLocation(myRs.getString(14));
                
                adsAll.add(car);
            }

        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }

        return adsAll;
    }
     
      public Car retrieveOneCar(String flatno) {
        Car car = new Car();
        try {
            Statement myStatement = connection.createStatement();
            String myQuery = "SELECT * FROM car "
                    + "where flatno=" +flatno;
            ResultSet myRs = myStatement.executeQuery(myQuery);
            while (myRs.next()) {
                car.setFlatno(myRs.getString(1));
                car.setPrice(myRs.getString(2));
                car.setContact(myRs.getString(3));
                car.setCarname(myRs.getString(4));
                car.setCartype(myRs.getString(5));
                car.setCid(myRs.getString(6));
                car.setCstatus(myRs.getString(7));
                car.setPhoto(myRs.getString(8));

            }
        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }
        return car;
    }
      
    public int statusCar(Car car) {
        try {

            String mySqlQuery = "update car set carStatus=? where flatno=?";
            PreparedStatement myPs = connection.prepareStatement(mySqlQuery);
            myPs.setString(1, car.getCstatus());
            myPs.setString(2, car.getFlatno());

            result = myPs.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }
        return result;
    }
     public List<Car> retrieveAllCar() {
        List<Car> carAll = new ArrayList<Car>();
        Car car;

        try {
            Statement myStatement = connection.createStatement();
            String myQuery = "SELECT * FROM car";
            ResultSet myRs = myStatement.executeQuery(myQuery);
            while (myRs.next()) {
                car = new Car();
                car.setFlatno(myRs.getString(1));
                car.setPrice(myRs.getString(2));
                car.setContact(myRs.getString(3));
                car.setCarname(myRs.getString(4));
                car.setCartype(myRs.getString(5));
                car.setCid(myRs.getString(6));
                car.setCstatus(myRs.getString(7));
                car.setPhoto(myRs.getString(8));
                
                carAll.add(car);
            }

        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }

        return carAll;
    }
   
      public static int giveFeedback(String message) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into feedback (feedback) values (?)");
            
            ps.setString(1, message);
           

            status = ps.executeUpdate();
            
            
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }
}