<%-- 
    Document   : ParkDisplay
    Created on : Jan 26, 2018, 8:24:36 PM
    Author     : roshn
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="MyClasses.Park"%>
<%@page import="MyClasses.ParkDBUtil"%>
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
            <h1>Park Added!</h1>
            <h4>this is your info</h4>
            <%
                ParkDBUtil newParkDBUtil;
                newParkDBUtil = new ParkDBUtil();
                try {

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String txtTime_form = request.getParameter("txtTime_form");
                    String txtTime_to = request.getParameter("txtTime_to");
                    int txtCar_foreign_id = Integer.parseInt(request.getParameter("cbxCar"));
                    int txtStaff_foreign_id = Integer.parseInt(request.getParameter("cbxStaff"));
                    int txtAmount_paid = Integer.parseInt(request.getParameter("txtAmountPaid"));
                    int owner = 0;
                    try {
                        owner = Integer.parseInt(cbxOwner);
                    } catch (Exception exc) {
                    }
                    if (owner != 0) {
                        Park newPark = new Park(txtCar_foreign_id, txtStaff_foreign_id, sdf.parse(txtTime_form), sdf.parse(txtTime_to), txtAmount_paid);
                        newParkDBUtil.insertPark(newPark);

            %>
            <table>
                <tbody>
                    <tr>
                        <td>The car stayed for  </td>
                            <td><%    long difference = sdf.parse(txtTime_form).getTime() - sdf.parse(txtTime_to).getTime();
                                System.out.println((int) ((difference / (1000 * 60 * 60)) % 24));%></td>
                    </tr>
                    <tr>
                        <td>And paid </td>
                        <td><%= txtAmount_paid%></td>
                    </tr>

                </tbody>
            </table><%} else {%><td><%="Error!"%></td>
            <%}
                } catch (Exception exc) {
                }%>
        </div></center>
</body>
</html>
