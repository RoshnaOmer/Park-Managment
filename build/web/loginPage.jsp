<%-- 
    Document   : loginPage
    Created on : Jan 5, 2018, 3:57:01 PM
    Author     : roshn
--%>

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
        <title>Login</title>
    </head>
    <body style="background-image: url(Images/website_background.jpg);background-repeat: no-repeat;background-size: 100% auto;" >
    <center>  
        <h1>Welcome!</h1>
        <form name="loginForm" action="MainMenu.jsp" method="">
            <table border="0">               
                <tbody>
                    <tr>
                        <td>Role: </td>
                        <td><select name="cbxRoles" required>
                                <option value="">---Select---</option>
                                <option value="1">Staff</option>
                                <option value="2">Driver</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>User Name: </td>
                        <td><input type="text" name="txtUserName" placeholder="Enter Username"  required="true" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="txtPassword" placeholder="Enter password"  required="true" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>

            <input type="submit" class="button buttonPurple" value="Submit" name="btnSubmit" /> 
            <input type="reset" class="button buttonGray" value="Clear" name="btnClear" /> 
        </form>
        <br>
        <a href="Index.jsp">Not a Member? Register here</a>
    </center>  
</body>
</html>
