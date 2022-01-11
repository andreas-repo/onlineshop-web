package org.application.demo.http2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/serverpush"})
public class ServerPushServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PushBuilder pushBuilder = req.newPushBuilder();

        if (pushBuilder != null) {
            pushBuilder.path("resources/img/tau.jpg")
                    .addHeader("content-type", "image/jpg")
                    .push();
        }
        try (PrintWriter respWriter = resp.getWriter()) {
            respWriter.write("<html><img src='resources/img/tau.jpg'></html>");
        }
    }
}
