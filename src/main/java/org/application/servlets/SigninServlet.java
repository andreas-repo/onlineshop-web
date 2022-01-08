package org.application.servlets;

import org.application.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //set content-type
        resp.setContentType("text/html; charset=UTF-8");
        //get email & password from request
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");

        //prepare email and password cookies
        String email_cookie = null;
        String password_cookie = null;

        ServletOutputStream out =
                resp.getOutputStream();

        out.println(beginningHtml());
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>Cookie-Name</td>");
        out.println("<td>Cookie-Value</td>");
        out.println("</td>");

        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            out.println("<tr>");
            out.println("<td>" + name + "</td>");
            out.println("<td>" + value + "</td>");
            out.println("</tr>");

            if ("email".equals(name)) {
                email_cookie = value;
            } else if ("password".equals(name)) {
                password_cookie = value;
            }
        }

        out.println("</table>");

        if ( email.equals(email_cookie) && password.equals(password_cookie) ) {
            final Customer customer = new Customer();
            customer.setEmail(email);
            customer.setPassword(password);

            final HttpSession session = req.getSession();
            session.setAttribute("customer", customer);

            out.println("<h1>User is valid!</h1>");
        } else {
            out.println("<h1>User is not valid!</h1>");
        }
        out.println(endHtml());
    }

    private static String beginningHtml() {
        return new String("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n");
    }

    private static String endHtml() {
        return new String("</body>\n" +
                "</html>");
    }
}
