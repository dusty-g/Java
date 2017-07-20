<!DOCTYPE html>
<html lang="en">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<a href="/songs/new">New Song</a> <a href="/songs/top">Top Songs</a> <form action="/search" method="post"><input type="text" name="search" value=""><button>Search</button></form>
<table>
    <tr><th>Name</th><th>Rating</th><th>Action</th></tr>
    <%--for loop here--%>
    <c:forEach items="${songs}" var="song">
        <tr><td><a href="/songs/${song.id}">${song.songName}</a></td><td>${song.rating}</td><td><a href="/songs/delete/${song.id}">Delete</a></td></tr>

    </c:forEach>

</table>
</body>
</html>