<%@page language="Java" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" isErrorPage="true" %>
<html>
<head>
    <title>Example Error Page</title>
</head>
<body>
    An error occurred!
    Please alert our web admin via email:
    admin@fake.com
    <%= out.println(exception) %>
</body>
</html>
