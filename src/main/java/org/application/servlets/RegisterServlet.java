package org.application.servlets;

import org.application.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<br>Your stated data:");
        out.println("<br>Email: " + email);
        out.println("<br>Password: " + password);
        out.println("</body>");
        out.println("</html>");

        //create customer object
        Customer customer = new Customer(email, password);
        //save userdata until session is closed
        session.setAttribute("customer", customer);


        //set status code of request, this is set last to be sure the correct/full data has been received
        resp.setStatus(HttpServletResponse.SC_ACCEPTED);
    }
}
