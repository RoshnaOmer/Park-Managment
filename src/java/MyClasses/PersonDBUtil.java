/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClasses;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author roshn
 */
public class PersonDBUtil {

    private Connection myConn;
    private ResultSetMetaData rsMetaData;// we will need it later for search result show using Jtable

    public PersonDBUtil() {
        String driver = "net.sourceforge.jtds.jdbc.Driver";
        Properties prop = new Properties();
        try {
            Class.forName(driver).newInstance();
            //------------------------------
            // get db properties
            Properties props = new Properties();

           // FileInputStream fis = new FileInputStream("MyDBParams.txt");
//            props.load(new FileInputStream("MyDBParams.txt"));

            String user = props.getProperty("user");
            String password = props.getProperty("password");
            String dburl = props.getProperty("dburl");

            // load from input stream
           // prop.load(fis);

            // print the properties list from System.out
            //prop.list(System.out);
            // connect to database
            //myConn = DriverManager.getConnection(dburl, user, password);
             myConn = DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.01:1433/Roshna_Sara_CarParkingIMS", "sa", "pssword");
            //----------------------

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public ResultSetMetaData getRsMetaData() {
        return rsMetaData;
    }

    public List<Person> getAllPeople(String keyword, String PhoneN, int ID, int roleID) {
        ResultSet reset = null;

        List<Person> PersonList = new ArrayList<>();
        try {
            if (myConn != null) {
                Statement stmt = myConn.createStatement();
                String q = "SELECT      person_id, person_full_name, person_email, person_username, person_password, person_phone_no, person_birthday, role_foreign_id\n"
                        + " FROM         table_people\n"
                        + "WHERE     (person_full_name LIKE N'%" + keyword + "%' ) and ( person_phone_no like N'%" + PhoneN + "%')";
                if (ID != 0) {
                    q += " and (( person_id =" + ID + "))";
                }
                if (roleID != 0) {
                    q += " and (( role_foreign_id =" + roleID + "))";
                }
                reset = stmt.executeQuery(q);

                while (reset.next()) {
                    Person p = new Person(reset.getInt("person_id"), reset.getInt("role_foreign_id"), reset.getString("person_full_name"), reset.getString("person_email"),
                            reset.getString("person_username"), reset.getString("person_password"), reset.getString("person_phone_no"), reset.getDate("person_birthday"));
                    PersonList.add(p);
                }
                //conn.close();
            }
        } catch (Exception e) {
            String err = e.getMessage();
            err += "1";
        }
        return PersonList;
    }

    {//                    p.setPerson_id(reset.getInt("person_id"));
//                    p.setPerson_full_name(reset.getString("person_full_name"));
//                    p.setPerson_email(reset.getString("person_email"));
//                    p.setPerson_phone_no(reset.getString("person_phone_no"));
//                    p.setPerson_username(reset.getString("person_username"));
//                    p.setPerson_password(reset.getString("person_password"));
//                    p.setPerson_birthday(reset.getDate("person_birthday"));
//                    p.setRole_foreign_id(reset.getInt("role_foreign_id"));
    }

    public int UpdatePerson(Person newPerson) {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String dateStart = sdf.format(new Date());
        if (myConn != null) {
            try {//TEST
                Statement stmt = myConn.createStatement();
                SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy");
                SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
                String d1 = "";
                if (newPerson.person_birthday != null) {
                    d1 = sdf.format(newPerson.person_birthday);
                }
                String qry = "UPDATE [Roshna_Sara_CarParkingIMS].[dbo].[table_people]\n"
                        + "           SET [person_full_name] = '" + newPerson.getPerson_full_name() + "'\n"
                        + "           ,[person_email] = '" + newPerson.getPerson_email() + "'\n"
                        + "           ,[person_username] = '" + newPerson.getPerson_username() + "'\n"
                        + "           ,[person_password] = '" + newPerson.getPerson_password() + "'\n"
                        + "           ,[person_phone_no] = '" + newPerson.getPerson_phone_no() + "'\n"
                        //                     PROBLEM HERE  
                        //  + "           ,[person_birthday] = '" + sdf.format(newPerson.person_birthday) + "'\n"
                        //                        + "           ,[person_birthday] = '" + sdf.parse(d1) + "'\n"
                        + "           ,[role_foreign_id] = '" + newPerson.getRole_foreign_id() + "'\n"
                        + " WHERE       person_id=    '" + newPerson.getPerson_id() + "'";
                result = stmt.executeUpdate(qry);
                return result;
            } catch (Exception e) {
                return result;
            } finally {
                try {
                    //  conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public int SavePerson(Person newPerson) {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String dateStart = sdf.format(new Date());
        if (myConn != null) {
            try {//TEST
                Statement stmt = myConn.createStatement();
                String qry = "INSERT INTO [Roshna_Sara_CarParkingIMS].[dbo].[table_people]\n"
                        + "           ([person_full_name]\n"
                        + "           ,[person_email]\n"
                        + "           ,[person_username]\n"
                        + "           ,[person_password]\n"
                        + "           ,[person_phone_no]\n"
                        + "           ,[person_birthday]\n"
                        + "           ,[role_foreign_id])\n"
                        + "     VALUES\n"
                        + "           ('" + newPerson.getPerson_full_name() + "'\n"
                        + "           ,'" + newPerson.getPerson_email() + "'\n"
                        + "           ,'" + newPerson.getPerson_full_name() + "'\n"
                        + "           ,'" + newPerson.getPerson_password() + "'\n"
                        + "           ,'" + newPerson.getPerson_phone_no() + "'\n"
                        + "           ,'" + sdf.format(newPerson.getPerson_birthday()) + "'\n"
                        + "           ,'" + newPerson.getRole_foreign_id() + "')";
                result = stmt.executeUpdate(qry);
                return result;
            } catch (Exception e) {
                return result;
            } finally {
                try {
                    //  conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public int CheckPerson(String userName, String password, int role) {
        if (myConn != null) {
            try {//TEST
                Statement stmt = myConn.createStatement();
                String qry = "SELECT     person_id,person_full_name, role_foreign_id \n"
                        + "FROM         table_people \n"
                        + "WHERE     (person_username = N'" + userName + "')"
                        + " AND (person_password = N'" + password + "') AND (role_foreign_id = " + role + " )";
                ResultSet rSet = stmt.executeQuery(qry);
                while (rSet.next()) {
                    return rSet.getInt("person_id");
                }
            } catch (Exception e) {
                return 0;
            } finally {
                try {
                    // conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    public int deletePerson(int person_id) {

        int res = 0;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            res = myStmt.executeUpdate("delete from table_people where person_id=" + String.valueOf(person_id));

        } catch (Exception exc) {
        } finally {
            close(myStmt, myRs);
        }
        return res;
    }

//==============================================================================
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

}
