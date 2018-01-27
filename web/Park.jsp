<%-- 
    Document   : Park
    Created on : Jan 26, 2018, 10:07:34 AM
    Author     : roshn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.*"%>
<%@page import="MyClasses.Person"%>
<%@page import="MyClasses.PersonDBUtil"%>
<%@page import="MyClasses.Car"%>
<%@page import="MyClasses.CarDBUtil"%>
<%@page import="MyClasses.Park"%>
<%@page import="MyClasses.ParkDBUtil"%>
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
                window.open("NewPark.jsp");

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
        <title>Park</title>
    </head>
    <body >
        <div class="fullScreen">
            <a href="loginPage.jsp">Logout</a>
            <a href="MainMenu.jsp"> </a>
            <form >
                <input type="submit" class="button buttonPurple" onclick="RegisterNew()" value="Add New" /> 

                <input type="submit" class="button buttonGray" value="Print" onclick="printPage()" />
            </form>
            <center>
                <h1>Park List </h1>
                <form name="SearchForm" action="Park.jsp" method="">
                    <table >
                        <tr>
                            <td colspan="1">ID</td>
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
                            <th>Staff</th>
                            <th>Model</th>
                            <th>From</th>
                            <th>To</th>
                            <th>Amount Paid</th>
                                <%//if authorized then%>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            PersonDBUtil personDBUtil = new PersonDBUtil();
                            CarDBUtil carDBUtil = new CarDBUtil();
                            ParkDBUtil parkDBUtil;
                            parkDBUtil = new ParkDBUtil();
                            boolean canEdit = false;
                            //EDIT
                            int EditID = request.getParameter("txtEdit") == null ? 0 : Integer.parseInt(request.getParameter("txtEdit"));
                            if (EditID > 0) {
                                canEdit = true;
                            }
                            //UPDATE
                            int UpdateID = request.getParameter("txtUpdate") == null ? 0 : Integer.parseInt(request.getParameter("txtUpdate"));
                            if (UpdateID > 0) {

                                final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                                final SimpleDateFormat sdformatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

                                Date txtTime_form = sdf.parse(request.getParameter("txtTime_form"));
                                Date txtTime_to = sdf.parse(request.getParameter("txtTime_to"));
                                int txtCar_foreign_id = Integer.parseInt(request.getParameter("cbxCar"));
                                int txtStaff_foreign_id = (int) Double.parseDouble(request.getParameter("cbxStaff"));
                                int txtAmount_paid = (int) Double.parseDouble(request.getParameter("txtAmountPaid"));

                                Park newPark = new Park(UpdateID, txtCar_foreign_id, txtStaff_foreign_id,
                                        sdformatter.format(txtTime_form), sdformatter.format(txtTime_to), sdformatter.format(new Date()), txtAmount_paid);

                                parkDBUtil.UpdatePark(newPark);
                            }

                            //DELETE
                            String DeleteID = request.getParameter("txtDelete");
                            if (DeleteID != null) {
                                parkDBUtil.deletePark(Integer.parseInt(DeleteID));
                            }
                            //SEARCH
                            String key = request.getParameter("txtKeyword") == null ? "0" : request.getParameter("txtKeyword");
                            int userRole = 0;
                            String personID = "0";
                            try {
                                userRole = Integer.parseInt(request.getParameter("userRole"));
                                personID = request.getParameter("personID");
                            } catch (Exception exc) {
                            }

                            List<Park> allParks = parkDBUtil.getAllParks(personID, userRole);

                            for (Park onePark : allParks) {
                        %>
                        <tr>

                            <td class="td1"><%=onePark.getPark_id()%></td>
                            <%List<Person> Staff = personDBUtil.getAllPeople("", "", onePark.getStaff_foreign_id(), 1);
                                for (Person onePerson : Staff) {%>
                            <td class="td1"><%=onePerson.getPerson_full_name()%></td>
                            <%}%>
                            <%List<Car> CarOwner = carDBUtil.getAllCars("", onePark.getCar_foreign_id());
                                for (Car oneCar : CarOwner) {%>
                            <td class="td1"><%=oneCar.getCar_model()%></td>
                            <%}%>
                            <td class="td1"><%=onePark.getTime_form()%></td>
                            <td class="td1"><%=onePark.getTime_to()%></td>
                            <td class="td1"><%=onePark.getAmount_paid()%></td>

                            <!--Edit button-->
                            <td class="td1" align=" center">
                                <form name="toEditForm" action="Park.jsp" method="">  
                                    <input type="text" name="txtEdit" value="<%=onePark.getPark_id()%>" size="50" style="display:none" />
                                    <input class="button buttonPurple" type="submit" value="Edit"   />
                                </form>
                            </td>
                            <!--Delete Button-->
                    <form name="DeleteForm" action="Park.jsp" method="">
                        <td  class="td1" align=" center"> <input type="text" name="txtDelete" value="<%=onePark.getPark_id()%>" size="50" style="display:none" />
                            <input class="button buttonGray" type="submit" value="Delete" name="btnDelete"   />
                        </td>
                    </form>
                    </tr>
                    <%if (EditID == onePark.getPark_id()) {
                    %>
                    <tr>
                    <form name="EditForm" action="Park.jsp" method="">                        
                        <td class="td1"><%=onePark.getPark_id()%></td>
                        <td>
                            <select required name="cbxStaff">
                                <option  value="">---Select---</option>

                                <%
                                    List<Person> allStaff = personDBUtil.getAllPeople("", "", 0, 1);

                                    for (Person onePerson : allStaff) {%>
                                <option value="<%=onePerson.getPerson_id()%>"><%=onePerson.getPerson_full_name()%></option>
                                <%}%>
                            </select>
                        </td>
                        <td class="td1">
                            <select required name="cbxCar">
                                <option  value="">---Select---</option>
                                <%
                                    List<Car> allCars = carDBUtil.getAllCars("", onePark.getCar_foreign_id());
                                    for (Car oneCar : allCars) {%>
                                <option value="<%=oneCar.getCar_id()%>" ><%=oneCar.getCar_model()%></option><%}%> </select>
                        </td>
                        <td class="td1"><input type="datetime-local" name="txtTime_form" value="<%=onePark.getTime_form()%>" width="50"/></td>
                        <td class="td1"><input type="datetime-local" name="txtTime_to" value="<%=onePark.getTime_to()%>" width="50"/></td>
                        <td class="td1"><input type="number" name="txtAmountPaid" value="<%=onePark.getAmount_paid()%>" width="50"/></td>

                        <td class="td1" align=" center"> 
                            <input type="text" name="txtUpdate" value="<%=onePark.getPark_id()%>" size="50" style="display:none" />
                            <input class="button " type="submit" value="btnUpdate"   />
                        </td>
                    </form></tr>
                    <%
                            }
                        }%>
                    </tbody>
                </table>

            </center></div>
    </body>
</html>