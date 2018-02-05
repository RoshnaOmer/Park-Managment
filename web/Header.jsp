<%-- 
    Document   : Header
    Created on : Feb 2, 2018, 9:42:16 PM
    Author     : roshn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <style>
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
            }

            li {
                float: left;
            }

            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover {
                background-color: #111;
            }
        </style>
    </head>

</head>
<body>
    <div id=”header”>

        <!--Logo | some text here-->

    </div>

    <div id=”menu”>

        <!--            <a href="loginPage.jsp">Logout</a>
                    <a href="MainMenu.jsp"> </a>-->

        <ul>
            <li><a  href="MainMenu.jsp">Main</a></li>
                <%  String role = (String) session.getAttribute("role");
          if (role!=null&&role.equals("1")) {%>

            <li><a href="People.jsp">People</a></li>
            <li ><a href="Car.jsp">Cars</a></li><%}%>
            <li><a href="Park.jsp">Park</a></li>
            <li style="float:right"><a href="loginPage.jsp?logout=true">Logout</a></li>
        </ul>

    </div>
</body>
</html>
