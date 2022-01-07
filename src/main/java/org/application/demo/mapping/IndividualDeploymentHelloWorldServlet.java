package org.application.demo.mapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndividualDeploymentHelloWorldServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /*
    Servlet Lifecycle
    1.) init()
    2.) service(ServletRequest, ServletResponse)
    3.) destroy()

    Implementation:
    HttpServlet
     */

    public IndividualDeploymentHelloWorldServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at: ").append(req.getContextPath()).append("\n Example of individual servlet deployment setup over web.xml. Not needed if annotation @WebServlet is used. \n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
