<%-- 
    Document   : CarDisplay
    Created on : Jan 25, 2018, 8:20:52 PM
    Author     : roshn
--%>

<%@page import="MyClasses.PersonDBUtil"%>
<%@page import="java.util.List"%>
<%@page import="MyClasses.Person"%>
<%@page import="MyClasses.Car"%>
<%@page import="MyClasses.CarDBUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

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
            }</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Added</title>
    </head>
    <body>
    <center>
        <div class="fullScreen"> 
            <a href="loginPage.jsp">Logout</a>   
            <h1>Car Added!</h1>
            <h4>this is your info</h4>
            <%
                CarDBUtil newCarDBUtil;
                newCarDBUtil = new CarDBUtil();
                try {
                    String txtCarModel = request.getParameter("txtCarModel");
                    String cbxColor = request.getParameter("cbxColor");
                    String txtCarLicenceNumber = request.getParameter("txtCarLicenceNumber");
                    String cbxOwner = request.getParameter("cbxOwner");
                    int owner = 0;
                    try {
                        owner = Integer.parseInt(cbxOwner);
                    } catch (Exception exc) {
                    }
                    if (owner != 0) {
                        Car newCar = new Car(owner, cbxColor, txtCarModel, txtCarLicenceNumber);
                        newCarDBUtil.insertCar(newCar);

            %>
            <table>
                <tbody>
                    <tr>
                        <td>Model </td>
                        <td><%= txtCarModel%></td>
                    </tr>
                    <tr>
                        <td>Color </td>
                        <td><%= cbxColor%></td>
                    </tr>
                    <tr>
                        <td>Owner </td>
                        <%
                            PersonDBUtil personDBUtil = new PersonDBUtil();
                            List<Person> allPeople = personDBUtil.getAllPeople("", "", owner);
                            for (Person onePerson : allPeople) {%>
                        <td ><%=onePerson.getPerson_full_name()%></td>
                        <%}%>
                    </tr>

                    <tr>
                        <td>License Number: </td>
                        <td><%= txtCarLicenceNumber%></td>
                    </tr>
                </tbody>
            </table><%} else {%><td><%="Error!"%></td>
            <%}
                } catch (Exception exc) {
                }%>
        </div></center>
</body>
</html>
