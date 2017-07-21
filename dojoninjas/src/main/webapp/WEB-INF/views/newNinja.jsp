<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>New Ninja</h1>
<form:form modelAttribute="ninja" method="post" action="/ninjas/new">
    <form:label path="dojo">
        Dojo:
        <form:select path="dojo">
            <c:forEach var="x" items="${dojos}" >
                <form:option value="${x.id}">${x.dojoName}</form:option>
            </c:forEach>
        </form:select>
    </form:label><br>
    <form:label path="firstName">
        First Name:
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </form:label><br>
    <form:label path="lastName">
        Last Name:
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </form:label><br>
    <form:label path="age">
        Age:
        <form:errors path="age"/>
        <form:input path="age"/>
    </form:label><br>
    <button>Create</button>

</form:form>