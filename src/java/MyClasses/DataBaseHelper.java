/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClasses;

import java.sql.*;

/**
 *
 * @author roshn
 */
public class DataBaseHelper {

    public Connection getAConnection() {
        try {
            String driver = "net.sourceforge.jtds.jdbc.Driver";
            Class.forName(driver).newInstance();
            String username = "sa";
            String password = "rpcP@ssword";

            String url = "127.0.01:1433/Roshna_Sara_CarParkingIMS;";

            String connString = "jdbc:jtds:sqlserver://" + url + ";user="
                    + username + ";password=" + password;
            Connection conn = DriverManager.getConnection(connString, username,
                    password);
            return conn;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

//        public ResultSet getCars() {
//            Connection conn = null;
//            ResultSet reset = null;
//            try {
//                conn = getAConnection();
//                if (conn != null) {
//                    Statement stmt = conn.createStatement();
//                    reset = stmt
//                            .executeQuery("SELECT car_id,car_name,car_color,car_licence_number,car_driver_foreign_id from table_cars");
//// Print the data to the console
////                    while (reset.next()) {
//////                    String  c = new reset.getString("fld_setting_name");
////                    }
////                    conn.close();
//                }
//            } catch (Exception e) {
//            }
//            return reset;
//        }
//        
}
