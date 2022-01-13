<%@ page import="org.application.model.Customer" %>
<%@ page import="static com.sun.activation.registries.LogSupport.log" %>
<%@ include file="header.jspf"%>

    <br>
    <h1>
    <%
        String hello = "Hello World!";
        out.println(hello);

        if (application.getAttribute("n") == null) {
            application.setAttribute("n", 0);
        }

        if (session.getAttribute("s") == null) {
            session.setAttribute("s", 0);
        }

        Integer n = (Integer) application.getAttribute("n");
        int i = n + 1;
        application.setAttribute("n", i);
        out.println("Aufruf seit Deployment: " + i);

        Integer s = (Integer) session.getAttribute("s");
        int y = s + 1;
        session.setAttribute("s", y);
        out.println("Aufruf in dieser Session: " + y);
    %>
    </h1>

    <p>
        <%

            Object obj = pageContext.getAttribute("customer", PageContext.SESSION_SCOPE);

            if (obj != null) {
                Customer customer = (Customer) obj;
                log(customer.toString());
            }

        %>
    </p>

    <jsp:include page="output.jsp" flush="true">
        <jsp:param name="email" value="test@mail.com"/>
    </jsp:include>



<%@ include file="footer.jspf"%>