package org.application.servlets;

import org.application.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        //create customer obj from email & password
        final Customer customer = new Customer(email, password);
        //create session object from session from request
        final HttpSession session = req.getSession();
        //set customer as attribute of session
        session.setAttribute("customer", customer);

        final RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
        //forward back to index.html
        requestDispatcher.forward(req, resp);

        //logging of the accessing ip
        String address = req.getRemoteAddr();
        log("Remote address: " + address);
        //logging of input data
        log("Stated data:");
        log("email: " + email);
        log("password: " + password);
    }
}
