package org.application.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import static org.application.helper.HtmlTemplate.beginningHtml;
import static org.application.helper.HtmlTemplate.endHtml;

public class JdbcServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String jdbc_properties = getInitParameter("jdbc_properties");
        final ServletContext application = getServletContext();
        final InputStream in = application.getResourceAsStream(jdbc_properties);
        final Properties properties = new Properties();
        properties.load(in);

        resp.setContentType("text/html;charset=UTF-8");

        final PrintWriter out = resp.getWriter();
        out.println(beginningHtml());
        out.println("<br>driver: " + properties.getProperty("driver"));
        out.println("<br>url: " + properties.getProperty("url"));
        out.println("<br>username: " + properties.getProperty("username"));
        out.println("<br>password: " + properties.getProperty("password"));
        out.println(endHtml());
    }
}
