<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${dojo} Ninjas</h1>
<table>
    <tr><th>First Name</th><th>Last Name</th><th>Age</th></tr>
    <c:forEach items="${ninjas}" var="ninja">
        <tr><td>${ninja.firstName}</td><td>${ninja.lastName}</td><td>${ninja.age}</td></tr>
    </c:forEach>
</table>