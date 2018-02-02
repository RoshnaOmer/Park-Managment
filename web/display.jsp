<%-- 
    Document   : display
    Created on : Dec 31, 2017, 8:56:13 PM
    Author     : roshn
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="MyClasses.Person"%>
<%@page import="MyClasses.PersonDBUtil"%>

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
        <title>Welcome Page</title>
    </head>   
    <body >
        <div class="fullScreen">    <h1>Thank You For Registering!</h1>
            <h4>this is your info</h4>
            <%
                PersonDBUtil newPersonDBUtil;
                newPersonDBUtil = new PersonDBUtil();

                String txtFullName = request.getParameter("txtFullName");
                String txtUserName = request.getParameter("txtUserName");
                String txtPassword = request.getParameter("txtPassword");
                String txtPhoneN = request.getParameter("txtPhoneN");
                String txtEmail = request.getParameter("txtEmail");
                String Gender = request.getParameter("myGroup");
                String txtDayofB = request.getParameter("txtDayofB");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Person newPerson = new Person(txtFullName, txtEmail, txtUserName,
                        txtPassword, txtPhoneN, sdf.parse(txtDayofB));
                newPersonDBUtil.SavePerson(newPerson);
            %>
            <table>
                <tbody>
                    <tr>
                        <td>Name: </td>
                        <td><%= txtFullName%></td>
                    </tr>
                    <tr>
                        <td>Email: </td>
                        <td><%= txtEmail%></td>
                    </tr>
                    <!--                <tr>
                                        <td>Gender: </td>
                                        <td><--%= Gender%></td>
                                    </tr>-->
                    <tr>
                        <td>Birthday: </td>
                        <td><%= txtDayofB%></td>
                    </tr>
                </tbody>
            </table>
            <br>
            <a href="loginPage.jsp">Login Here</a>
        </div>
        <jsp:include page="Footer.jsp" />
    </body>
</html>
