<%-- 
    Document   : People
    Created on : Jan 12, 2018, 6:04:35 PM
    Author     : roshn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.*"%>
<%@page import="MyClasses.Person"%>
<%@page import="MyClasses.Role"%>
<%@page import="MyClasses.PersonDBUtil"%>
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
                window.open("Index.jsp");

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
        <title>People</title>
    </head>
    <body>
        <div class="fullScreen">
            <a href="loginPage.jsp">Logout</a>
            <a href="MainMenu.jsp">Go to Menu</a>
            <form >
                <input type="submit" class="button buttonPurple" onclick="RegisterNew()" value="Register New" /> 

                <input type="submit" class="button buttonGray" value="Print" onclick="printPage()" />
            </form><center><h1>People List </h1>
                <form name="SearchForm" action="People.jsp" method="">
                    <table >
                        <tr>
                            <td>ID</td>
                            <td colspan="7"> <input type="number" name="txtID"  size="50" /> </td>
                        </tr>
                        <tr>
                            <td colspan="1">Name</td>
                            <td colspan="7"><input type="text" name="txtKeyword"  size="50" />  </td>
                        </tr>
                        <tr>
                            <td>Phone Number</td>
                            <td colspan="7"> <input type="text" name="txtPhone"  size="50" /> </td>
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
                            <th>Full Name</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Email</th>
                            <th>Phone No</th>
                            <th>Birthday</th>
                            <th>Role</th>
                                <%//if authorized then%>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            PersonDBUtil personDBUtil;
                            personDBUtil = new PersonDBUtil();
                            Role myrole = new Role();
                            boolean canEdit = false;
                            //EDIT
                            int EditID = request.getParameter("txtEdit") == null ? 0 : Integer.parseInt(request.getParameter("txtEdit"));
                            if (EditID > 0) {
                                canEdit = true;
                            }
                            //UPDATE
                            int UpdateID = request.getParameter("txtUpdate") == null ? 0 : Integer.parseInt(request.getParameter("txtUpdate"));
                            if (UpdateID > 0) {

                                String txtFullName = request.getParameter("txtPersonName");
                                String txtUserName = request.getParameter("txtUserName");
                                String txtPassword = request.getParameter("txtPassword");
                                String txtPhoneN = request.getParameter("txtPersonPhoneNo");
                                String txtEmail = request.getParameter("txtPersonEmail");
                                String txtDayofB = request.getParameter("txtPersonBirthday");
                                int cbxRoles = 0;
                                Date d = null;
                                try {
                                    cbxRoles = Integer.parseInt(request.getParameter("cbxRoles"));

                                } catch (Exception exc) {
                                    String err = exc.getMessage();
                                }

                                try {
                                    SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                                            Locale.ENGLISH);

                                    Date parsedDate = sdf.parse(txtDayofB);
                                    SimpleDateFormat print = new SimpleDateFormat("MMM d, yyyy HH:mm:ss");
                                    System.out.println(print.format(parsedDate));
                                    d = parsedDate;
                                } catch (Exception exc) {
                                    String err = exc.getMessage();
                                }
                                Person newPerson = new Person(UpdateID, cbxRoles, txtFullName, txtEmail, txtUserName,
                                        txtPassword, txtPhoneN, d);

                                personDBUtil.UpdatePerson(newPerson);
                            }

                            //DELETE
                            String DeleteID = request.getParameter("txtDelete");
                            if (DeleteID != null) {
                                personDBUtil.deletePerson(Integer.parseInt(DeleteID));
                            }
                            //SEARCH
                            String key = request.getParameter("txtKeyword") == null ? "" : request.getParameter("txtKeyword");
                            String phoneN = request.getParameter("txtPhone") == null ? "" : request.getParameter("txtPhone");
                            int personID = request.getParameter("txtID") == null || request.getParameter("txtID") == "" ? 0 : Integer.parseInt(request.getParameter("txtID"));

                            List<Person> allPeople = personDBUtil.getAllPeople(key, phoneN, personID,0);

                            for (Person onePerson : allPeople) {
                        %>
                        <tr>

                            <td class="td1"><%=onePerson.getPerson_id()%></td>
                            <td class="td1"><%=onePerson.getPerson_full_name()%></td>
                            <td class="td1"><%=onePerson.getPerson_username()%></td>
                            <td class="td1"><%=onePerson.getPerson_password()%></td>
                            <td class="td1"><%=onePerson.getPerson_email()%></td>
                            <td class="td1"><%=onePerson.getPerson_phone_no()%></td>
                            <td class="td1"><%=onePerson.getPerson_birthday()%></td>
                            <td class="td1"><%=myrole.showRole(onePerson.getRole_foreign_id())%></td>
                            <!--Edit button-->
                            <td class="td1" align=" center">
                                <form name="toEditForm" action="People.jsp" method="">  
                                    <input type="text" name="txtEdit" value="<%=onePerson.getPerson_id()%>" size="50" style="display:none" />
                                    <input class="button buttonPurple" type="submit" value="Edit"   />
                                </form>
                            </td>
                            <!--Delete Button-->
                    <form name="DeleteForm" action="People.jsp" method="">
                        <td  class="td1" align=" center"> <input type="text" name="txtDelete" value="<%=onePerson.getPerson_id()%>" size="50" style="display:none" />
                            <input class="button buttonGray" type="submit" value="Delete" name="btnDelete"   />
                        </td>
                    </form>
                    </tr>
                    <%if (EditID == onePerson.getPerson_id()) {

                    %>
                    <tr>
                    <form name="EditForm" action="People.jsp" method="">                        
                        <td class="td1"><%=onePerson.getPerson_id()%></td>
                        <td class="td1"><input type="text" name="txtPersonName" value="<%=onePerson.getPerson_full_name()%>" width="50"/></td>
                        <td class="td1"><input type="text" name="txtUserName" value="<%=onePerson.getPerson_username()%>" width="50"/></td>
                        <td class="td1"><input type="text" name="txtPassword" value="<%=onePerson.getPerson_username()%>" width="50"/></td>
                        <td class="td1"><input type="text" name="txtPersonEmail" value="<%=onePerson.getPerson_email()%>" width="50"/></td>
                        <td class="td1"><input type="text" name="txtPersonPhoneNo" value="<%=onePerson.getPerson_phone_no()%>" width="50"/></td>
                        <td class="td1"><input type="date" name="txtPersonBirthday" value="<%=onePerson.getPerson_birthday()%>" width="50"/></td>
                        <td class="td1"><select name="cbxRoles" required>
                                <option  value="">---Select---</option>
                                <option value="1">Staff</option>
                                <option value="2">Driver</option>
                                <option value="2">Not Set</option>
                            </select></td> 

                        <td class="td1" align=" center"> 
                            <input type="text" name="txtUpdate" value="<%=onePerson.getPerson_id()%>" size="50" style="display:none" />
                            <input class="button " type="submit" value="btnUpdate"   />
                        </td>
                    </form></tr>
                    <%}
                        }%>
                    </tbody>
                </table>

            </center></div>
    </body>
</html>
