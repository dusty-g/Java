<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form modelAttribute="person" method="post" action="/persons/new">
    <form:label path="firstName">
        First Name:
        <form:errors path="firstName"></form:errors>
        <form:input path="firstName"/>
    </form:label><br>
    <form:label path="lastName">
        Last Name:
        <form:errors path="lastName"></form:errors>
        <form:input path="lastName"/>
    </form:label><br>
    <button>Create</button>
</form:form>