<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<head><link href="/public/style.css" rel="stylesheet"></head>

<h1>guilds</h1>
<h2>Welcome ${currentUser.username}</h2>
<a href="/">home</a>


<table class="box">
    <tr>
        <th>Name</th><th>Guilds</th><th>Age</th><th>Action</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.username}</td><td><c:forEach items="${user.guilds}" var="guild"> <a href="/admin/guilds/${guild.id}">(${guild.name})</a> </c:forEach></td>
            <td> <c:out value="${Math.floor((now.getTime()- user.createdAt.getTime())/(1000*60*60*24)).intValue()}"/> days</td>
            <td>
            <form action="/admin/users/delete/${user.id}" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button>Delete</button>
        </form>/  <form action="/admin/users/makeadmin/${user.id}" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button>Make Admin</button>
            </form></td>
        </tr>
    </c:forEach>
</table>
<div class="box">
<h2>Add player to guild:</h2>
<form action="/admin/addplayer" method="post">
    Player: <select name="playerId">
        <c:forEach var="player" items="${users}">

            <option value="${player.id}">${player.username}</option>
        </c:forEach>
    </select><br>
    Guild: <select name="guildId">
                <c:forEach var="guild" items="${guilds}">
                    <option value="${guild.id}">${guild.name}</option>
                </c:forEach>
            </select><br>
    <button>Join</button>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

</form>
</div>
<div class="box">
<h2>New Guild:</h2>
<form action="/admin/newguild" method="post">
    <p>Team Name: <input type="text" name="name"/></p>
    <p>Team Size: <input type="number" name="size"/></p>
    <button>Create</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

</form>
</div>