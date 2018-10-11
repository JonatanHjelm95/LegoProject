/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jonab
 */
public class HTMLGenerator {

    String html = "<div class=\"topnav\">\n"
            + "            <a id=\"login\" href=\"?origin=signup\">sign up</a>\n"
            + "            <a id=\"login\" href=\"?origin=login\">Login</a>\n"
            + "            <h1 id=\"header\" ></h1>\n"
            + "            <a id=\"home\" class=\"active\" href=\"?origin=index\">Home</a>\n"
            + "            <a id=\"products\" href=\"?origin=products\">Products</a>\n"
            + "        </div>";

    public String generateMenu(HttpServletRequest request) {
        String menuHTML = "";
        User user = null;
        if (request.getSession(false) != null) {
            try {
                user = (User) request.getSession(false).getAttribute("user");
                menuHTML = "<div class=\"topnav\">\n"
                        + "<a id=\"login\" href=\"?origin=logout\">logout</a>"
                        + "<h4 id=\"user\" > Logged in as: " + user.getEmail() + "</h4>\n"
                        + "<h1 id=\"header\" ></h1>\n"
                        + "<a id=\"home\" class=\"active\" href=\"?origin=index\">Home</a>\n"
                        + "<a id=\"products\" href=\"?origin=products\">Products</a>\n"
                        + "</div>";
                return menuHTML;
            } catch (NullPointerException ne) {
                ne.printStackTrace();
            }
        }
        menuHTML = "<div class=\"topnav\">\n"
                + "            <a id=\"login\" href=\"?origin=signup\">sign up</a>\n"
                + "            <a id=\"login\" href=\"registerpage.jsp\">Login</a>\n"
                + "            <h1 id=\"header\" ></h1>\n"
                + "            <a id=\"home\" class=\"active\" href=\"?origin=index\">Home</a>\n"
                + "            <a id=\"products\" href=\"?origin=products\">Products</a>\n"
                + "        </div>";
        return menuHTML;
    }

}
