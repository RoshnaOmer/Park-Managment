package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import MyClasses.Person;
import MyClasses.Role;
import MyClasses.PersonDBUtil;
import java.text.SimpleDateFormat;

public final class People_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script>\n");
      out.write("            function printPage() {\n");
      out.write("                window.print();\n");
      out.write("                return  false;\n");
      out.write("            }\n");
      out.write("            function RegisterNew() {\n");
      out.write("                window.open(\"Index.jsp\");\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </script><style>\n");
      out.write("            .fullScreen\n");
      out.write("            {\n");
      out.write("                position:fixed;\n");
      out.write("                padding:0;\n");
      out.write("                margin:0;\n");
      out.write("\n");
      out.write("                top:0;\n");
      out.write("                left:0;\n");
      out.write("\n");
      out.write("                width: 100%;\n");
      out.write("                height: 100%;\n");
      out.write("                background-image: url(Images/website_background.jpg);\n");
      out.write("\n");
      out.write("                background-size: 100%;\n");
      out.write("                overflow: auto;\n");
      out.write("            }\n");
      out.write("            .table1 {\n");
      out.write("                font-family: arial, sans-serif;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .td1, th {\n");
      out.write("                border: 1px solid #dddddd;\n");
      out.write("                text-align: left;\n");
      out.write("                padding: 8px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .button {\n");
      out.write("                background-color: #4CAF50; /* Green */\n");
      out.write("                border: none;\n");
      out.write("                color: white;\n");
      out.write("                padding: 15px 32px;\n");
      out.write("                text-align: center;\n");
      out.write("                text-decoration: none;\n");
      out.write("                display: inline-block;\n");
      out.write("                font-size: 11px;\n");
      out.write("                margin: 4px 2px;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .buttonPurple{background-color: #e3c1ff; color: black;}\n");
      out.write("            .buttonGray {background-color: #e7e7e7; color: black;} /* Gray */ \n");
      out.write("            h1 {\n");
      out.write("                text-shadow: 3px 2px #e7e7e7;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <title>People</title>\n");
      out.write("    </head>\n");
      out.write("    <body >\n");
      out.write("        <div class=\"fullScreen\">\n");
      out.write("            <a href=\"loginPage.jsp\">Logout</a>\n");
      out.write("            <a href=\"MainMenu.jsp\">Go to Menu</a>\n");
      out.write("            <form >\n");
      out.write("                <input type=\"submit\" class=\"button buttonPurple\" onclick=\"RegisterNew()\" value=\"Register New\" /> \n");
      out.write("\n");
      out.write("                <input type=\"submit\" class=\"button buttonGray\" value=\"Print\" onclick=\"printPage()\" />\n");
      out.write("            </form><center><h1>People List </h1>\n");
      out.write("                <form name=\"SearchForm\" action=\"People.jsp\" method=\"\">\n");
      out.write("                    <table >\n");
      out.write("                        <tr>\n");
      out.write("                            <td>ID</td>\n");
      out.write("                            <td colspan=\"7\"> <input type=\"number\" name=\"txtID\"  size=\"50\" /> </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"1\">Name</td>\n");
      out.write("                            <td colspan=\"7\"><input type=\"text\" name=\"txtKeyword\"  size=\"50\" />  </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Phone Number</td>\n");
      out.write("                            <td colspan=\"7\"> <input type=\"text\" name=\"txtPhone\"  size=\"50\" /> </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td> <input type=\"submit\" class=\"button\" value=\"Search\" />  </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("                <table class=\"table1\" border=\"1\" cellpadding=\"1\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>ID</th>\n");
      out.write("                            <th>Full Name</th>\n");
      out.write("                            <th>Username</th>\n");
      out.write("                            <th>Password</th>\n");
      out.write("                            <th>Email</th>\n");
      out.write("                            <th>Phone No</th>\n");
      out.write("                            <th>Birthday</th>\n");
      out.write("                            <th>Role</th>\n");
      out.write("                                ");
//if authorized then
      out.write("\n");
      out.write("                            <th>Edit</th>\n");
      out.write("                            <th>Delete</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

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

                            List<Person> allPeople = personDBUtil.getAllPeople(key, phoneN, personID);

                            for (Person onePerson : allPeople) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("\n");
      out.write("                            <td class=\"td1\">");
      out.print(onePerson.getPerson_id());
      out.write("</td>\n");
      out.write("                            <td class=\"td1\">");
      out.print(onePerson.getPerson_full_name());
      out.write("</td>\n");
      out.write("                            <td class=\"td1\">");
      out.print(onePerson.getPerson_username());
      out.write("</td>\n");
      out.write("                            <td class=\"td1\">");
      out.print(onePerson.getPerson_password());
      out.write("</td>\n");
      out.write("                            <td class=\"td1\">");
      out.print(onePerson.getPerson_email());
      out.write("</td>\n");
      out.write("                            <td class=\"td1\">");
      out.print(onePerson.getPerson_phone_no());
      out.write("</td>\n");
      out.write("                            <td class=\"td1\">");
      out.print(onePerson.getPerson_birthday());
      out.write("</td>\n");
      out.write("                            <td class=\"td1\">");
      out.print(myrole.showRole(onePerson.getRole_foreign_id()));
      out.write("</td>\n");
      out.write("                            <!--Edit button-->\n");
      out.write("                            <td class=\"td1\" align=\" center\">\n");
      out.write("                                <form name=\"toEditForm\" action=\"People.jsp\" method=\"\">  \n");
      out.write("                                    <input type=\"text\" name=\"txtEdit\" value=\"");
      out.print(onePerson.getPerson_id());
      out.write("\" size=\"50\" style=\"display:none\" />\n");
      out.write("                                    <input class=\"button buttonPurple\" type=\"submit\" value=\"Edit\"   />\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                            <!--Delete Button-->\n");
      out.write("                    <form name=\"DeleteForm\" action=\"People.jsp\" method=\"\">\n");
      out.write("                        <td  class=\"td1\" align=\" center\"> <input type=\"text\" name=\"txtDelete\" value=\"");
      out.print(onePerson.getPerson_id());
      out.write("\" size=\"50\" style=\"display:none\" />\n");
      out.write("                            <input class=\"button buttonGray\" type=\"submit\" value=\"Delete\" name=\"btnDelete\"   />\n");
      out.write("                        </td>\n");
      out.write("                    </form>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
if (EditID == onePerson.getPerson_id()) {

                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                    <form name=\"EditForm\" action=\"People.jsp\" method=\"\">                        \n");
      out.write("                        <td class=\"td1\">");
      out.print(onePerson.getPerson_id());
      out.write("</td>\n");
      out.write("                        <td class=\"td1\"><input type=\"text\" name=\"txtPersonName\" value=\"");
      out.print(onePerson.getPerson_full_name());
      out.write("\" width=\"50\"/></td>\n");
      out.write("                        <td class=\"td1\"><input type=\"text\" name=\"txtUserName\" value=\"");
      out.print(onePerson.getPerson_username());
      out.write("\" width=\"50\"/></td>\n");
      out.write("                        <td class=\"td1\"><input type=\"text\" name=\"txtPassword\" value=\"");
      out.print(onePerson.getPerson_username());
      out.write("\" width=\"50\"/></td>\n");
      out.write("                        <td class=\"td1\"><input type=\"text\" name=\"txtPersonEmail\" value=\"");
      out.print(onePerson.getPerson_email());
      out.write("\" width=\"50\"/></td>\n");
      out.write("                        <td class=\"td1\"><input type=\"text\" name=\"txtPersonPhoneNo\" value=\"");
      out.print(onePerson.getPerson_phone_no());
      out.write("\" width=\"50\"/></td>\n");
      out.write("                        <td class=\"td1\"><input type=\"date\" name=\"txtPersonBirthday\" value=\"");
      out.print(onePerson.getPerson_birthday());
      out.write("\" width=\"50\"/></td>\n");
      out.write("                        <td class=\"td1\"><select name=\"cbxRoles\">\n");
      out.write("                                <option>---Select---</option>\n");
      out.write("                                <option value=\"1\">Staff</option>\n");
      out.write("                                <option value=\"2\">Driver</option>\n");
      out.write("                                <option value=\"2\">Not Set</option>\n");
      out.write("                            </select></td> \n");
      out.write("\n");
      out.write("                        <td class=\"td1\" align=\" center\"> \n");
      out.write("                            <input type=\"text\" name=\"txtUpdate\" value=\"");
      out.print(onePerson.getPerson_id());
      out.write("\" size=\"50\" style=\"display:none\" />\n");
      out.write("                            <input class=\"button \" type=\"submit\" value=\"btnUpdate\"   />\n");
      out.write("                        </td>\n");
      out.write("                    </form></tr>\n");
      out.write("                    ");
}
                        }
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("            </center></div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
