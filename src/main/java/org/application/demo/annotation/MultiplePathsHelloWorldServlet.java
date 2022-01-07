package org.application.demo.annotation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//multiple paths to the servlet
//sets load-on-startup like our manual web.xml example
@WebServlet(urlPatterns = {"/path1", "/path2"}, loadOnStartup = 1)
public class MultiplePathsHelloWorldServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /*
    Servlet Lifecycle
    1.) init()
    2.) service(ServletRequest, ServletResponse)
    3.) destroy()

    Implementation:
    HttpServlet
     */

    public MultiplePathsHelloWorldServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at: ")
                .append(req.getContextPath())
                .append("\n Accessible through multiple paths /path1 and /path2 \n Sets load-on-startup like our web.xml example");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
