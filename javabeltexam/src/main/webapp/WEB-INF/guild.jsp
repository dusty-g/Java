<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<head><link href="/public/style.css" rel="stylesheet"></head>
<a href="/admin/guilds">back</a>
<h1>${guild.name}</h1>
<p>Team Status: ${guild.users.size()} / ${guild.guildSize}</p>
<table class="box">
    <tr>
        <th>Name</th><th>Age</th><th>Action</th>
    </tr>
    <c:forEach items="${guild.users}" var="user">
        <tr>
            <td>${user.username}</td>
            <td> <c:out value="${Math.floor((now.getTime()- user.createdAt.getTime())/(1000*60*60*24)).intValue()}"/> days</td>
            <td>
                <form class = "box" action="/admin/users/delete/${user.id}" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button>Delete</button>
                </form>/  <a href="/admin/users/update/${user.id}" >
                <button>Update</button></a>
            </td>
        </tr>
    </c:forEach>
</table>