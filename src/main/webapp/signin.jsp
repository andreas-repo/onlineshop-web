<%@ include file="header.jspf"%>

    <form action="signin" method="post">
        <fieldset>
            <legend>Login</legend>
            <table>
                <tbody>
                <tr>
                    <th>
                        <label for="email">E-Mail:</label>
                    </th>
                    <td>
                        <input
                                type="email"
                                name="email"
                                size="40"
                                maxlength="40"
                                title="muster@example.com"
                                placeholder="Input email"
                                pattern=".{6, 40}"
                                required="required">
                    </td>
                </tr>
                <tr>
                    <th>
                        <label for="password">
                            Password:
                        </label>
                    </th>
                    <td>
                        <input
                                type="password"
                                name="password"
                                size="10"
                                maxlength="10"
                                title="6-10 characters"
                                placeholder="Input password"
                                pattern=".{6, 10}"
                                required="required">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit">
                        <input type="reset">
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </form>

    <%@ page import="org.application.model.*" %>
    <%
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if ( email != null && password != null) {
            Customer customer = new Customer(email, password);

            pageContext.setAttribute("customer", customer, PageContext.SESSION_SCOPE);
        }
    %>

<%@ include file="footer.jspf"%>