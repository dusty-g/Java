<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>New License</h1>
<form:form action="/licenses/new" method="post" modelAttribute="license">
    <form:hidden path="number"></form:hidden>
    <form:label path="person">
        Person:
        <form:select path="person">
            <c:forEach items="${persons}" var="x">
                <form:option value="${x.id}">${x.firstName} ${x.lastName}</form:option>

            </c:forEach>
        </form:select>
    </form:label><br>
    <form:label path="state">State:
        <form:errors path="state"></form:errors>
        <form:input path="state"/>
    </form:label><br>
    <form:label path="expirationDate">
        Expiration Date:
        <form:errors path="expirationDate"></form:errors>
        <form:input path="expirationDate" type="date"/>
    </form:label><br>
    <button>Submit</button>

</form:form>