package org.application.servlets;

import org.application.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

import static org.application.helper.HtmlTemplate.beginningHtml;
import static org.application.helper.HtmlTemplate.endHtml;

@WebServlet("/sell")
//needed to work with multiparts of the article photo
@MultipartConfig
public class SellServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get part from request
        final Part part = req.getPart("photo");

        resp.setContentType("text/html; charset=UTF-8");

        final PrintWriter out = resp.getWriter();
        out.println(beginningHtml());

        final HttpSession session = req.getSession();
        final Object obj = session.getAttribute("customer");
        if (obj instanceof Customer) {
            out.println("Article created. Your article can now be bought. \r\n");
            log("Customer " + ((Customer) obj).getEmail() + " created article.");
        } else {
            out.println("Your user is not valid! Please log in or create an account before you try to sell! \r\n");
            log("User not logged in");
        }

        //print data from the submitted photo part
        out.println("Content-Type: " + part.getContentType() + "\r\n");
        out.println("Size: " + part.getSize() + "\r\n");
        out.println("Name: " + part.getName() + "\r\n");
        out.println("Filename: " + part.getSubmittedFileName() + "\r\n");

        out.println(endHtml());
    }


}
