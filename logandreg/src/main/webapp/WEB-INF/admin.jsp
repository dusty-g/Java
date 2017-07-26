<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>admin page</h1>

<table>
    <tr><th>Name</th><th>Email</th><th>Action</th></tr>
    <c:forEach items="${allUsers}" var="user">
        <tr><td>${user.firstName} ${user.lastName}</td><td>${user.username}</td><td><c:if test="${user.roles.contains(adminRole)}">Admin</c:if><c:if test="${!user.roles.contains(adminRole)}"><form style="display: inline-block" action="/users/delete/${user.id}" method = "post"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><input type="hidden" value="${user.id}"/><button>Delete</button></form><form style="display: inline-block" action="/users/makeadmin/${user.id}" method = "post"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><input type="hidden" value="${user.id}"/><button>make admin</button></form></c:if></td></tr>
    </c:forEach>
</table>