<%--
  Created by IntelliJ IDEA.
  User: dusty
  Date: 7/28/17
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<p>Change user's name:</p>
<form method="post" action="/admin/users/update/${id}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <p>Name: <input name="username" value="${username}"/> </p>
    <button>Update</button>
</form>
</body>
</html>
