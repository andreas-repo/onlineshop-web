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

@WebServlet("/sell")
public class SellServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        final PrintWriter out = resp.getWriter();
        out.println(beginningHtml());

        final HttpSession session = req.getSession();
        final Object obj = session.getAttribute("customer");
        if (obj instanceof Customer) {
            out.println("Article created. Your article can now be bought.");
            log("Customer " + ((Customer) obj).getEmail() + " created article.");
        } else {
            out.println("Your user is not valid! Please log in or create an account before you try to sell!");
            log("User not logged in");
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
