package org.application.servlets;

import org.application.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    //response with a html site to the get-request
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html");
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>You have yourself successful registered!</h1>");
        out.println("Date: " + LocalDate.now());
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");

        final PrintWriter out = resp.getWriter();

        //logging of the accessing ip
        String address = req.getRemoteAddr();
        log("Remote address: " + address);
        log("Stated data:");
        log("email: " + email);
        log("password: " + password);

        //set the header content type
        resp.setContentType("text/html; charset=UTF-8");

        //create cookie with customer email address
        final Cookie customer_email_email = new Cookie("email", email);
        //add cookie to response
        resp.addCookie(customer_email_email);
        //create cookie with customer password
        final Cookie customer_password_cookie = new Cookie("password", password);
        //add cookie to request
        resp.addCookie(customer_password_cookie);

        //create a dispatcher
        final RequestDispatcher dispatcher = req.getRequestDispatcher("index.html");
        //forward via dispatcher
        dispatcher.forward(req, resp);

        //set status code of request, this is set last to be sure the correct/full data has been received
        resp.setStatus(HttpServletResponse.SC_ACCEPTED);
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
