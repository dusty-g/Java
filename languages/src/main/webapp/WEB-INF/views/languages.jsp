<!DOCTYPE html>
<html lang="en">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Languages</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<table>
    <tr><th>Name</th><th>Creator</th><th>Version</th><th>Action</th></tr>
    <c:forEach items="${languages}" var="lang" varStatus="loop">
        <tr>
            <td><a href="/languages/${lang.id}">${lang.language_name}</a></td>
            <td>${lang.creator}</td>
            <td>${lang.version}</td>
            <td><a href="/languages/delete/${lang.id}">Delete</a> <a href="/languages/edit/${lang.id}">Edit</a> </td>
        </tr>
    </c:forEach>
</table>
<form:form method="POST" action="/languages" modelAttribute="language">
    <form:label path="language_name">Name:
        <form:errors path="language_name"/>
        <form:input path="language_name"/>
    </form:label><br>
    <form:label path="creator">Creator:
        <form:errors path="creator"/>
        <form:input path="creator"/>
    </form:label><br>
    <form:label path="version">Version:
        <form:errors path="version"/>
        <form:input path="version"/>
    </form:label><br>
    <input type="submit" value="Submit">
</form:form>

</body>
</html>