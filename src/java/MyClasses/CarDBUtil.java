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
            props.load(new FileInputStream("MyDBParams.txt"));

            String user = props.getProperty("user");
            String password = props.getProperty("password");
            String dburl = props.getProperty("dburl");

            // connect to database
            Conn = DriverManager.getConnection(dburl, user, password);
           // Conn = DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.01:1433/Roshna_Sara_CarParkingIMS", "sa", "password");
            //----------------------

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSetMetaData getRsMetaData() {
        return rsMetaData;
    }

    public ArrayList<Car> searchCar(String car_model) {
        ArrayList<Car> list = new ArrayList<Car>();

        Statement myStmt = null;
        ResultSet reset = null;

        String query = "select  car_id, car_model, car_color, car_licence_number, car_driver_foreign_id\n"
                + "FROM         table_cars  where car_model like N'%" + car_model + "%'";
        try {
            myStmt = Conn.createStatement();

            reset = myStmt.executeQuery(query);
            this.rsMetaData = reset.getMetaData();

            while (reset.next()) {
                Car tempCar = new Car(reset.getInt("car_id"), reset.getInt("car_driver_foreign_id"), reset.getString("car_color"), reset.getString("car_model"), reset.getString("car_licence_number"));
                list.add(tempCar);
            }

            return list;
        } catch (Exception exc) {
        } finally {
            close(myStmt, reset);
        }
        return null;
    }
//==============================================================================

    public int deleteCar(int theCar_id) {

        int res = 0;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = Conn.createStatement();
            res = myStmt.executeUpdate("delete from table_cars where car_id=" + String.valueOf(theCar_id));

        } catch (Exception exc) {
        } finally {
            close(myStmt, myRs);
        }
        return res;
    }

    private void close(Statement myStmt, ResultSet myRs) {

        try {
            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insertCar(Car theNewCar) {

        int res = 0;
        Statement myStmt = null;
        ResultSet myRs = null;
        String query;
        query = "INSERT INTO [Roshna_Sara_CarParkingIMS].[dbo].[table_cars]\n"
                + "           ([car_model]\n"
                + "           ,[car_color]\n"
                + "           ,[car_licence_number]\n"
                + "           ,[car_driver_foreign_id])"
                + " values ('" + theNewCar.getCar_model() + "'"
                + ",'" + theNewCar.getCar_color() + "',"
                + "'" + theNewCar.getCar_licence_number() + "',"
                + theNewCar.getCar_driver_foreign_id() + " )";
        try {
            myStmt = Conn.createStatement();
            res = myStmt.executeUpdate(query);

        } catch (Exception exc) {
        } finally {
            close(myStmt, myRs);
        }
        return res;
    }

    public int UpdateCar(Car theNewCar) {

        int res = 0;
        Statement myStmt = null;
        ResultSet myRs = null;
        String query;
        query = "Update [Roshna_Sara_CarParkingIMS].[dbo].[table_cars]\n"
                + "    set       [car_model]\n = '" + theNewCar.getCar_model() + "'"
                + "           ,[car_color]= '" + theNewCar.getCar_color() + "'\n"
                + "           ,[car_licence_number] ='" + theNewCar.getCar_licence_number() + "'\n"
                + "           ,[car_driver_foreign_id]=" + theNewCar.getCar_driver_foreign_id()
                + "\n WHERE       car_id=" + theNewCar.getCar_id();
        try {
            myStmt = Conn.createStatement();
            res = myStmt.executeUpdate(query);

        } catch (Exception exc) {
        } finally {
            close(myStmt, myRs);
        }
        return res;
    }
//==============================================================================

    public ArrayList<Car> getAllCars(String car_model, int carID) {
        ArrayList<Car> list = new ArrayList<Car>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myStmt = Conn.createStatement();
            String q = "select * from table_cars where car_model like N'%" + car_model + "%'";
            if (carID != 0) {
                q += "and car_id=" + carID;
            }
            myRs = myStmt.executeQuery(q);
            this.rsMetaData = myRs.getMetaData();
            while (myRs.next()) {
                Car tempCar = new Car(myRs.getInt("car_id"), myRs.getInt("car_driver_foreign_id"), myRs.getString("car_color"), myRs.getString("car_model"), myRs.getString("car_licence_number"));
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
