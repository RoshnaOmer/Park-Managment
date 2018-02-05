<%-- 
    Document   : ParkDisplay
    Created on : Jan 26, 2018, 8:24:36 PM
    Author     : roshn
--%>

<%@page import="java.util.Date"%>
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
              <jsp:include page="Header.jsp" />
 
            <h1>Park Added!</h1>
            <h4>this is your info</h4>
            <%
                ParkDBUtil newParkDBUtil;
                newParkDBUtil = new ParkDBUtil();
                try {
                    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                    final SimpleDateFormat sdformatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

                    Date txtTime_form = sdf.parse(request.getParameter("txtDateFrom"));
                    Date txtTime_to = sdf.parse(request.getParameter("txtDateTo"));
                    
                        long difference = txtTime_to.getTime()-txtTime_form.getTime();
                                double hrs = ((double) ((difference / (1000 * 60 * 60)) % 24));
                    int txtCar_foreign_id = Integer.parseInt(request.getParameter("cbxCar"));
                    int txtStaff_foreign_id = Integer.parseInt(request.getParameter("cbxStaff"));
//                    Price, txtAmountPaid
                    int txtAmount_paid = (int)hrs*1000;
                    int owner = 0;

                    if (txtStaff_foreign_id != 0) {
                        try {
                            Park newPark = new Park(txtCar_foreign_id, txtStaff_foreign_id, sdformatter.format(txtTime_form), sdformatter.format(txtTime_to), txtAmount_paid);
                            newParkDBUtil.insertPark(newPark);
                        } catch (Exception exc) {
                            out.println(exc.getMessage());
                        }
            %>
            <table>
                <tbody>
                    <tr>
                        <td>The car stayed for  </td>
                        <td><%out.println(hrs+" Hours");%></td>
                    </tr>
                    <tr>
                        <td>And paid </td>
                        <td><%= txtAmount_paid%></td>
                    </tr>

                </tbody>
            </table><%} else {%><td><%="Error!"%></td>
            <%}
                } catch (Exception exc) {
                    out.println(exc.getMessage());
                }%>
        </div></center>
        <jsp:include page="Footer.jsp" />
</body>
</html>
