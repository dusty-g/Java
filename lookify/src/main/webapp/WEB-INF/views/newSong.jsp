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

<form:form method="POST" action = "/songs/new" modelAttribute="song">
    <form:label path="songName">
        Song Name:
        <form:errors path="songName"/>
        <form:input path="songName"/>
    </form:label><br>
    <form:label path="artist">
        Artist:
        <form:errors path="artist"/>
        <form:input path="artist"/>
    </form:label><br>
    <form:label path="rating">
        Rating:
        <form:errors path="rating"/>
        <form:input path="rating"/>
    </form:label><br>
    <button>Add Song</button>
</form:form>
</body>
</html>