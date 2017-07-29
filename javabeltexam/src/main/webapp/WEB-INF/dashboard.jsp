<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Dashboard</h1><form id="logoutForm" method="POST" action="/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Logout!" />
</form>

<h2>Welcome, <c:out value="${currentUser.username}"/></h2>

<form action="/users/addring" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="hidden" name="user" value="${currentUser.id}"/>
    <select name="ring">
        <c:forEach items="${availableRings}" var="ring">
            <c:if test="${!ring.owner.equals(currentUser)}">

                <option value="${ring.id}">${ring.name}</option>
            </c:if>
        </c:forEach>
    </select>

    <c:if test="${availableRings.get(0) != null}">

        <button>💍 Pick up ring</button>
    </c:if>
</form>

    <c:if test="${currentUser.roles.get(0).name.equals('ROLE_ADMIN')}">
        <a href="/admin/newring">Create new ring</a>
        <a href="/admin/guilds">Guilds stuff</a>
        </c:if>
<table>
    <tr><th>Your Rings</th><th>Action</th></tr>
    <c:forEach items="${currentUser.rings}" var="userRing">
        <tr><td>${userRing.name}</td><td><form method="post" action="/rings/delete/${userRing.id}"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><button>Drop Ring</button></form></td></tr>
    </c:forEach>
</table>