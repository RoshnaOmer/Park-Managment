<%-- 
    Document   : Index
    Created on : Dec 31, 2017, 8:44:07 PM
    Author     : roshn
--%>

<%@page import="MyClasses.DataBaseHelper"%>
<%@page import="java.sql.*"%>

<%@page import="java.sql.Connection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <style>
            .button {
                background-color: #4CAF50; /* Green */
                border: none;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                width: 250px;
                cursor: pointer;
                box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
            }

            .buttonPurple{background-color: #e3c1ff; color: black;}
            .buttonGray {background-color: #e7e7e7; color: black;} /* Gray */ 
            h1 {
    text-shadow: 3px 2px #e7e7e7;
}
        </style>
        <title>User From</title>
    </head>
    <body style="background-image: url(Images/website_background.jpg);background-repeat: no-repeat;background-size: 100%;" >
    <center><h1>Register</h1>
        <h4>* Required</h4>

        <form name="RegisterForm" action="display.jsp" method="">
            <table border="0">                
                <tbody>
                    <tr>
                        <td>Full Name: *</td>
                        <td><input type="text" name="txtFullName" required="true" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>User Name: *</td>
                        <td><input type="text" name="txtUserName" required="true" value=""  size="50" /></td>
                    </tr>
                    <tr>
                        <td>Password: *</td>
                        <td><input type="text" name="txtPassword" required="true" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Phone Number: </td>
                        <td><input type="number" name="txtPhoneN" required="true" value="" size="7" /></td>
                    </tr>
                    <tr>
                        <td>Email: </td>
                        <td><input type="text" name="txtEmail" value="" required="true" size="50" /></td>
                    </tr>
<!--                    <tr>
                        <td>Gender: </td>
                        <td><input type="radio" name="myGroup" value="Male" /> Male
                            <br>
                            <input type="radio" name="myGroup" value="Female" />Female
                        </td>
                    </tr>-->
                    <tr>
                        <td>Birthday</td>
                        <td><input type="date" name="txtDayofB" required="true"  value="YYYY/MM/DD" size="15" /></td>
                    </tr>
                </tbody>
            </table>
            <br>
            <input type="reset" class="button buttonGray" value="Clear" name="btnClear" />
            <input type="submit" class="button buttonPurple" value="Submit" name="btnSubmit" />  
        </form>
        <br><a href="loginPage.jsp">Already a Member? Login here</a>
    </center>    
    </body>
</html>
