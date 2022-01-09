package org.application.servlets;

import org.application.model.Customer;
import org.application.service.PhotoService;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import static org.application.helper.HtmlTemplate.beginningHtml;
import static org.application.helper.HtmlTemplate.endHtml;

@WebServlet(value = "/sell", asyncSupported = true) //<< OPTIONAL sets the async to true/false
//needed to work with multiparts of the article photo
@MultipartConfig(
        location = "C:\\Users\\andre\\Development\\jarkata-ee-examples\\onlineshop-web\\src\\main\\webapp\\resources\\tmp",
        fileSizeThreshold = 1024*1024, //<<saves files locally if it oversteps this threshold to the /tmp location, OPTIONAL because  it slows down the download/upload process, can be also set over web.xml descriptors
        maxFileSize = 1024*1024*10, //max per file 10mb
        maxRequestSize = 1024*1024*30) //<< limits the total amount to 3*10mb
public class SellServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String title = req.getParameter("title");
        final String description = req.getParameter("description");
        final String price = req.getParameter("price");
        //get part from request
        final Part part = req.getPart("photo");

        //get input stream via part
        InputStream is = part.getInputStream();
        //get file name of submitted photo to use as path
        String path = "C:\\Users\\andre\\Development\\jarkata-ee-examples\\onlineshop-web\\src\\main\\webapp\\resources\\tmp\\" + part.getSubmittedFileName();
        File file = new File(path);
        OutputStream os = new FileOutputStream(file);

        resp.setContentType("text/html; charset=UTF-8");

        final PrintWriter out = resp.getWriter();
        out.println(beginningHtml());

        final HttpSession session = req.getSession();
        final Object obj = session.getAttribute("customer");
        if (obj instanceof Customer) {
            out.println("Article created. Your article can now be bought.<br>");
            log("Customer " + ((Customer) obj).getEmail() + " created article.");
        } else {
            out.println("Your user is not valid! Please log in or create an account before you try to sell!<br>");
            log("User not logged in");
        }

        //print data from the submitted photo part
        out.println("Content-Type: " + part.getContentType() + "<br>");
        out.println("Size: " + part.getSize() + "<br>");
        out.println("Name: " + part.getName() + "<br>");
        out.println("Filename: " + part.getSubmittedFileName() + "<br>");

        out.println("<br>Uploaded Article: " + title);
        out.println("<br>Description: " +description);
        out.println("<br>Picture: " + price);
        out.println("<br>Picture: " + part.getSubmittedFileName());

        out.println("<br>Picture has been loaded to " + file.getAbsolutePath());

        out.println(endHtml());

        final AsyncContext asyncContext = req.startAsync();
        asyncContext.start(new PhotoService(asyncContext));
    }
}
