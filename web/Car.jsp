<%-- 
    Document   : Car
    Created on : Jan 19, 2018, 7:52:22 PM
    Author     : roshn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.*"%>
<%@page import="MyClasses.Person"%>
<%@page import="MyClasses.PersonDBUtil"%>
<%@page import="MyClasses.Car"%>
<%@page import="MyClasses.CarDBUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
            function printPage() {
                window.print();
                return  false;
            }
            function RegisterNew() {
                window.open("NewCar.jsp");

            }
        </script>
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
            .table1 {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            .td1, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            .button {
                background-color: #4CAF50; /* Green */
                border: none;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 11px;
                margin: 4px 2px;
                cursor: pointer;
            }

            .buttonPurple{background-color: #e3c1ff; color: black;}
            .buttonGray {background-color: #e7e7e7; color: black;} /* Gray */ 
            h1 {
                text-shadow: 3px 2px #e7e7e7;
            }
        </style>
        <title>Car</title>
    </head>
    <body >
        <%try {
                PersonDBUtil personDBUtil = new PersonDBUtil();
                String username = (String) session.getAttribute("username");
                String password = (String) session.getAttribute("password");
                String role = (String) session.getAttribute("role");
                int currentpersonID = personDBUtil.CheckPerson(username, password, Integer.parseInt(role));
                if (currentpersonID != 0) {%>
        <div class="fullScreen">             <jsp:include page="Header.jsp" />

            <form >
                <input type="submit" class="button buttonPurple" onclick="RegisterNew()" value="Add New" /> 

                <input type="submit" class="button buttonGray" value="Print" onclick="printPage()" />
            </form>
            <center>
                <h1>Car List </h1>
                <form name="SearchForm" action="Car.jsp" method="">
                    <table >
                        <tr>
                            <td colspan="1">Model</td>
                            <td colspan="7"><input type="text" name="txtKeyword"  size="50" />  </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td> <input type="submit" class="button" value="Search" />  </td>
                        </tr>
                    </table>
                </form>
                <table class="table1" border="1" cellpadding="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Model</th>
                            <th>License N</th>
                            <th>Color</th>
                            <th>Owner</th>

                            <%//if authorized then%>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%                            
                            CarDBUtil carDBUtil;
                            carDBUtil = new CarDBUtil();
                            boolean canEdit = false;
                            //EDIT
                            int EditID = request.getParameter("txtEdit") == null ? 0 : Integer.parseInt(request.getParameter("txtEdit"));
                            if (EditID > 0) {
                                canEdit = true;
                            }
                            //UPDATE
                            int UpdateID = request.getParameter("txtUpdate") == null ? 0 : Integer.parseInt(request.getParameter("txtUpdate"));
                            if (UpdateID > 0) {

                                String txtCar_model = request.getParameter("txtCar_model");
                                String txtCar_licence_number = request.getParameter("txtCar_licence_number");
                                String txtCar_color = request.getParameter("cbxColor");
                                int txtCar_driver_foreign_id = Integer.parseInt(request.getParameter("cbxOwner"));

                                Car newCar = new Car(UpdateID, txtCar_driver_foreign_id, txtCar_color, txtCar_model, txtCar_licence_number);

                                carDBUtil.UpdateCar(newCar);
                            }

                            //DELETE
                            String DeleteID = request.getParameter("txtDelete");
                            if (DeleteID != null) {
                                carDBUtil.deleteCar(Integer.parseInt(DeleteID));
                            }
                            //SEARCH
                            String key = request.getParameter("txtKeyword") == null ? "" : request.getParameter("txtKeyword");

                            List<Car> allCars = carDBUtil.getAllCars(key, 0);

                            for (Car oneCar : allCars) {
                        %>
                        <tr>

                            <td class="td1"><%=oneCar.getCar_id()%></td>
                            <td class="td1"><%=oneCar.getCar_model()%></td>
                            <td class="td1"><%=oneCar.getCar_licence_number()%></td>
                            <td class="td1"><%=oneCar.getCar_color()%></td>
                            <%List<Person> CarOwner = personDBUtil.getAllPeople("", "", oneCar.getCar_driver_foreign_id(), 2);

                                for (Person onePerson : CarOwner) {%>
                            <td class="td1"><%=onePerson.getPerson_full_name()%></td>
                            <%}%>
                            <!--Edit button-->
                            <td class="td1" align=" center">
                                <form name="toEditForm" action="Car.jsp" method="">  
                                    <input type="text" name="txtEdit" value="<%=oneCar.getCar_id()%>" size="50" style="display:none" />
                                    <input class="button buttonPurple" type="submit" value="Edit"   />
                                </form>
                            </td>
                            <!--Delete Button-->
                    <form name="DeleteForm" action="Car.jsp" method="">
                        <td  class="td1" align=" center"> <input type="text" name="txtDelete" value="<%=oneCar.getCar_id()%>" size="50" style="display:none" />
                            <input class="button buttonGray" type="submit" value="Delete" name="btnDelete"   />
                        </td>
                    </form>
                    </tr>
                    <%if (EditID == oneCar.getCar_id()) {

                    %>
                    <tr>
                    <form name="EditForm" action="Car.jsp" method="">                        
                        <td class="td1"><%=oneCar.getCar_id()%></td>
                        <td class="td1"><input type="text" name="txtCar_model" value="<%=oneCar.getCar_model()%>" width="50"/></td>
                        <td class="td1"><input type="text" name="txtCar_licence_number" value="<%=oneCar.getCar_licence_number()%>" width="50"/></td>
                        <td>
                            <select required name="cbxColor">
                                <option  value="<%=oneCar.getCar_color()%>"><%=oneCar.getCar_color()%></option>
                                <option value="Black">Black</option>
                                <option value="White">White</option>
                                <option value="Blue">Blue</option>
                                <option value="Red">Red</option>
                                <option value="Other">Other</option>
                            </select>
                        </td>
<!--                        <td class="td1"><input type="text" name="txtCar_driver_foreign_id" value="<%=oneCar.getCar_driver_foreign_id()%>" width="50"/></td>-->
                        <td>
                            <select required name="cbxOwner">
                                <option  value="">---Select---</option>

                                <%
                                    List<Person> allPeople = personDBUtil.getAllPeople("", "", 0, 2);

                                    for (Person onePerson : allPeople) {%>
                                <option value="<%=onePerson.getPerson_id()%>"><%=onePerson.getPerson_full_name()%></option>

                                <%}
                                %>
                            </select>
                        </td>
                        <td class="td1" align=" center"> 
                            <input type="text" name="txtUpdate" value="<%=oneCar.getCar_id()%>" size="50" style="display:none" />
                            <input class="button " type="submit" value="btnUpdate"   />
                        </td>
                    </form></tr>
                    <%}
                        }%>
                    </tbody>
                </table>

            </center></div>
            <%
                    } else
                        response.sendRedirect("loginPage.jsp");
                } catch (Exception exc) {
                    response.sendRedirect("loginPage.jsp");
                }%>
            <jsp:include page="Footer.jsp" />
    </body>
</html>
