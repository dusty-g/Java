<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<form:form method="POST" action="/languages/edit/${id}" modelAttribute="language">
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