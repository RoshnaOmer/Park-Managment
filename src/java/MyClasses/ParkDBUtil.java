/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class ParkDBUtil {

    private Connection Conn;
    private ResultSetMetaData rsMetaData;
    private Object dbHelper;

    public ParkDBUtil() {
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

    public ArrayList<Park> searchPark(String park_id) throws Exception {
        ArrayList<Park> list = new ArrayList<Park>();

        Statement myStmt = null;
        ResultSet myRs = null;

        String query = "select * from table_park where name like '%" + park_id + "%'";
        try {
            myStmt = Conn.createStatement();

            myRs = myStmt.executeQuery(query);
            this.rsMetaData = myRs.getMetaData();

            while (myRs.next()) {
                Park tempPark = new Park(myRs.getInt("park_id"), myRs.getInt("car_foreign_id"), myRs.getInt("staff_foreign_id"),
                        myRs.getDate("time_form"), myRs.getDate("time_to"), myRs.getDate("created_on"), myRs.getDouble("amount_paid"));
                list.add(tempPark);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }
//==============================================================================

    public int deletePark(int thePark_id) throws Exception {

        int res;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = Conn.createStatement();
            res = myStmt.executeUpdate("delete from table_park where park_id=" + String.valueOf(thePark_id));

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

    public int insertPark(Park theNewPark) throws Exception {

        int res;
        Statement myStmt = null;
        ResultSet myRs = null;
        String query;
        query = "INSERT INTO [Roshna_Sara_CarParkingIMS].[dbo].[table_park]\n"
                + "           ([car_foreign_id]\n"
                + "           ,[staff_foreign_id]\n"
                + "           ,[time_from]\n"
                + "           ,[time_to]\n"
                + "           ,[created_on]\n"
                + "           ,[amount_paid])\n"
                + "     VALUES\n"
                + "           ("
                + theNewPark.getCar_foreign_id() + ","
                + theNewPark.getStaff_foreign_id() + ",'"
                + String.valueOf(theNewPark.getTime_form()) + "','"
                + String.valueOf(theNewPark.getTime_to()) + "','"
                + String.valueOf(theNewPark.getCreated_on()) + "',"
                + theNewPark.getAmount_paid() + ")";
        try {
            myStmt = Conn.createStatement();
            res = myStmt.executeUpdate(query);

        } finally {
            close(myStmt, myRs);
        }
        return res;
    }
//==============================================================================

    public int UpdatePark(Park theNewPark) {

        int res = 0;
        Statement myStmt = null;
        ResultSet myRs = null;
        String query;
        query = "UPDATE [Roshna_Sara_CarParkingIMS].[dbo].[table_park]\n"
                + "   SET [car_foreign_id] = " + theNewPark.getCar_foreign_id()
                + "      ,[staff_foreign_id] = " + theNewPark.getStaff_foreign_id()
                + "      ,[time_from] = '" + theNewPark.getTime_form() + "'\n"
                + "      ,[time_to] = '" + theNewPark.getTime_to() + "'\n"
                + "      ,[created_on] = getdate()\n"
                + "      ,[amount_paid] = " + theNewPark.getAmount_paid()
                + "\n WHERE       park_id=" + theNewPark.getPark_id();

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

    public ArrayList<Park> getAllParks(String key) {
        ArrayList<Park> list = new ArrayList<Park>();
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myStmt = Conn.createStatement();
            String q = "select * from table_park ";
            if (!key.equals("0")) {
                q = "where park_id=" + key;
            }
            myRs = myStmt.executeQuery(q);
            this.rsMetaData = myRs.getMetaData();
            while (myRs.next()) {

                Park tempPark = new Park(myRs.getInt("park_id"), myRs.getInt("car_foreign_id"), myRs.getInt("staff_foreign_id"),
                        myRs.getDate("time_form"), myRs.getDate("time_to"), myRs.getDate("created_on"), myRs.getDouble("amount_paid"));
                list.add(tempPark);
            }

            return list;
        } catch (Exception exce) {
        } finally {
            close(myStmt, myRs);
        }
        return null;
    }

}
