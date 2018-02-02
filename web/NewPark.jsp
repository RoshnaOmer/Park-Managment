<%-- 
    Document   : NewPark
    Created on : Jan 26, 2018, 8:04:00 PM
    Author     : roshn
--%>

<%@page import="MyClasses.Car"%>
<%@page import="MyClasses.CarDBUtil"%>
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
        <title>Park From</title>
    </head>
    <body style="background-image: url(Images/website_background.jpg);background-repeat: no-repeat;background-size: 100%;" >
    <center><h1>New Park</h1>
        <h4>* Required</h4>

        <form name="NewParkForm" action="ParkDisplay.jsp" method="">
            <table border="0">                
                <tbody>                    
                    <tr>
                        <td>Parked From: *</td>
                        <td><input type="datetime-local" name="txtDateFrom" required="true" value="" size="25" /></td>
                    </tr>
                    <tr>
                        <td>Parked To: *</td>
                        <td><input type="datetime-local" name="txtDateTo" required="true" value="" size="25" /></td>
                    </tr>
                    <tr>
                        <td>Model: *</td>
                        <td> <select required name="cbxCar">
                                <option  value="">---Select---</option>
                                <%CarDBUtil carDBUtil = new CarDBUtil();
                                    List<Car> allCars = carDBUtil.getAllCars("", 0);
                                    for (Car oneCar : allCars) {%>
                                <option value="<%=oneCar.getCar_id()%>" ><%=oneCar.getCar_model()%></option>
                                <%}%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Amount Paid: *</td>
                        <td><input type="number" name="txtAmountPaid" required="true" value="" size="25" /></td>
                    </tr>
                    <tr>
                        <td>Owner: </td>
                        <td>
                            <select required name="cbxStaff">
                                <option  value="">---Select---</option>

                                <%
                                    PersonDBUtil personDBUtil = new PersonDBUtil();
                                    List<Person> allStaff = personDBUtil.getAllPeople("", "", 0, 1);

                                    for (Person onePerson : allStaff) {%>
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
        <br><a href="NewCar.jsp">New Car? Register it here</a>
    </center>  
        <jsp:include page="Footer.jsp" />  
</body>
</html>