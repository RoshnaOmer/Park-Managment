<%-- 
    Document   : NewCar
    Created on : Jan 25, 2018, 7:40:51 PM
    Author     : roshn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="java.util.*"%>
<%@page import="MyClasses.Person"%>
<%@page import="MyClasses.PersonDBUtil"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <style>
            .fullScreen
            {
                position:fixed;
                padding:0;
                margin:0;

                top:0;
                left:0;

                width: 100%;
                height: 100%;
                background-image: url(Images/website_background.jpg);

                background-size: 100%;
                overflow: auto;
            }
            
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
        <title>Car From</title>
    </head>
    <body style="background-image: url(Images/website_background.jpg);background-repeat: no-repeat;background-size: 100%;" >
    <center><h1>New Car</h1>
        <h4>* Required</h4>

        <form name="NewCarForm" action="CarDisplay.jsp" method="">
            <table border="0">                
                <tbody>
                    <tr>
                        <td>Model: *</td>
                        <td><input type="text" name="txtCarModel" required="true" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Color: *</td>
                        <td>
                            <select required name="cbxColor">
                                <option  value="">---Select---</option>
                                <option value="Black">Black</option>
                                <option value="White">White</option>
                                <option value="Blue">Blue</option>
                                <option value="Red">Red</option>
                                <option value="Other">Other</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>License Number: *</td>
                        <td><input type="text" name="txtCarLicenceNumber" required="true" value="" size="25" /></td>
                    </tr>
                    <tr>
                        <td>Owner: </td>
                        <td>
                            <select required name="cbxOwner">
                                <option  value="">---Select---</option>
                                
                                <%
                            PersonDBUtil personDBUtil = new PersonDBUtil();
                            List<Person> allPeople = personDBUtil.getAllPeople("", "", 0);

                            for (Person onePerson : allPeople) { %>
                                <option value="<%=onePerson.getPerson_id()%>"><%=onePerson.getPerson_full_name()%></option>
                                
                    <%}
                        %>
                            </select>
                        </td>
                    </tr>

                </tbody>
            </table>
            <br>
            <input type="reset" class="button buttonGray" value="Clear" name="btnClear" />
            <input type="submit" class="button buttonPurple" value="Submit" name="btnSubmit" />  
        </form>
        <br><a href="Index.jsp">New Owner? Register them here</a>
    </center>    
</body>
</html>
