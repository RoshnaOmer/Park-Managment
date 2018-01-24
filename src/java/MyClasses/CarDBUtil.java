package MyClasses;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class CarDBUtil {

    private Connection Conn;
    private ResultSetMetaData rsMetaData;
    private Object dbHelper;

    public CarDBUtil() {
        String driver = "net.sourceforge.jtds.jdbc.Driver";
        try {
            Class.forName(driver).newInstance();
            //------------------------------
            // get db properties
            Properties props = new Properties();
//            props.load(new FileInputStream("MyDBParams.txt"));
//
//            String user = props.getProperty("user");
//            String password = props.getProperty("password");
//            String dburl = props.getProperty("dburl");

            // connect to database
            Conn = DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.01:1433/Roshna_Sara_CarParkingIMS", "sa", "rpcP@ssword");
            //----------------------

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public ResultSetMetaData getRsMetaData() {
        return rsMetaData;
    }

    public ArrayList<Car> searchCar(String car_id) throws Exception {
        ArrayList<Car> list = new ArrayList<Car>();

        Statement myStmt = null;
        ResultSet myRs = null;

        String query = "select * from table_cars where name like '%" + car_id + "%'";
        try {
            myStmt = Conn.createStatement();

            myRs = myStmt.executeQuery(query);
            this.rsMetaData = myRs.getMetaData();

            while (myRs.next()) {
                Car tempCar = convertRowToCar(myRs);
                list.add(tempCar);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }
//==============================================================================

    public int deleteCar(int theCar_id) throws Exception {

        int res;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = Conn.createStatement();
            res = myStmt.executeUpdate("delete from table_cars where car_id=" + String.valueOf(theCar_id));

        } finally {
            close(myStmt, myRs);
        }
        return res;
    }

    private void close(Statement myStmt, ResultSet myRs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Car convertRowToCar(ResultSet myRs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int insertCar(Car theNewCar) throws Exception {

        int res;
        Statement myStmt = null;
        ResultSet myRs = null;
        String query;
        query = "insert into table_cars (car_color,car_model,car_license_number) values ('"
                + theNewCar.getCar_color() + "','"
                + theNewCar.getCar_model() + "',"
                + String.valueOf(theNewCar.getCar_licence_number()) + ")";
        try {
            myStmt = Conn.createStatement();
            res = myStmt.executeUpdate(query);

        } finally {
            close(myStmt, myRs);
        }
        return res;
    }
//==============================================================================

    public ArrayList<Car> getAllCars() {
        ArrayList<Car> list = new ArrayList<Car>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myStmt = Conn.createStatement();
            myRs = myStmt.executeQuery("select * from table_cars");
            this.rsMetaData = myRs.getMetaData();
            while (myRs.next()) {
                Car tempCar = new Car(myRs.getInt("car_driver_foreign_id"), myRs.getString("car_color"), myRs.getString("car_model"), myRs.getString("car_licence_number"));
                list.add(tempCar);
            }

            return list;
        } catch (Exception exce) {
        } finally {
            close(myStmt, myRs);
        }
        return null;
    }
}
