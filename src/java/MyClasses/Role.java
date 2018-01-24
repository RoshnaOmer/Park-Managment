/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author roshn
 */
public class Role {

    int role_id;
    String role_name;

    public Role() {
    }

    public  String showRole(int roleID) {
        if(roleID==0){return "";}
        Connection conn = null;
        ResultSet reset = null;
        DataBaseHelper dbHelper = new DataBaseHelper();
        conn = dbHelper.getAConnection();
        if (conn != null) {
            try {//TEST
                Statement stmt = conn.createStatement();
                String qry = "SELECT      role_id, role_name, is_admin\n"
                        + "FROM         table_roles\n"
                        + "WHERE     (role_id = " + roleID + ")";
                reset = stmt.executeQuery(qry);
                while (reset.next()) {
                    return reset.getString("role_name");
                }
            } catch (Exception e) {
                return "";
            } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    @Override
    public String toString() {
        return role_name;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

}
