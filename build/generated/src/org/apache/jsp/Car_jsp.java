package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import MyClasses.Person;
import MyClasses.PersonDBUtil;
import MyClasses.Car;
import MyClasses.CarDBUtil;
import java.text.SimpleDateFormat;

public final class Car_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                window.open(\"NewCar.jsp\");\n");
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
      out.write("        <title>Car</title>\n");
      out.write("    </head>\n");
      out.write("    <body >\n");
      out.write("        <div class=\"fullScreen\">\n");
      out.write("            <a href=\"loginPage.jsp\">Logout</a>\n");
      out.write("            <a href=\"MainMenu.jsp\">Go to Menu</a>\n");
      out.write("            <form >\n");
      out.write("                <input type=\"submit\" class=\"button buttonPurple\" onclick=\"RegisterNew()\" value=\"Add New\" /> \n");
      out.write("\n");
      out.write("                <input type=\"submit\" class=\"button buttonGray\" value=\"Print\" onclick=\"printPage()\" />\n");
      out.write("            </form><center><h1>Car List </h1>\n");
      out.write("                <form name=\"SearchForm\" action=\"Car.jsp\" method=\"\">\n");
      out.write("                    <table >\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"1\">Model</td>\n");
      out.write("                            <td colspan=\"7\"><input type=\"text\" name=\"txtKeyword\"  size=\"50\" />  </td>\n");
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
      out.write("                            <th>Model</th>\n");
      out.write("                            <th>License N</th>\n");
      out.write("                            <th>Color</th>\n");
      out.write("                            <th>Owner</th>\n");
      out.write("                            <th>Phone No</th>\n");
      out.write("                            \n");
      out.write("                                ");
//if authorized then
      out.write("\n");
      out.write("                            <th>Edit</th>\n");
      out.write("                            <th>Delete</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

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
                                String txtCar_color = request.getParameter("txtCar_color");
                                int txtCar_driver_foreign_id = Integer.getInteger(request.getParameter("txtCar_driver_foreign_id"));

                                Car newCar = new Car(UpdateID, txtCar_driver_foreign_id, txtCar_color, txtCar_model, txtCar_licence_number);

//                                carDBUtil.UpdateCar(newCar);
                            }

                            //DELETE
                            String DeleteID = request.getParameter("txtDelete");
                            if (DeleteID != null) {
                                carDBUtil.deleteCar(Integer.parseInt(DeleteID));
                            }
                            //SEARCH
                            String key = request.getParameter("txtKeyword") == null ? "" : request.getParameter("txtKeyword");
                           
                            List<Car> allCars = carDBUtil.getAllCars(key);

                            for (Car oneCar : allCars) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("\n");
      out.write("                            <td class=\"td1\">");
      out.print(oneCar.getCar_id());
      out.write("</td>\n");
      out.write("                            <td class=\"td1\">");
      out.print(oneCar.getCar_model());
      out.write("</td>\n");
      out.write("                            <td class=\"td1\">");
      out.print(oneCar.getCar_licence_number());
      out.write("</td>\n");
      out.write("                            <td class=\"td1\">");
      out.print(oneCar.getCar_color());
      out.write("</td>\n");
      out.write("                            <td class=\"td1\">");
      out.print(oneCar.getCar_driver_foreign_id());
      out.write("</td>\n");
      out.write("                            <!--Edit button-->\n");
      out.write("                            <td class=\"td1\" align=\" center\">\n");
      out.write("                                <form name=\"toEditForm\" action=\"Car.jsp\" method=\"\">  \n");
      out.write("                                    <input type=\"text\" name=\"txtEdit\" value=\"");
      out.print(oneCar.getCar_id());
      out.write("\" size=\"50\" style=\"display:none\" />\n");
      out.write("                                    <input class=\"button buttonPurple\" type=\"submit\" value=\"Edit\"   />\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                            <!--Delete Button-->\n");
      out.write("                    <form name=\"DeleteForm\" action=\"Car.jsp\" method=\"\">\n");
      out.write("                        <td  class=\"td1\" align=\" center\"> <input type=\"text\" name=\"txtDelete\" value=\"");
      out.print(oneCar.getCar_id());
      out.write("\" size=\"50\" style=\"display:none\" />\n");
      out.write("                            <input class=\"button buttonGray\" type=\"submit\" value=\"Delete\" name=\"btnDelete\"   />\n");
      out.write("                        </td>\n");
      out.write("                    </form>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
if (EditID == oneCar.getCar_id()) {

                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                    <form name=\"EditForm\" action=\"Car.jsp\" method=\"\">                        \n");
      out.write("                        <td class=\"td1\">");
      out.print(oneCar.getCar_id());
      out.write("</td>\n");
      out.write("                        <td class=\"td1\"><input type=\"text\" name=\"txtCar_model\" value=\"");
      out.print(oneCar.getCar_model());
      out.write("\" width=\"50\"/></td>\n");
      out.write("                        <td class=\"td1\"><input type=\"text\" name=\"txtCar_licence_number\" value=\"");
      out.print(oneCar.getCar_licence_number());
      out.write("\" width=\"50\"/></td>\n");
      out.write("                    <td>\n");
      out.write("                            <select required name=\"cbxColor\">\n");
      out.write("                                <option  value=\"");
      out.print(oneCar.getCar_color());
      out.write('"');
      out.write('>');
      out.print(oneCar.getCar_color());
      out.write("</option>\n");
      out.write("                                <option value=\"Black\">Black</option>\n");
      out.write("                                <option value=\"White\">White</option>\n");
      out.write("                                <option value=\"Blue\">Blue</option>\n");
      out.write("                                <option value=\"Red\">Red</option>\n");
      out.write("                                <option value=\"Other\">Other</option>\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("<!--                        <td class=\"td1\"><input type=\"text\" name=\"txtCar_driver_foreign_id\" value=\"");
      out.print(oneCar.getCar_driver_foreign_id());
      out.write("\" width=\"50\"/></td>-->\n");
      out.write("  <td>\n");
      out.write("                            <select required name=\"cbxOwner\">\n");
      out.write("                                <option  value=\"\">---Select---</option>\n");
      out.write("                                \n");
      out.write("                                ");

                            PersonDBUtil personDBUtil = new PersonDBUtil();
                            List<Person> allPeople = personDBUtil.getAllPeople("", "", 0);

                            for (Person onePerson : allPeople) { 
      out.write("\n");
      out.write("                                <option value=\"");
      out.print(onePerson.getPerson_id());
      out.write('"');
      out.write('>');
      out.print(onePerson.getPerson_full_name());
      out.write("</option>\n");
      out.write("                                \n");
      out.write("                    ");
}
                        
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                        <td class=\"td1\" align=\" center\"> \n");
      out.write("                            <input type=\"text\" name=\"txtUpdate\" value=\"");
      out.print(oneCar.getCar_id());
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
