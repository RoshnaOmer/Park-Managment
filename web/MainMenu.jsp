<%-- 
    Document   : MainMenu
    Created on : Jan 5, 2018, 4:08:12 PM
    Author     : roshn
--%>

<%@page import="java.util.*"%>
<%@page import="MyClasses.Person"%>
<%@page import="MyClasses.Role"%>
<%@page import="MyClasses.PersonDBUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parking Management Info System</title>
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
    </head>
    <body style="background-image: url(Images/website_background.jpg);background-repeat: no-repeat;background-size: 100%;" >
 <%
                PersonDBUtil personDBUtil;
                personDBUtil = new PersonDBUtil();
                String username = (String) session.getAttribute("username");
                String password = (String) session.getAttribute("password");
                String role = (String) session.getAttribute("role");
                String txtUserName = request.getParameter("txtUserName") != null ? request.getParameter("txtUserName") : username;
                String txtPassword = request.getParameter("txtPassword") != null ? request.getParameter("txtPassword") : password;
                int cbxRoles = 0;
                try {
                    cbxRoles = request.getParameter("cbxRoles") != null ? Integer.parseInt(request.getParameter("cbxRoles")) : Integer.parseInt(role);
                } catch (Exception exc) {
                }
                Role myrole = new Role();
            %>
        <jsp:include page="Header.jsp" />


        <div>
           
            <center><h1>Car Parking </h1>
                <h1>Information Management System</h1>
                <table border="0">

                    <tbody>
                        <%
                            //if user exists!
                            int personID = personDBUtil.CheckPerson(txtUserName, txtPassword, cbxRoles);
                            if (personID != 0) {
                                if (request.getParameter("btnSubmit")!=null&&request.getParameter("btnSubmit").equals("Submit")) {
                                    session.setAttribute("username", txtUserName);
                                    session.setAttribute("password", txtPassword);
                                    session.setAttribute("personid", personID);
                                    session.setAttribute("role", String.valueOf(cbxRoles));
                                }
                                String userRole = myrole.showRole(cbxRoles);
                        %>

                    <div class="container">

                        <div class="row">
                            <div class="col-sm-12">Welcome,  <%=userRole%> : <%=txtUserName%></div>
                        </div>
                    </div>

                    <div class="container">

                        <div class="row">
                            <%if (cbxRoles == 1) {%>
                            <div class="col-sm-3">
                                <form name="ShowPeopleForm" action="People.jsp" method="">
                                    <input class="button buttonPurple" type="submit" value="Show Registerd List" name="btnPeople"  />
                                </form>
                            </div>
                            <div class="col-sm-3">
                                <form name="ShowCarForm" action="Car.jsp" method="">
                                    <input class="button buttonGray" type="submit" value="Show Cars List" name="btnCar" />         
                                </form>
                            </div>

                            <div class="col-sm-3"> 
                                <form name="ShowParkForm" action="Park.jsp" method="">
                                    <input class="button buttonGray" type="submit" value="Show Park list" name="btnPark"/>
                                    <input class="button buttonGray" type="submit" style="display:none"  value="1" name="userRole"/>

                                </form>
                            </div>                    
                            <%} else {%>
                            <div class="col-sm-3"> 
                                <form name="ShowHistoryForm" action="Park.jsp" method="">     
                                    <input class="button buttonPurple" type="submit" value="Show my History" name="btnHistory" />
                                    <input class="button buttonGray" type="text" style="display:none"  value="2" name="userRole"/>
                                    <input class="button buttonGray" type="text" style="display:none"  value="<%=personID%>" name="personID"/>
                                </form>
                            </div><%}%>
                        </div>
                    </div>

                    <%} else {
                        //Redirect
                        response.sendRedirect("loginPage.jsp");
                    %>
                    <tr>
                        <td style="color: red">ERROR!</td>
                    </tr>
                    <tr>
                        <td><a href="loginPage.jsp">Go Back</a></td></tr><%}%>
            </center>
        </div>

        <jsp:include page="Footer.jsp" />

    </body>
</html>
