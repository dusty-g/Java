
<h1>search song.jsp</h1>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="/songs/new">New Song</a> <a href="/top">Top Songs</a> <form action="/search" method="post"><input type="text" name="search" value=""><button>Search</button></form>
<table>
    <tr><th>Name</th><th>Rating</th><th>Action</th></tr>
    <%--for loop here--%>
    <c:forEach items="${songs}" var="song">
        <tr><td>${song.songName}</td><td>${song.rating}</td><td><a href="/songs/delete/${song.id}">Delete</a></td></tr>

    </c:forEach>

</table>