<%@ include file="header.jspf"%>

    <br>Work in Progress
    <br>
    <p>
        <%
            String jdbcProperties = config.getInitParameter("jdbc_properties");
            java.io.InputStream in = application.getResourceAsStream(jdbcProperties);
            java.util.Properties properties = new java.util.Properties();
            properties.load(in);
            out.println(properties);
        %>
    </p>

<%@ include file="footer.jspf"%>